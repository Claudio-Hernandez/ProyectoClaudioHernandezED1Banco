package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText ncajeros ;
    private RadioButton modo1;
    private RadioButton modo2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ncajeros =  findViewById(R.id.cajeros);
        modo1 =  findViewById(R.id.modo1);
        modo2 =  findViewById(R.id.modo2);
    }
    public void prueba(View view){
        int nCajeros =  Integer.parseInt(ncajeros.getText().toString());
        int modoEnviar=0;
        if (modo1.isChecked()){
            modoEnviar=1;
        }else if(modo2.isChecked()){
            modoEnviar=2;
        }
        Intent s =  new Intent(this, MainActivity2.class);
        s.putExtra("cajeros",nCajeros);
        s.putExtra("modo",modoEnviar);
        startActivity(s);



    }
}