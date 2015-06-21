/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistcontable.dao;

import com.sistcontable.hibernate.util.HibernateUtil;
import com.sistcontable.model.Cuenta;
import java.util.ArrayList;
import java.util.List;
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
            
            /*for(int i=0;i<result.size();i++){
                System.out.println("id: ");
                Cuenta cuenta = (Cuenta)result.get(i);
                
                System.out.println("idCuenta: "+cuenta.getIdCuenta());
                System.out.println("estado: "+cuenta.getEstado().getNombreEstado());
                System.out.println("rubro: "+cuenta.getRubro().getNombreRubro());
                System.out.println("nombreCuenta: "+cuenta.getNombreCuenta());
                System.out.println("cuentaMayor: "+cuenta.getCuentaMayor());
            } */           
        }catch (Exception e){
            System.out.println("ERROR " + e);
            lista = null;
        }finally{
            session.close();
        }
    }
    
    
        public List<Cuenta> searchAllCuentas(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Cuenta> lista =new ArrayList();
        try{
            String query = "select * from cuenta";
            SQLQuery sqlQuery = session.createSQLQuery(query);
            sqlQuery.addEntity(Cuenta.class);               
            lista = sqlQuery.list(); 
            
            /*for(int i=0; i<lista.size() ; i++){
                System.out.println("-------------------------------------------------");
                System.out.println("idCuenta: "+lista.get(i).getIdCuenta());
                System.out.println("estado: "+lista.get(i).getEstado().getNombreEstado());
                System.out.println("rubro: "+lista.get(i).getRubro().getNombreRubro());
                System.out.println("nombreCuenta: "+lista.get(i).getNombreCuenta());
                System.out.println("cuentaMayor: "+lista.get(i).getCuentaMayor());
                
            }*/
                
            
        }catch (Exception e){
            System.out.println("ERROR " + e);
            lista = null;
        }finally{
            session.close();
        }
        return lista;
    } 
    
    
}
