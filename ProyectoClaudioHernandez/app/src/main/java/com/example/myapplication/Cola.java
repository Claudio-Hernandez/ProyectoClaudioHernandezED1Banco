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
public class Cola extends Lista{
    public Persona  p = new Persona();
    
   public Object frente(){ 
       return recupera(this.primero(this), this);
   }
   public void pone(Object x, Cola cola){
       cola.inserta(x, this.finL(), cola);
   
   }
   public void quita(Cola cola){
       cola.suprime(primero(cola), cola);
   }
   public boolean vacio(Cola cola){
       if (cola.lista.isEmpty()) {
           return true;
       }else{
           return false;
       }
   }
   
}
