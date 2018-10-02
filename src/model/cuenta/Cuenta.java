/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.cuenta;

/**
 *
 * @author jd_cm
 */
public class Cuenta {
    private String tipo;
    private String username;
    private String password;

    public Cuenta(String tipo, String username, String password) {
        this.tipo = tipo;
        this.username = username;
        this.password = password;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String id) {
        this.tipo = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
