/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistcontable.dao;

import com.sistcontable.hibernate.util.HibernateUtil;
import com.sistcontable.model.Cuenta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 *
 * @author Administrador
 */
public class CuentaDAO {
    
    public void searchCuentaByID(String id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Cuenta> lista =new ArrayList();
        try{
            String query = "select * from cuenta where ID_CUENTA=:idCuenta";
            SQLQuery sqlQuery = session.createSQLQuery(query);
            sqlQuery.addEntity(Cuenta.class);
            sqlQuery.setParameter("idCuenta", id); 
            List result = sqlQuery.list();
            
            for(int i=0;i<result.size();i++){
                System.out.println("id: ");
                Cuenta cuenta = (Cuenta)result.get(i);
                
                System.out.println("idCuenta: "+cuenta.getIdCuenta());
                System.out.println("estado: "+cuenta.getEstado().getNombreEstado());
                System.out.println("rubro: "+cuenta.getRubro().getNombreRubro());
                System.out.println("nombreCuenta: "+cuenta.getNombreCuenta());
                System.out.println("cuentaMayor: "+cuenta.getCuentaMayor());
            }            
        }catch (Exception e){
            System.out.println("ERROR " + e);
            lista = null;
        }finally{
            session.close();
        }
    }
    
    public Cuenta obtenerCuentaByID(String id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Cuenta> lista =new ArrayList();
        try{
            String query = "select * from cuenta where ID_CUENTA=:idCuenta";
            SQLQuery sqlQuery = session.createSQLQuery(query);
            sqlQuery.addEntity(Cuenta.class);
            sqlQuery.setParameter("idCuenta", id); 
            List result = sqlQuery.list();
            
            for(int i=0;i<result.size();i++){
                System.out.println("id: ");
                Cuenta cuenta = (Cuenta)result.get(i);
                
                System.out.println("idCuenta: "+cuenta.getIdCuenta());
                System.out.println("estado: "+cuenta.getEstado().getNombreEstado());
                System.out.println("rubro: "+cuenta.getRubro().getNombreRubro());
                System.out.println("nombreCuenta: "+cuenta.getNombreCuenta());
                System.out.println("cuentaMayor: "+cuenta.getCuentaMayor());
            }    
            return (Cuenta)result.get(0);
        }catch (Exception e){
            System.out.println("ERROR " + e);
            lista = null;
            return null;
        }finally{
            session.close();
        }
    }
    
        public List<Cuenta> searchAllCuentas(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Cuenta> lista =new ArrayList();
        try{
            String query = "select * from cuenta order by ID_CUENTA";
            SQLQuery sqlQuery = session.createSQLQuery(query);
            sqlQuery.addEntity(Cuenta.class);               
            lista = sqlQuery.list(); 
            
             for(int i=0; i< lista.size(); i++){
                System.out.println("-------------------------------------------------");
                System.out.println("idCuenta: "+lista.get(i).getIdCuenta());
                System.out.println("estado: "+lista.get(i).getEstado().getNombreEstado());
                System.out.println("rubro: "+lista.get(i).getRubro().getNombreRubro());
                System.out.println("nombreCuenta: "+lista.get(i).getNombreCuenta());
                System.out.println("cuentaMayor: "+lista.get(i).getCuentaMayor());
             }  
            
                
            
        }catch (Exception e){
            System.out.println("ERROR " + e);
            lista = null;
        }finally{
            session.close();
        }
        return lista;
    }
        
        public boolean saveCuenta(Cuenta cuenta){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Boolean isInsert = Boolean.FALSE;        
        try{          
            String query = "call proc_guardarCuenta(:idCuenta,:estado,:rubro,:nombreCuenta,:cuentaMayor)";
            Query sqlQuery = session.createSQLQuery(query).addEntity(Cuenta.class)
                    .setParameter("idCuenta", cuenta.getIdCuenta())
                    .setParameter("estado", cuenta.getEstado())
                    .setParameter("rubro", cuenta.getRubro())
                    .setParameter("nombreCuenta", cuenta.getNombreCuenta())
                    .setParameter("cuentaMayor", cuenta.getCuentaMayor());
            sqlQuery.executeUpdate();
            System.out.println(sqlQuery.toString());
            isInsert = Boolean.TRUE;        
        }catch (Exception e){
            System.out.println("ERROR " + e);
            //lista = null;
        }finally{
            session.close();
        }
        return isInsert;
    }
        
    
    public boolean updateCuenta(Cuenta cuenta){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Boolean isUpdate = Boolean.FALSE;        
        try{          
            String query = "call proc_actualizarCuenta(:idCuenta,:estado,:rubro,:nombreCuenta,:cuentaMayor)";
            Query sqlQuery = session.createSQLQuery(query).addEntity(Cuenta.class)
                    .setParameter("idCuenta", cuenta.getIdCuenta())
                    .setParameter("estado", cuenta.getEstado())
                    .setParameter("rubro", cuenta.getRubro())
                    .setParameter("nombreCuenta", cuenta.getNombreCuenta())
                    .setParameter("cuentaMayor", cuenta.getCuentaMayor());
            sqlQuery.executeUpdate();
            System.out.println(sqlQuery.toString());
            isUpdate = Boolean.TRUE;        
        }catch (Exception e){
            System.out.println("ERROR " + e);
        }finally{
            session.close();
        }
        return isUpdate;
    }    
    
    
    public boolean deleteCuenta(BigDecimal idcuenta){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Boolean isUpdate = Boolean.FALSE;        
        try{          
            String query = "call proc_borrarCuenta(:idCuenta)";
            Query sqlQuery = session.createSQLQuery(query).addEntity(Cuenta.class)
                    .setParameter("idCuenta", idcuenta);
            sqlQuery.executeUpdate();
            System.out.println(sqlQuery.toString());
            isUpdate = Boolean.TRUE;        
        }catch (Exception e){
            System.out.println("ERROR " + e);
        }finally{
            session.close();
        }
        return isUpdate;
    }    
        
        
    
}
