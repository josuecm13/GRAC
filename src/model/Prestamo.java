/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author jd_cm
 */
public class Prestamo {
    private String nombreUsuario;
    private String idCliente;
    private int placa;
    private Date fechaPrestamo;

    public Prestamo(String nombreUsuario, String idCliente, int placa, Date fechaPrestamo) {
        this.nombreUsuario = nombreUsuario;
        this.idCliente = idCliente;
        this.placa = placa;
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public int getPlaca() {
        return placa;
    }

    public void setPlaca(int placa) {
        this.placa = placa;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }
    
    
    
    
}
