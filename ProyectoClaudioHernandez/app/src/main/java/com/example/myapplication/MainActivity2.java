package com.example.myapplication;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainActivity2 extends AppCompatActivity {
    private Banco banco  = new Banco();
    private List<ListItem> lista;
    private TextView tx;
    private TextView tx2;
    private TextView tx3;
    private Spinner spin;
    private Button button;
    private RecyclerView recycle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        spin =  findViewById(R.id.spinner);
        tx =  findViewById(R.id.textView5);
        tx2 =  findViewById(R.id.textView3);
        tx3 =  findViewById(R.id.textView4);
        button =  findViewById(R.id.button2);
        recycle =  findViewById(R.id.r2);
         int cajeros =  getIntent().getIntExtra("cajeros",1);
         int modo = getIntent().getIntExtra("modo",1);
         tx2.setText(cajeros + " cajeros ");
        tx.setText( "Todo listo!");
        tx.setTextColor(Color.parseColor("#000000"));
        banco.numerosCajeros(cajeros);
        banco.modo(modo);
        tx3.setText(""+banco.colaPersonas.get(0).size() + " Personas");

    }

    public void init(int index){
        lista =  new ArrayList<>();
        for ( int i = 0;i< banco.cajeros.get(index).pila.size();i++){
            String transaccion = "Transaccion #"+(i+1)+":"+banco.cajeros.get(index).pila.lista.get(i).toString();
            String transaccion2 = banco.cajeros.get(index).pila.lista.get(i).toString();
            Drawable d;
            if (transaccion2.equals("Deposito")){
                d = getDrawable(R.drawable.depositar);

            }else if(transaccion2.equals("Retiro")){
                d = getDrawable(R.drawable.retirada);

            }else{
                d = getDrawable(R.drawable.money);

            }




            lista.add(new ListItem(transaccion,d));

        }
        ListAdapter adapter = new ListAdapter(lista,this);
        recycle.setHasFixedSize(true);
        recycle.setLayoutManager(new LinearLayoutManager(this));
        recycle.setAdapter(adapter);



    }

    public void metodoboton(View view) throws InterruptedException {
        tx.setText("en proceso....");
        tx.setTextColor(Color.parseColor("#ffff00"));

        TimeUnit.SECONDS.sleep(5);
        empezar();


        tx.setText("Proceso Terminado!");
        tx.setTextColor(Color.parseColor("#66ff33"));
        tx3.setText(""+banco.colaPersonas.get(0).size()+" personas");
        String[] cajeros =  new String[banco.cajeros.size()];
        for (int i = 0;i<banco.cajeros.size();i++){
            cajeros[i] =  ""+ (i+1);
        }
        ArrayAdapter<String> adaptador =  new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,cajeros);
        spin.setAdapter(adaptador);


    }
    public void empezar() throws InterruptedException {
        banco.depositar3(this);

    }
    public void actualizar(View view){
        String indexs =  spin.getSelectedItem().toString();

        int indice = Integer.parseInt(indexs)-1;
        System.out.println(indice);
        init(indice);



    }
}