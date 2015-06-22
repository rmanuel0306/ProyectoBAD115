/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistcontable.dao;

import com.sistcontable.hibernate.util.HibernateUtil;
import com.sistcontable.model.Telefono;
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
public class TelefonoDAO {
    
    public List<Telefono> searchAllTelefono(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Telefono> lista =new ArrayList();
        try{
            String query = "select * from telefono";
            SQLQuery sqlQuery = session.createSQLQuery(query);
            sqlQuery.addEntity(Telefono.class);
               
            lista = sqlQuery.list();
            
            
        }catch (Exception e){
            System.out.println("ERROR " + e);
            lista = null;
        }finally{
            session.close();
        }
        return lista;
    }
    
    /*public boolean savePersona(Telefono telefono){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Boolean isInsert = Boolean.FALSE;
        
        try{ 
            String query = "CALL saveTelefono(:idmuni,:priNombre,:segNombre,:priApellido,:segApellido,:cargo,:sexo,:fechNac,:dui,:email,:direccion,:historico)";
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
    }*/
    
}
