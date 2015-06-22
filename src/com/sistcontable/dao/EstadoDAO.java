/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistcontable.dao;

import com.sistcontable.hibernate.util.HibernateUtil;
import com.sistcontable.model.Estado;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 *
 * @author Administrador
 */
public class EstadoDAO {
 
    public void searchEstadoByID(String id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Estado> lista =new ArrayList();
        try{
            String query = "select * from estado where ID_ESTADO=:idEstado";
            SQLQuery sqlQuery = session.createSQLQuery(query);
            sqlQuery.addEntity(Estado.class);
            sqlQuery.setParameter("idEstado", id); 
            List result = sqlQuery.list();
            
            for(int i=0;i<result.size();i++){
                System.out.println("id: ");
                Estado estado = (Estado)result.get(i);
                System.out.println("idEstado: "+estado.getIdEstado());
                System.out.println("nombreEstado: "+estado.getNombreEstado());
                System.out.println("disponibilidad: "+estado.getDisponibilidad());
            }            
        }catch (Exception e){
            System.out.println("ERROR " + e);
            lista = null;
        }finally{
            session.close();
        }
    }
    
    public Estado obtenerEstadoByID(String id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Estado> lista =new ArrayList();
        try{
            String query = "select * from estado where ID_ESTADO=:idEstado";
            SQLQuery sqlQuery = session.createSQLQuery(query);
            sqlQuery.addEntity(Estado.class);
            sqlQuery.setParameter("idEstado", id); 
            List result = sqlQuery.list();
            
            for(int i=0;i<result.size();i++){
                System.out.println("id: ");
                Estado estado = (Estado)result.get(i);
                System.out.println("idEstado: "+estado.getIdEstado());
                System.out.println("nombreEstado: "+estado.getNombreEstado());
                System.out.println("disponibilidad: "+estado.getDisponibilidad());
            }     
            return (Estado)result.get(0);
        }catch (Exception e){
            System.out.println("ERROR " + e);
            lista = null;
            return null;
        }finally{
            session.close();
        }
    }
    
    
        public List<Estado> searchAllEstados(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Estado> lista =new ArrayList();
        try{
            String query = "select * from estado";
            SQLQuery sqlQuery = session.createSQLQuery(query);
            sqlQuery.addEntity(Estado.class);               
            lista = sqlQuery.list(); 
            
            
           for(int i=0; i< lista.size(); i++){
                System.out.println("-------------------------------------------------");
                System.out.println("idEstado: "+lista.get(i).getIdEstado());
                System.out.println("nombreEstado: "+lista.get(i).getNombreEstado());
                System.out.println("disponibilidad: "+lista.get(i).getDisponibilidad());
                
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
