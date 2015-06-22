/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistcontable.dao;

import com.sistcontable.hibernate.util.HibernateUtil;
import com.sistcontable.model.Persona;
import com.sistcontable.model.Usuario;
import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.SessionImpl;

/**
 *
 * @author Manuel Miranda
 */
public class UsuarioDAO {
    
     public void searchUserByID(String id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Usuario> lista =new ArrayList();
        try{
            String query = "select * from usuario where id_usuario=:id_usuario";
            SQLQuery sqlQuery = session.createSQLQuery(query);
            sqlQuery.addEntity(Usuario.class);
            sqlQuery.setParameter("id_usuario", id);
            //lista=sqlQuery.list();   
            List result = sqlQuery.list(); 
            for(int i=0;i<result.size();i++){
                System.out.println("id: ");
                Usuario usuario = (Usuario)result.get(i);
                
                System.out.println("id_usuario: "+usuario.getId_usuario());
                System.out.println("id_persona: "+usuario.getId_persona());
                System.out.println("nombre_usuario: "+usuario.getNombre_usuario());
                System.out.println("clave: "+usuario.getClave());
            }            
        }catch (Exception e){
            System.out.println("ERROR " + e);
            lista = null;
        }finally{
            session.close();
        }
    }
     
     public List<Usuario> searchAllUser(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Usuario> lista =new ArrayList();
        try{
            String query = "select * from usuario";
            SQLQuery sqlQuery = session.createSQLQuery(query);
            sqlQuery.addEntity(Usuario.class);               
            lista = sqlQuery.list();     
        }catch (Exception e){
            System.out.println("ERROR " + e);
            lista = null;
        }finally{
            session.close();
        }
        return lista;
    } 
     
     
      public Persona[] listaPersonas(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Persona[] apersona=null;
        try{
            String query = "select id_persona,primer_nombre,primer_apellido from persona";
            SQLQuery sqlQuery = session.createSQLQuery(query);
            int i=0;
            int longLista=sqlQuery.list().size();
            apersona=new Persona[longLista];
            for(i=0;i<longLista;i++){
                apersona[i] = new Persona();  
            }
            System.out.println("longitud lista "+longLista);       
            i=0;
            List<Object[]> rows = sqlQuery.list();           
            for(Object[] row : rows){   
            apersona[i].setIdPersona(BigDecimal.valueOf(Double.parseDouble(row[0].toString())));
            apersona[i].setPrimerNombre(row[1].toString());
            apersona[i].setPrimerApellido(row[2].toString());
              i++; 
            }
        }catch (Exception e){
            System.out.println("ERROR " + e);
        }finally{
            session.close();
        }
        return apersona;
    }  
     
    public boolean saveUser(Usuario usuario){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Boolean isInsert = Boolean.FALSE;        
        try{          
            String query = "call proc_Usuario(:opc,'',:idpersona,:nombreusuario,:pass)";
            //String query = "insert into usuario(id_usuario,id_privilegio,id_persona,nombre_usuario,clave)"
           //         + "values(:idusuario,:priv,:idpersona,:nombreusuario,:pass)";
            Query sqlQuery = session.createSQLQuery(query).addEntity(Usuario.class)
                    .setParameter("opc", 1)
                    .setParameter("idpersona", usuario.getId_persona())
                    .setParameter("nombreusuario", usuario.getNombre_usuario())
                    .setParameter("pass", usuario.getClave());
            
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
    
    public boolean updateUser(Usuario usuario){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Boolean isUpdate = Boolean.FALSE;        
        try{          
            String query = "call proc_Usuario(3,:id_usuario,:id_persona,:nombre_usuario,:clave)";
            Query sqlQuery = session.createSQLQuery(query).addEntity(Usuario.class)
                    .setParameter("id_usuario", usuario.getId_usuario())
                    .setParameter("id_persona", usuario.getId_persona())
                    .setParameter("nombre_usuario", usuario.getNombre_usuario())
                    .setParameter("clave", usuario.getClave());
            sqlQuery.executeUpdate();
            isUpdate = Boolean.TRUE;
        
        }catch (Exception e){
            System.out.println("ERROR " + e);
        }finally{
            session.close();
        }
        return isUpdate;
    }
    
    public boolean deleteUser(String id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        boolean isDelete = Boolean.FALSE;        
        try{          
            String query = "call proc_Usuario(4,:id_usuario,'','','')";
            Query sqlQuery = session.createSQLQuery(query).addEntity(Usuario.class)
                    .setParameter("id_usuario", Double.parseDouble(id));                    
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
    
    public void searchUserSP(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();        
        SessionImpl sessionImpl = (SessionImpl) session;
        Connection conn = sessionImpl.connection();
        CallableStatement callable = null;
        try{
            //CallableStatement callstm = null;
            String query = "call proc_Usuario(1,:id_usuario,'','','','')";
            //callstm = aConnection.prepareCall( functionCall );            
            callable = conn.prepareCall(query);
            callable.registerOutParameter(0,OracleTypes.CURSOR);
            callable.setString(1, "ss");
            callable.execute();            
            System.out.println("Registro se consulto con exito");  
        }catch (Exception e){
            System.out.println("ERROR " + e);
            //lista = null;
        }finally{
            session.close();
        }       
    }
     
}
