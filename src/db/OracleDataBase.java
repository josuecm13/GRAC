/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.util.ArrayList;
import model.Prestamo;
import model.Carro;
import model.Cliente;
import model.cuenta.Cuenta;

/**
 *
 * @author jd_cm
 */
public class OracleDataBase {
    private ArrayList<Carro> inventario;
    private ArrayList<Cuenta> cuentas;
    private ArrayList<Cliente> clientes;
    private ArrayList<Prestamo> alquileres; 
    private static OracleDataBase instance;
    
    private OracleDataBase(){
        inventario = new ArrayList<>();
        cuentas = new ArrayList<>();
        clientes = new ArrayList<>();
    }
    
    public static OracleDataBase getInstance(){
        if(instance == null){
            instance = new OracleDataBase();
        }
        return instance;
    }
    
    public boolean insertCliente(Cliente cliente){
        for(Cliente c: clientes){
            if(cliente.getCedula() == c.getCedula())
                return false;
        }
        clientes.add(cliente);
        return true;
    }
    
    public void insertCuenta(Cuenta c){
        cuentas.add(c);
    }
    
    public void insertAlquiler(Prestamo a){
        alquileres.add(a);
    }
    
    public void insertCarro(Carro c){
        inventario.add(c);
    }

    public ArrayList<Carro> getInventario() {
        return inventario;
    }

    public ArrayList<Cuenta> getCuentas() {
        return cuentas;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public ArrayList<Prestamo> getAlquileres() {
        return alquileres;
    }
    
    
    
}
