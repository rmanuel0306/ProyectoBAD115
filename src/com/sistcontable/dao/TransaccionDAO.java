/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistcontable.dao;

import com.sistcontable.hibernate.util.HibernateUtil;
import com.sistcontable.model.Transaccion;
import com.sistcontable.model.Bitacora;
import com.sistcontable.model.Cuenta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
/**
 *
 * @author Rebeca
 */
public class TransaccionDAO {
    public List<Cuenta> searchAllCuenta(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Cuenta> lista =new ArrayList();
        try{
            String query = "select  *  from cuenta";
            SQLQuery sqlQuery = session.createSQLQuery(query);
            sqlQuery.addEntity(Cuenta.class);                    
            lista = sqlQuery.list();
        }catch (Exception e){
            System.out.println("ERROR " + e);
            lista = null;
        }finally{
            session.close();
        }
        return lista;
    }
    
    public List<Transaccion> searchAllIdRelativo(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Transaccion> lista =new ArrayList();
        try{
            /*String query = "select  *  from transaccion";
            SQLQuery sqlQuery = session.createSQLQuery(query);
            sqlQuery.addEntity(Transaccion.class);
            //sqlQuery.setParameter("idrelativo", transaccion.getIdRelativo);                    
            lista = sqlQuery.list();*/
            
        }catch (Exception e){
            System.out.println("ERROR " + e);
            lista = null;
        }finally{
            session.close();
        }
        return lista;
    }
    
    
    public boolean GuardarTrans(Transaccion transaccion){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Boolean isInsert = Boolean.FALSE;
        
        try{          
            String query = "CALL proc_Transaccion(:iduser,:fechat,:concp,:idcta1,:saldo1,:idcta2,:saldo2,:idcta3,:saldo3,:idcta4,:saldo4,:idcta5,:saldo5,:idcta6,:saldo6,:idcta7,:saldo7,:idcta8,:saldo8,:idcta9,:saldo9,:idcta10,:saldo10)";
            Query sqlQuery = session.createSQLQuery(query).addEntity(Transaccion.class)
                    .setParameter("iduser", Integer.parseInt(transaccion.getIdUsuario().toString()))
                    .setParameter("fechat", transaccion.getFecha())
                    .setParameter("concp", transaccion.getConcepto())
                    .setParameter("idcta1", Integer.parseInt(transaccion.getIdCuenta1().toString()))
                    .setParameter("saldo1", transaccion.getSaldo1().toString())
                    .setParameter("idcta2", Integer.parseInt(transaccion.getIdCuenta2().toString()))
                    .setParameter("saldo2", transaccion.getSaldo2().toString())
                    .setParameter("idcta3", Integer.parseInt(transaccion.getIdCuenta3().toString()))
                    .setParameter("saldo3", transaccion.getSaldo3().toString())
                    .setParameter("idcta4", Integer.parseInt(transaccion.getIdCuenta4().toString()))
                    .setParameter("saldo4", transaccion.getSaldo4().toString())
                    .setParameter("idcta5", Integer.parseInt(transaccion.getIdCuenta5().toString()))
                    .setParameter("saldo5", transaccion.getSaldo5().toString())
                    .setParameter("idcta6", Integer.parseInt(transaccion.getIdCuenta6().toString()))
                    .setParameter("saldo6", transaccion.getSaldo6().toString())
                    .setParameter("idcta7", Integer.parseInt(transaccion.getIdCuenta7().toString()))
                    .setParameter("saldo7", transaccion.getSaldo7().toString())
                    .setParameter("idcta8", Integer.parseInt(transaccion.getIdCuenta8().toString()))
                    .setParameter("saldo8", transaccion.getSaldo8().toString())
                    .setParameter("idcta9", Integer.parseInt(transaccion.getIdCuenta9().toString()))
                    .setParameter("saldo9", transaccion.getSaldo9().toString())
                    .setParameter("idcta10", Integer.parseInt(transaccion.getIdCuenta10().toString()))
                    .setParameter("saldo10", transaccion.getSaldo10().toString());
    
            sqlQuery.executeUpdate();
            isInsert = Boolean.TRUE;
        
        }catch (Exception e){
            System.out.println("ERROR " + e);
            //lista = null;
        }finally{
            session.close();
        }
        return isInsert;
   }
    
}
