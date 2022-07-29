package com.eminkabacaoglu.finalproject.repository;

import com.eminkabacaoglu.finalproject.model.Policy;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
