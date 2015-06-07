package com.sistcontable.model;
// Generated 06-07-2015 01:25:15 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * Movimiento generated by hbm2java
 */
public class Movimiento  implements java.io.Serializable {


     private BigDecimal idMovimiento;
     private Cuenta cuenta;
     private BigDecimal mes;
     private BigDecimal year;
     private BigDecimal debe;
     private BigDecimal haber;
     private String concepto;

    public Movimiento() {
    }

	
    public Movimiento(BigDecimal idMovimiento) {
        this.idMovimiento = idMovimiento;
    }
    public Movimiento(BigDecimal idMovimiento, Cuenta cuenta, BigDecimal mes, BigDecimal year, BigDecimal debe, BigDecimal haber, String concepto) {
       this.idMovimiento = idMovimiento;
       this.cuenta = cuenta;
       this.mes = mes;
       this.year = year;
       this.debe = debe;
       this.haber = haber;
       this.concepto = concepto;
    }
   
    public BigDecimal getIdMovimiento() {
        return this.idMovimiento;
    }
    
    public void setIdMovimiento(BigDecimal idMovimiento) {
        this.idMovimiento = idMovimiento;
    }
    public Cuenta getCuenta() {
        return this.cuenta;
    }
    
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    public BigDecimal getMes() {
        return this.mes;
    }
    
    public void setMes(BigDecimal mes) {
        this.mes = mes;
    }
    public BigDecimal getYear() {
        return this.year;
    }
    
    public void setYear(BigDecimal year) {
        this.year = year;
    }
    public BigDecimal getDebe() {
        return this.debe;
    }
    
    public void setDebe(BigDecimal debe) {
        this.debe = debe;
    }
    public BigDecimal getHaber() {
        return this.haber;
    }
    
    public void setHaber(BigDecimal haber) {
        this.haber = haber;
    }
    public String getConcepto() {
        return this.concepto;
    }
    
    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }




}


