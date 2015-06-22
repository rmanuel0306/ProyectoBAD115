/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistcontable.dao;

import com.sistcontable.hibernate.util.HibernateUtil;
import com.sistcontable.model.Rubro;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 *
 * @author Administrador
 */
public class RubroDAO {
    
        public void searchRubroByID(String id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Rubro> lista =new ArrayList();
        try{
            String query = "select * from rubro where ID_RUBRO=:idRubro";
            SQLQuery sqlQuery = session.createSQLQuery(query);
            sqlQuery.addEntity(Rubro.class);
            sqlQuery.setParameter("idRubro", id); 
            List result = sqlQuery.list();
            
            for(int i=0;i<result.size();i++){
                System.out.println("id: ");
                Rubro rubro = (Rubro)result.get(i);
                
                System.out.println("idRubro: "+rubro.getIdRubro());
                System.out.println("nombreRubro: "+rubro.getNombreRubro());
                System.out.println("tipoRubro: "+rubro.getTipoRubro());

            }            
        }catch (Exception e){
            System.out.println("ERROR " + e);
            lista = null;
        }finally{
            session.close();
        }
    }
        
    public Rubro obtenerRubroByID(String id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Rubro> lista =new ArrayList();
        try{
            String query = "select * from rubro where ID_RUBRO=:idRubro";
            SQLQuery sqlQuery = session.createSQLQuery(query);
            sqlQuery.addEntity(Rubro.class);
            sqlQuery.setParameter("idRubro", id); 
            List result = sqlQuery.list();
            
            for(int i=0;i<result.size();i++){
                System.out.println("id: ");
                Rubro rubro = (Rubro)result.get(i);
                
                System.out.println("idRubro: "+rubro.getIdRubro());
                System.out.println("nombreRubro: "+rubro.getNombreRubro());
                System.out.println("tipoRubro: "+rubro.getTipoRubro());

            }    

            return (Rubro)result.get(0);
        }catch (Exception e){
            System.out.println("ERROR " + e);
            lista = null;
            return null;
        }finally{
            session.close();
        }
    }
    
    
        public List<Rubro> searchAllRubros(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Rubro> lista =new ArrayList();
        try{
            String query = "select * from rubro";
            SQLQuery sqlQuery = session.createSQLQuery(query);
            sqlQuery.addEntity(Rubro.class);               
            lista = sqlQuery.list(); 
            
            for(int i=0; i< lista.size(); i++){
                System.out.println("-------------------------------------------------");
                System.out.println("idRubro: "+lista.get(i).getIdRubro());
                System.out.println("nombreRubro: "+lista.get(i).getNombreRubro());
                System.out.println("tipoRubro: "+lista.get(i).getTipoRubro());
                
            }
                
            
        }catch (Exception e){
            System.out.println("ERROR " + e);
            lista = null;
        }finally{
            session.close();
        }
        return lista;
    } 
    
}
