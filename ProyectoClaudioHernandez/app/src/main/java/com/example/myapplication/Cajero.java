/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.myapplication;



/**
 *
 * @author Usuario
 */
public class Cajero {
    public Persona personaactual=null;
    
    public Pila pila =  new Pila();
    public void depositar(String deposito){
        if (personaactual!=null) {
            pila.mete(pila, deposito);
        }else{

        }
    
    }
    
}
