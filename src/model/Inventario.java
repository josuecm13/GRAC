/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import model.Carro;

/**
 *
 * @author jose pablo
 */
public class Inventario {
    private ArrayList<Carro>  carrosDisponibles;

    public Inventario() {
    }

    
    public void reducirInventario(int placa){
        for(Carro tmp: carrosDisponibles){
            if(tmp.getPlaca() == placa){
                carrosDisponibles.remove(tmp);
            }
        }
    }
    
    public Carro verificarExistencia(String modelo){
        for(Carro tmp: carrosDisponibles){
            if(tmp.getModelo().compareTo(modelo) == 0){
                return tmp;
            }
        }
        return null;
    }
    
    
    public ArrayList<Carro> getGajosDisponibles() {
        return carrosDisponibles;
    }

    public void setGajosDisponibles(ArrayList<Carro> gajosDisponibles) {
        this.carrosDisponibles = gajosDisponibles;
    }
    
    public void agregarCarro(Carro nuevo){
        carrosDisponibles.add(nuevo);
    }
   
    
    
}
