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
public class Pila extends Lista {
    
    public void saca(Pila pila2){
        if (!pila2.lista.isEmpty()) {
           this.lista.remove(this.primero(pila2));

        }
    }
    public void mete(Pila pila2,Object x){
        pila2.inserta(x, primero(pila2), pila2);
    }
    
   
}
