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
    private ArrayList<Carro>  gajosDisponibles;

    public Inventario() {
    }

    
    public void reducirInventario(int placa){
        for(Carro tmp: gajosDisponibles){
            if(tmp.getPlaca() == placa){
                gajosDisponibles.remove(tmp);
            }
        }
    }
    
    public Carro verificarExistencia(String modelo){
        for(Carro tmp: gajosDisponibles){
            if(tmp.getModelo().compareTo(modelo) == 0){
                return tmp;
            }
        }
        return null;
    }
    
    
    public ArrayList<Carro> getGajosDisponibles() {
        return gajosDisponibles;
    }

    public void setGajosDisponibles(ArrayList<Carro> gajosDisponibles) {
        this.gajosDisponibles = gajosDisponibles;
    }
   
    
    
}
