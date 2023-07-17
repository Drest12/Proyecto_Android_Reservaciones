package com.example.appfinalmovile.View.adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appfinalmovile.R;
import com.example.appfinalmovile.RetroFit.Response.ResponseLocales;
import com.example.appfinalmovile.View.HomeActivity;
import com.example.appfinalmovile.View.MainActivity;
import com.example.appfinalmovile.View.RegistroActivity;
import com.example.appfinalmovile.databinding.ItemlocalesBinding;

import java.util.ArrayList;
import java.util.List;

public class LocalAdapter extends RecyclerView.Adapter<LocalAdapter.ViewHolder> implements View.OnClickListener {
    List<ResponseLocales> listLocales = new ArrayList<>();
    Context mi_contexto;
    public LocalAdapter(Context c) {
        this.mi_contexto = c;
    }
    public LocalAdapter() {

    }


    @NonNull
    @Override
    public LocalAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemlocalesBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent, false));

    }

    public void setLocales(List<ResponseLocales> lista) {
        listLocales.addAll(lista);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull LocalAdapter.ViewHolder holder, int position) {
        final ResponseLocales responseLocales = listLocales.get(position);
        holder.binding.tvnombre.setText(responseLocales.getNombre());
        holder.binding.tvdescrip.setText(responseLocales.getDescripcion());
        holder.binding.tvaforo.setText("Aforo: "+responseLocales.getAforo());
        holder.binding.tvtelefono.setText("Telf: "+responseLocales.getTelefono());
        holder.binding.tvubicacion.setText("Ubicacion: "+responseLocales.getUbicacion());
        holder.binding.btnReservar.setOnClickListener(this);
       if(mi_contexto!= null)
       {
          int id = mi_contexto.getResources().getIdentifier(responseLocales.getImagen(),
                   "drawable", mi_contexto.getPackageName());
           holder.binding.imageView2.setImageResource(id);
       }

    }

    @Override
    public int getItemCount() {
        return listLocales.size();
    }

    @Override
    public void onClick(View view) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemlocalesBinding binding;

        public ViewHolder(ItemlocalesBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
