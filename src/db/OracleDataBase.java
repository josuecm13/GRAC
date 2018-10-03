/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.util.ArrayList;
import java.util.Date;
import model.Prestamo;
import model.Carro;
import model.Cliente;
import model.Inventario;
import model.ReporteMensual;
import model.cuenta.Cuenta;

/**
 *
 * @author jd_cm
 */
public class OracleDataBase {
    private Inventario inventario;
    private ArrayList<Cuenta> cuentas;
    private ArrayList<Cliente> clientes;
    private ReporteMensual reporteMensual; 
    private static OracleDataBase instance;
    
    private OracleDataBase(){
        inventario = new Inventario();
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
    
    public void insertCarro(Carro c){
        inventario.agregarCarro(c);
    }

    public Inventario getInventario() {
        return inventario;
    }

    public ArrayList<Cuenta> getCuentas() {
        return cuentas;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public ReporteMensual getReporteMensual() {
        return reporteMensual;
    }
    
    public Cliente buscarCliente(int cedula){
        for(Cliente temp:clientes){
            if(temp.getCedula() == cedula)
                return temp;
        }
        return null;
    }
    
    public void crearPrestamo( String nombreUsuario, int cedula, int placa, Date fechaPrestamo ){
        reporteMensual.crearPrestamo(nombreUsuario, cedula, placa, fechaPrestamo);
    }
    
    
    
    public Carro verificarExistenciaCarro(String modelo){
        return inventario.verificarExistencia(modelo);
    }
}
