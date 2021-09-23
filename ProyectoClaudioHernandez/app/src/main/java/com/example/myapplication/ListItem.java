package com.example.myapplication;

import android.graphics.drawable.Drawable;

public class ListItem {
    String transaccion;
    Drawable imagen;

    public ListItem(String transaccion, Drawable imagen) {
        this.transaccion = transaccion;
        this.imagen = imagen;
    }

    public String getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(String transaccion) {
        this.transaccion = transaccion;
    }

    public Drawable getImagen() {
        return imagen;
    }

    public void setImagen(Drawable imagen) {
        this.imagen = imagen;
    }
}
