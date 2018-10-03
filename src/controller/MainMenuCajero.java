/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author jd_cm
 */
public class MainMenuCajero {
    view.MainMenuCajero view;
    
    public MainMenuCajero(){
        view = new view.MainMenuCajero();
        view.getBtnCreaCliente().addActionListener(e -> {
            RegistraCliente rc = new RegistraCliente(view);
            view.setVisible(false);
        });
        view.getBtnPrestamo().addActionListener(e -> {
            RegistrarPrestamo rc = new RegistrarPrestamo(view);
            view.setVisible(false);
        });
        view.setVisible(true);
    }
    
}
