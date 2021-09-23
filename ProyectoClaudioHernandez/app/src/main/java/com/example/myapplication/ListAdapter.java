package com.example.myapplication;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<ListItem> mdata;
    private LayoutInflater minflater;
    private Context context;

    public ListAdapter(List<ListItem> mdata, Context context) {
        this.minflater =  LayoutInflater.from(context);
        this.mdata = mdata;
        this.context = context;
    }
    @Override
    public int getItemCount(){
    return mdata.size();

    }
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View view =  minflater.inflate(R.layout.itemlist,null);
        return new ListAdapter.ViewHolder(view);


    }



    @Override
     public void onBindViewHolder(final ListAdapter.ViewHolder holder ,final int position){
        holder.bindData(mdata.get(position));

    }
    public void setItems(List<ListItem> items){
        mdata =  items;

    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imagen;
        TextView transaccion;
        ViewHolder(View ItemView){
            super(ItemView);
            imagen =  ItemView.findViewById(R.id.imagen);
            transaccion =  ItemView.findViewById(R.id.transaccion);

        }
        void bindData( final ListItem item){


            imagen.setImageDrawable(item.getImagen());
            transaccion.setText(item.getTransaccion());

        }
    }
}
