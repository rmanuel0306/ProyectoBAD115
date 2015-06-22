/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistcontable.dao;

import com.sistcontable.hibernate.util.HibernateUtil;
import com.sistcontable.model.Municipio;
import com.sistcontable.model.Persona;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 *
 * @author Manuel Miranda
 */
public class PersonaDAO {
    
    public List<Persona> searchAllPersona(String opcion){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Persona> lista =new ArrayList();
        try{
            String query = "select * from persona where es_Historico= :opcion";
            SQLQuery sqlQuery = session.createSQLQuery(query);
            sqlQuery.addEntity(Persona.class)
                    .setString("opcion", opcion);
               
            lista = sqlQuery.list();
            
            
        }catch (Exception e){
            System.out.println("ERROR " + e);
            lista = null;
        }finally{
            session.close();
        }
        return lista;
    }
    
    public boolean savePersona(Persona persona){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Boolean isInsert = Boolean.FALSE;
        
        try{          
            JOptionPane.showMessageDialog(null, persona.getIdMunicipio());
            String query = "CALL savePersona(:idmuni,:priNombre,:segNombre,:priApellido,:segApellido,:cargo,:sexo,:fechNac,:dui,:email,:direccion,:historico)";
            Query sqlQuery = session.createSQLQuery(query).addEntity(Persona.class)
                    .setParameter("idmuni",Integer.parseInt(persona.getIdMunicipio().toString()))
                    .setParameter("priNombre", persona.getPrimerNombre())
                    .setParameter("segNombre", persona.getSegundoNombre())
                    .setParameter("priApellido", persona.getPrimerApellido())
                    .setParameter("segApellido", persona.getSegundoApellido())
                    .setParameter("cargo", persona.getCargo())
                    .setParameter("sexo", persona.getSexo())
                    .setParameter("fechNac", persona.getFechaNac())
                    .setParameter("dui", persona.getDui())
                    .setParameter("email", persona.getEMail())
                    .setParameter("direccion", persona.getDireccion())
                    .setParameter("historico", persona.getEsHistorico());
            
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
    
    public boolean savePersona2(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Boolean isInsert = Boolean.FALSE;
        
        try{          
            String query = "CALL savePersona(:idmuni,:priNombre,:segNombre,:priApellido,:segApellido,:cargo,:sexo,:fechNac,:dui,:email,:direccion)";
            Query sqlQuery = session.createSQLQuery(query).addEntity(Persona.class)
                    .setParameter("idmuni", null)
                    .setParameter("priNombre", "Diana")
                    .setParameter("segNombre", "nose")
                    .setParameter("priApellido", "alas")
                    .setParameter("segApellido", "larios")
                    .setParameter("cargo", "gerente")
                    .setParameter("sexo", "F")
                    .setParameter("fechNac", null)
                    .setParameter("dui", "0369")
                    .setParameter("email", "diana@gmail")
                    .setParameter("direccion", "sucasa");
            
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
    
    
    
    
    /*public boolean updatePerson(Persona persona){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Boolean isUpdate = Boolean.FALSE;
        
        try{          
            String query = "CALL updatePerson(:id,:name,:direc,:city)";
            Query sqlQuery = session.createSQLQuery(query).addEntity(Persona.class)
                    .setParameter("id", persona.getIdpersona())
                    .setParameter("name", persona.getNombre())
                    .setParameter("direc", persona.getDireccion())
                    .setParameter("city", persona.getCiudad());
            sqlQuery.executeUpdate();
            isUpdate = Boolean.TRUE;
        
        }catch (Exception e){
            System.out.println("ERROR " + e);
        }finally{
            session.close();
        }
        return isUpdate;
    }*/
    
    public boolean deletePersona(BigDecimal id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        boolean isDelete = Boolean.FALSE;
        
        try{          
            String query = "CALL deletePerson(:id)";
            Query sqlQuery = session.createSQLQuery(query).addEntity(Persona.class)
                    .setParameter("id", id);
                    
            sqlQuery.executeUpdate();
            isDelete = Boolean.TRUE;

        }catch (Exception e){
            System.out.println("ERROR " + e);
            //lista = null;
        }finally{
            session.close();
        }
        return isDelete;
    }
    
    public List<Municipio> searchAllMunicipio(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Municipio> lista =new ArrayList();
        try{
            String query = "select * from municipio";
            SQLQuery sqlQuery = session.createSQLQuery(query);
            sqlQuery.addEntity(Municipio.class);                    
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
