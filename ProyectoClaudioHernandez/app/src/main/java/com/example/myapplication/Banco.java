/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Usuario
 */
public class Banco extends AppCompatActivity {

    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET = "\u001B[0m";
    public ArrayList<Cola> colaPersonas = new ArrayList();
    public String termino;
    public ArrayList<Cajero> cajeros = new ArrayList();
    private int n;
    Context context;
    boolean deberiaContinuar =true;
    boolean modo = false;
    private int nCajeros;
    private TextView tiempo1;
    private char[][] palabras = new char[10][10];

    public Banco(int cajeros, int modo) {
        numerosCajeros(cajeros);
        modo(modo);
    }

    public Banco() {

    }

    public void numerosCajeros(int nCajeros) {
        this.nCajeros = nCajeros;
        for (int i = 0; i < nCajeros; i++) {
            cajeros.add(new Cajero());

        }
    }



    public void depositar() throws InterruptedException {
        SecureRandom sc = new SecureRandom();
        int aux = 0;
        Date fecha1 = new Date();
        Date fechatermina = new Date();
        int minutos = fechatermina.getMinutes() + 2;
        fechatermina.setMinutes(minutos);
        String fechafinal = "" + fechatermina;
        while (!colaPersonas.get(0).lista.isEmpty()) {
            fecha1 = new Date();

            String fechactual = "" + fecha1;
            for (int j = 0; j < cajeros.size(); j++) {
                if (cajeros.get(j).personaactual == null) {
                    if (colaPersonas.get(0).lista.isEmpty()) {
                        System.out.println("esta vacia");
                        aux = 1;
                    } else {

                        cajeros.get(j).personaactual = (Persona) colaPersonas.get(0).lista.get(0);
                        int segundos = sc.nextInt((3 - 1) + 1) + 1;


                        //Toast.makeText(context,"Transaccion completada",Toast.LENGTH_LONG).show();
                        TimeUnit.SECONDS.sleep(segundos);

                        System.out.println("Transaccion completada...");


                        cajeros.get(j).depositar(transaccion());
                        colaPersonas.get(0).quita(colaPersonas.get(0));

                    }
                } else {
                    cajeros.get(j).personaactual = null;
                }

                if (aux == 1) {
                    break;
                }

            }
            if (aux == 1) {
                depositar();
                break;
            } else if (fechactual.equals(fechafinal) || fecha1.after(fechatermina)) {
                break;
            }
            //insertaEnmenor();

        }
        termino = "Termino";
    }

    public String transaccion() {
        SecureRandom v = new SecureRandom();
        int c = v.nextInt((3 - 1) + 1) + 1;
        String trans = "";
        switch (c) {
            case 1: {
                trans = "Deposito";
                break;
            }
            case 2: {

                trans = "Pago";
                break;
            }
            case 3: {
                trans = "Retiro";
                break;
            }
        }
        return trans;
    }
    public void hilotiempo2(){


        long duracion = TimeUnit.MINUTES.toMillis(2);
        new CountDownTimer(duracion,10000){


            @Override
            public void onTick(long l) {

                String li =  String.format(Locale.ENGLISH,"%02d:%02d",TimeUnit.MILLISECONDS.toMinutes(l),TimeUnit.MILLISECONDS.toSeconds(l)-TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(l)));
                tiempo1.setText(li);
            }

            @Override
            public void onFinish() {
                deberiaContinuar=false;

            }
        }.start();


    }

    public void depositar3(Context context2) throws InterruptedException {
            this.context = context2;


        if (modo) {
            depositar();

        } else {
            depositar2();

        }

    }



    public void imprimir() {
        for (int i = 0; i < cajeros.size(); i++) {
            System.out.println("===============Cajero " + (i + 1) + "=================");
            //System.out.println(cajeros.get(i).pila.lista);
            if (!cajeros.get(i).pila.lista.isEmpty()) {
                for (int j = 0; j < cajeros.get(i).pila.lista.size(); j++) {
                    String transaccionHecha = (cajeros.get(i).pila.lista.get(j)).toString();
                    switch (transaccionHecha) {
                        case "retiro": {
                            System.out.println(ANSI_GREEN + "  - Transaccion #" + (j + 1) + ": " + transaccionHecha + ANSI_RESET);
                            break;
                        }
                        case "Deposito": {
                            System.out.println(ANSI_CYAN + "  - Transaccion #" + (j + 1) + ": " + transaccionHecha + ANSI_RESET);
                            break;
                        }
                        case "pago": {
                            System.out.println(ANSI_YELLOW + "  - Transaccion #" + (j + 1) + ": " + transaccionHecha + ANSI_RESET);
                            break;
                        }
                    }

                }
            } else {
                System.out.println("Sin transacciones");
            }
        }
    }

    public void insertaEnmenor() {
        int[] menores = new int[colaPersonas.size()];
        SecureRandom sc = new SecureRandom();
        int n2;

        for (int i = 0; i < colaPersonas.size(); i++) {
            menores[i] = colaPersonas.get(i).size();
        }
        Arrays.sort(menores);
        for (int i = 0; i < colaPersonas.size(); i++) {
            if (menores[0] == colaPersonas.get(i).size()) {
                n2 = sc.nextInt((5 - 1) + 1) + 1;

                for (int j = 0; j < n2; j++) {
                    colaPersonas.get(i).pone(new Persona(), colaPersonas.get(i));
                }
            }
        }

    }

    public void depositar2() throws InterruptedException {

        SecureRandom sc = new SecureRandom();

        int aux = 0;
        Date fecha1 = new Date();
        Date fechatermina = new Date();
        int minutos = fechatermina.getMinutes() + 2;
        fechatermina.setMinutes(minutos);
        String fechafinal = "" + fechatermina;
        for (int i = 0; i < colaPersonas.size(); i++) {
            
            System.out.println("cola numero:" + (i + 1));
            while (!colaPersonas.get(i).lista.isEmpty()) {
                fecha1 = new Date();
            //String fechactual = f.format(fecha1);
            String fechactual = "" + fecha1;
                if (cajeros.get(i).personaactual == null) {
                    if (colaPersonas.get(i).lista.isEmpty()) {
                        System.out.println("esta vacia");
                        aux = 1;

                    } else {

                        cajeros.get(i).personaactual = (Persona) colaPersonas.get(i).lista.get(0);
                        int segundos = sc.nextInt((3 - 1) + 1) + 1;
                        TimeUnit.SECONDS.sleep(segundos);
                        System.out.println("Transaccion completada...");

                        cajeros.get(i).depositar(transaccion());
                        colaPersonas.get(i).quita(colaPersonas.get(i));

                    }
                } else {
                    cajeros.get(i).personaactual = null;
                }

                if (aux == 1) {

                    break;
                } else if (fechactual.equals(fechafinal) || fecha1.after(fechatermina)) {
                    break;
                }

            }

            
        }
        termino = "Termino";

    }

    public boolean modo(int eleccion) {

        if (eleccion == 1) {
            colaPersonas.add(new Cola());
            SecureRandom sc = new SecureRandom();
            n = sc.nextInt((58 - 55) + 1) + 55;
            System.out.println("=============Hay: "+n + " Personas en total==========");
            for (int i = 0; i < n; i++) {
                colaPersonas.get(0).lista.add(new Persona());

            }
            return modo = true;//modo 1
        } else if (eleccion == 2) {
            SecureRandom sc = new SecureRandom();

            for (int i = 0; i < nCajeros; i++) {
                colaPersonas.add(new Cola());
            }
            for (int i = 0; i < colaPersonas.size(); i++) {
                n = sc.nextInt((32 - 25) + 1) + 25;
                System.out.println(n + " Personas en Cajero" + (i + 1));
                for (int j = 0; j < n; j++) {
                    colaPersonas.get(i).lista.add(new Persona());
                }
            }
            return modo = false;//modo 2
        } else {
            return true;
        }

    }

}
