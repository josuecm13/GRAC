/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.OracleDataBase;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Carro;

/**
 *
 * @author jose pablo
 */
public class RegistrarPrestamo implements ActionListener{
    view.RegistrarPrestamo vista;
    private JFrame prevScreen;
    private String nombreActor;
    private Carro posibleAlquiler;
    
    public RegistrarPrestamo(JFrame view) {
        this.prevScreen = view;
        nombreActor = "Jaime";
        vista = new view.RegistrarPrestamo();
        innitComponnets();
    }
    
    private void innitComponnets(){
        vista.alquilar.addActionListener(this);
        vista.verificarCarro.addActionListener(this);
        vista.verificarCliente.addActionListener(this);
        
        vista.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        vista.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                prevScreen.setVisible(true);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       switch(e.getActionCommand()) {
           case "Alquilar":
                confirmarPrestamo();
                break;
          case "Verificar Cliente":
                verificarDatosCliente();
                break;
          case "Verificar Carro":
                verificarExistenciaCarro();
                break;
            default:
                break;
        } 
    }
    
    private void verificarDatosCliente(){
        int cedula =  Integer.getInteger(vista.clienteID.getText());
        if(OracleDataBase.getInstance().buscarCliente(cedula) != null ){
            JOptionPane.showMessageDialog(null, "Cliente verificado","Verificacion", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "Cliente no ha sido registrado previamente","Registro", JOptionPane.INFORMATION_MESSAGE);
            RegistraCliente rc = new RegistraCliente(vista);
        }
    }
    
    private void confirmarPrestamo(){
        int cedula =  Integer.getInteger(vista.clienteID.getText());
        int placa = posibleAlquiler.getPlaca();
        Calendar calendar = Calendar.getInstance();
        Date fechaPrestamo =  calendar.getTime();
        OracleDataBase.getInstance().crearPrestamo(nombreActor,cedula,placa, fechaPrestamo);
    }
    
    private void verificarExistenciaCarro(){
        String modelo =  vista.modelo.getText();
        posibleAlquiler = OracleDataBase.getInstance().verificarExistenciaCarro(modelo);
        if(posibleAlquiler != null ){
            JOptionPane.showMessageDialog(null, "Modelo en inventario","Verificacion", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "Modelo no disponible","Registro", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
}
