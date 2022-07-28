package repository;

import model.Agency;
import model.Policy;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import service.CustomerPolicyService;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
@Repository
public class PolicyRepository {


    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public PolicyRepository() {


    }


    public Policy getPolicy(long id){

        Session session = this.sessionFactory.openSession();

        try{
            Policy policy = session.get(Policy.class, id);
            if (policy != null) {
                return policy;
            }
        }

        catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }
}
