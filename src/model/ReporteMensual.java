/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import db.OracleDataBase;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author jose pablo
 */
public class ReporteMensual {
    private int mes;
    private int anno;
    private ArrayList<Prestamo> prestamosRealizados;

    public ReporteMensual(int mes, int anno) {
        this.mes = mes;
        this.anno = anno;
        this.prestamosRealizados = new ArrayList<>();
    }
    
    public void crearPrestamo(String usuario, int idCliente, int placa, Date fechaPrestamo){
        Prestamo nuevo = new Prestamo(usuario, idCliente, placa, fechaPrestamo);
        prestamosRealizados.add( nuevo);
        OracleDataBase.getInstance().getInventario().reducirInventario(placa);
    }
}
