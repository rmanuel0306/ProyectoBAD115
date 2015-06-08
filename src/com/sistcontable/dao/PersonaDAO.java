/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistcontable.dao;

import com.sistcontable.hibernate.util.HibernateUtil;
import com.sistcontable.model.Persona;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 *
 * @author Manuel Miranda
 */
public class PersonaDAO {
    
    public List<Persona> searchAllPerson(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Persona> lista =new ArrayList();
        try{
            String query = "select * from persona";
            SQLQuery sqlQuery = session.createSQLQuery(query);
            sqlQuery.addEntity(Persona.class);
               
            lista = sqlQuery.list();
            
        }catch (Exception e){
            System.out.println("ERROR " + e);
            lista = null;
        }finally{
            session.close();
        }
        return lista;
    }
    
}
