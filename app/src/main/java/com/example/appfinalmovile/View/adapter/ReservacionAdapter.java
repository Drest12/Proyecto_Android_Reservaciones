package com.example.appfinalmovile.View.adapter;



import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.appfinalmovile.RetroFit.Response.ResponseReservacion;
import com.example.appfinalmovile.databinding.ItemReservacionBinding;


import java.util.ArrayList;
import java.util.List;

public class ReservacionAdapter extends RecyclerView.Adapter<ReservacionAdapter.ViewHolder> {

    List<ResponseReservacion> listReservacion = new ArrayList<>();

    @NonNull
    @Override
    public ReservacionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemReservacionBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent, false));
    }

    public void setReservaciones(List<ResponseReservacion> listaR){
        listReservacion.addAll(listaR);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull ReservacionAdapter.ViewHolder holder, int position) {
        final ResponseReservacion responseReservacion = listReservacion.get(position);
        holder.binding.tvNombre.setText("Nombre: "+responseReservacion.getNombre());
        holder.binding.tvDni.setText("D.N.I: "+responseReservacion.getDni());
        holder.binding.tvCorreo.setText("Correo: "+responseReservacion.getCorreo());
        holder.binding.tvFecha.setText("Fecha de Reservacion: "+responseReservacion.getFecha_reservacion());
        holder.binding.tvCantidad.setText("Aforo: "+responseReservacion.getCantidad_personas());
        holder.binding.tvTelefono.setText("Telefono :"+responseReservacion.getTelefono());
        holder.binding.TvEvento.setText("Tipo de Evento: "+responseReservacion.getTipo_evento());
        holder.binding.tvNomLocal.setText("Nombre del Local: "+responseReservacion.getNombre_local());

    }

    @Override
    public int getItemCount() {
        return listReservacion.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemReservacionBinding binding;
        public ViewHolder(ItemReservacionBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }

}
