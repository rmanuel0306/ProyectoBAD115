package com.sistcontable.model;
// Generated 06-07-2015 11:50:17 AM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * Transaccion generated by hbm2java
 */
public class Transaccion  implements java.io.Serializable {


     private BigDecimal idTransaccion;
     private Usuario usuario;
     private Cuenta cuenta;
     private BigDecimal idRelativo;
     private String comportamiento;
     private Date fecha;
     private String concepto;
     private BigDecimal saldo;

    public Transaccion() {
    }

	
    public Transaccion(BigDecimal idTransaccion) {
        this.idTransaccion = idTransaccion;
    }
    public Transaccion(BigDecimal idTransaccion, Usuario usuario, Cuenta cuenta, BigDecimal idRelativo, String comportamiento, Date fecha, String concepto, BigDecimal saldo) {
       this.idTransaccion = idTransaccion;
       this.usuario = usuario;
       this.cuenta = cuenta;
       this.idRelativo = idRelativo;
       this.comportamiento = comportamiento;
       this.fecha = fecha;
       this.concepto = concepto;
       this.saldo = saldo;
    }
   
    public BigDecimal getIdTransaccion() {
        return this.idTransaccion;
    }
    
    public void setIdTransaccion(BigDecimal idTransaccion) {
        this.idTransaccion = idTransaccion;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Cuenta getCuenta() {
        return this.cuenta;
    }
    
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    public BigDecimal getIdRelativo() {
        return this.idRelativo;
    }
    
    public void setIdRelativo(BigDecimal idRelativo) {
        this.idRelativo = idRelativo;
    }
    public String getComportamiento() {
        return this.comportamiento;
    }
    
    public void setComportamiento(String comportamiento) {
        this.comportamiento = comportamiento;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getConcepto() {
        return this.concepto;
    }
    
    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }
    public BigDecimal getSaldo() {
        return this.saldo;
    }
    
    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }




}


