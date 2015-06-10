package com.sistcontable.model;
// Generated 06-10-2015 01:21:20 AM by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * Telefono generated by hbm2java
 */
public class Telefono  implements java.io.Serializable {


     private BigDecimal idTelefono;
     private Persona persona;
     private Integer telefonoFijo;
     private Integer telefonoMovil;
     private Integer telefonoAuxiliar;

    public Telefono() {
    }

	
    public Telefono(BigDecimal idTelefono) {
        this.idTelefono = idTelefono;
    }
    public Telefono(BigDecimal idTelefono, Persona persona, Integer telefonoFijo, Integer telefonoMovil, Integer telefonoAuxiliar) {
       this.idTelefono = idTelefono;
       this.persona = persona;
       this.telefonoFijo = telefonoFijo;
       this.telefonoMovil = telefonoMovil;
       this.telefonoAuxiliar = telefonoAuxiliar;
    }
   
    public BigDecimal getIdTelefono() {
        return this.idTelefono;
    }
    
    public void setIdTelefono(BigDecimal idTelefono) {
        this.idTelefono = idTelefono;
    }
    public Persona getPersona() {
        return this.persona;
    }
    
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    public Integer getTelefonoFijo() {
        return this.telefonoFijo;
    }
    
    public void setTelefonoFijo(Integer telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }
    public Integer getTelefonoMovil() {
        return this.telefonoMovil;
    }
    
    public void setTelefonoMovil(Integer telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }
    public Integer getTelefonoAuxiliar() {
        return this.telefonoAuxiliar;
    }
    
    public void setTelefonoAuxiliar(Integer telefonoAuxiliar) {
        this.telefonoAuxiliar = telefonoAuxiliar;
    }




}


