package com.eminkabacaoglu.finalproject.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
@Repository
public class PaymentRepository {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //Returns year and total payments of every year
    public LinkedHashMap<String,Double> paymentsByYear() {

        LinkedHashMap<String,Double> policyPayments= new LinkedHashMap<>();
        try{
            Session session = this.sessionFactory.openSession();
            String hql = "select extract(year from p.date) as year,sum(p.payment_amount) as amount from Payment as p group by year order by year";
            List<Object> list = session.createQuery(hql).getResultList();

            for(int i=0; i<list.size(); i++){
                Object[] row = (Object[]) list.get(i);
                // first value (0. index) represents year
                String year=row[0].toString();
                // second value (1. index) represents total payment
                double payment = (double) row[1];
                policyPayments.put(year,payment);
            }

        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }

        return policyPayments;
    }
}
