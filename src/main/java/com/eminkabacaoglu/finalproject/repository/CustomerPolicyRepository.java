package com.eminkabacaoglu.finalproject.repository;

import com.eminkabacaoglu.finalproject.model.Agency;
import com.eminkabacaoglu.finalproject.model.AgencyPerformance;
import com.eminkabacaoglu.finalproject.model.CustomerPolicy;
import com.eminkabacaoglu.finalproject.model.Policy;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

// import javax.persistence.Query;

@Repository
public class CustomerPolicyRepository {


    private PolicyRepository policyRepository;

    private AgencyRepository agencyRepository;

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public CustomerPolicyRepository() {

        this.policyRepository = new PolicyRepository();
        this.agencyRepository = new AgencyRepository();
    }


    //Returns policy and total amount: to find total amount of every policy type
    public LinkedHashMap<Policy,Double> policyAmountByPolicyType() {

        LinkedHashMap<Policy,Double> policyAmounts = new LinkedHashMap<>();
        try {

        Session session = this.sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
        Root<CustomerPolicy> root = criteriaQuery.from(CustomerPolicy.class);
        criteriaQuery.multiselect(root.get("policy_id"),criteriaBuilder.sum(root.get("insurance_amount")));
        criteriaQuery.groupBy(root.get("policy_id"));
        Query<Object[]> query = session.createQuery(criteriaQuery);

        List<Object[]> resultList = query.getResultList();

        AbstractApplicationContext ctx = null;
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        PolicyRepository polRepos = ctx.getBean(PolicyRepository.class);

        for(int i=0; i<resultList.size(); i++){
            Object[] row = (Object[]) resultList.get(i);
            // find policy by using policy_id from result of query.To pass Policy object to LinkedHashMap. first value (0. index) represents policy_id
            Policy policy=polRepos.getPolicy((long) row[0]);
            double payment = (double) row[1];
            policyAmounts.put(policy,payment);
        }

        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        return policyAmounts;
    }



    //Returns city name and quantity of policies: to find quantity of total policies for every unique city of agencies
    public LinkedHashMap<String,Integer> quantityOfPoliciesByCity() {
        LinkedHashMap<String,Integer> quantityOfPolicies= new LinkedHashMap<>();
        try{
            Session session = this.sessionFactory.openSession();
            String hql = "select count(*) as NumberofPolicies,a.city from CustomerPolicy as cp inner join cp.agency as a group by a.city";
            List<Object> list = session.createQuery(hql).getResultList();
            for(int i=0; i<list.size(); i++){
                Object[] row = (Object[]) list.get(i);
                // first value (0. index) represents quantity
                int quantity=Integer.parseInt(row[0].toString());
                // second value (1. index) represents city
                String city = (String) row[1];
                quantityOfPolicies.put(city,quantity);
            }

        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        return quantityOfPolicies;
    }


    //Returns AgencyPergormance class: to find performance of every agency by values of total quantity of policies, total amount of policies , total amount of payments paid by customers for customer policies and ratio of total payments by customer/ total amount of customer policies
    public List<AgencyPerformance> agencyPerformance() {
        try {
            List<AgencyPerformance> agencyPerformanceList= new ArrayList<>();
            Session session = this.sessionFactory.openSession();
            Query queryResult = session.createNativeQuery("select a.id,count(*) as PolicyNumber,sum(cp.insurance_amount) as policyAmount,sum(p.payment_amount) \n" +
                    "as policyPayments,sum(p.payment_amount)/sum(cp.insurance_amount)*100 as ratioOfPaymentsByAmount\n" +
                    "from customer_policy cp,agency a,payment p  where cp.agency_id =a.id and cp.id =p.customer_policy_id\n" +
                    "group by a.id order by a.agency_name asc  ");
            List<Object[]> agencyPerfList = queryResult.getResultList();
            AbstractApplicationContext ctx = null;
            ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
            AgencyRepository agencyRepo = ctx.getBean(AgencyRepository.class);
            for (Object[] o: agencyPerfList) {
                // find agency by using agency_id from result of query
                Agency agency = agencyRepo.getAgency(((BigInteger) o[0]).longValue());
                AgencyPerformance agencyPerformance = new AgencyPerformance(agency,((BigInteger) o[1]).intValue(),((BigDecimal) o[2]).floatValue(),((BigDecimal) o[3]).floatValue(),((BigDecimal) o[4]).floatValue());
                agencyPerformanceList.add(agencyPerformance);

            }


            return agencyPerformanceList;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return new ArrayList<AgencyPerformance>();
        }
    }


}
