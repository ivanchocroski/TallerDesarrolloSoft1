/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.connection.modelo;

import java.util.Date;

/**
 *
 * @author E201
 */
public class Empleado {
    
    private int id;
    private String nombre;
    private double salario;
    private Date fechadeIngreso;
    private int idDepto;

    /**
     * @return the id
     */
    public Empleado(){
        
    }

    public Empleado(int id, String nombre, Double salario, Date fechaI, int idDepto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the salario
     */
    public double getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }

    /**
     * @return the fechadeIngreso
     */
    public Date getFechadeIngreso() {
        return fechadeIngreso;
    }

    /**
     * @param fechadeIngreso the fechadeIngreso to set
     */
    public void setFechadeIngreso(Date fechadeIngreso) {
        this.fechadeIngreso = fechadeIngreso;
    }

    /**
     * @return the idDepto
     */
    public int getIdDepto() {
        return idDepto;
    }

    /**
     * @param idDepto the idDepto to set
     */
    public void setIdDepto(int idDepto) {
        this.idDepto = idDepto;
    }
    
    
    
}
