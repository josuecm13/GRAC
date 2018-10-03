package controller;

import db.OracleDataBase;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Cliente;
import view.MainMenuCajero;
import view.RegistrarCliente;

/**
 *
 * @author El Canelas
 */
public class RegistraCliente {
    private RegistrarCliente rc;
    private JFrame prevScreen;
    
    public RegistraCliente(){
        innitComponents();
    }


    public RegistraCliente(JFrame view) {
        this.prevScreen = view;
        innitComponents();
    }
    
    private void innitComponents(){
        rc = new RegistrarCliente();
        rc.registrar.addActionListener(e ->{
            try {
                regCliente();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "La cedula debe contener únicamente dígitos numéricos","Registro", JOptionPane.ERROR_MESSAGE);
            }
        });
        rc.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        rc.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                prevScreen.setVisible(true);
            }
        });
        rc.setVisible(true);
    }

    private void regCliente() throws Exception{
        int cedula = Integer.parseInt(rc.cedula.getText());
        String nombre = rc.nombre.getText();
        String apellido = rc.apellido.getText();
        Cliente c = new Cliente(cedula, nombre, apellido);
        if(OracleDataBase.getInstance().insertCliente(c))
            JOptionPane.showMessageDialog(null, "Cliente registrado correctamente","Registro", JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null, "El cliente ya ha sido registrado previamente","Registro", JOptionPane.ERROR_MESSAGE);
    }
}
