package com.eminkabacaoglu.finalproject.repository;

import com.eminkabacaoglu.finalproject.model.Agency;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AgencyRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public AgencyRepository() {

    }


    public Agency getAgency(long id){

        Session session = this.sessionFactory.openSession();

        try{
            Agency agency = session.get(Agency.class, id);
            if (agency != null) {
                return agency;
            }
        }
        catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }
}
