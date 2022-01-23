package com.example.comidaapi.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comidaapi.Holder.ListaInformacionPlatos_Holder;
import com.example.comidaapi.Model.ListaInformacionPlatos;
import com.example.comidaapi.Model.Platos;
import com.example.comidaapi.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ListaInformacionPlato_Adapter extends RecyclerView.Adapter<ListaInformacionPlatos_Holder> {


    List<Platos> platos_listado;

    public ListaInformacionPlato_Adapter(List<Platos> platos_listado) {
        this.platos_listado = platos_listado;
    }

    @NonNull
    @Override
    public ListaInformacionPlatos_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_informacion_platos_card, parent, false);
        return new ListaInformacionPlatos_Holder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaInformacionPlatos_Holder holder, int position) {


        if (platos_listado != null && position < platos_listado.size()) {

            Platos plato = platos_listado.get(position);


            String id_plato = plato.getIdMeal();
            String nombre_plato = plato.getStrMeal();
            String categoria_plato = plato.getStrCategory();
            String area_plato = plato.getStrArea();
            String imagen_plato = plato.getStrMealThumb();

            holder.lista_id_plato.setText(id_plato);
            holder.lista_nombre_plato.setText(nombre_plato);
            holder.lista_categoria_plato.setText(categoria_plato);
            holder.lista_area_plato.setText(area_plato);
            Picasso.get().load(imagen_plato).error(R.mipmap.ic_launcher).into(holder.lista_imagen_plato);


            holder.setOnclickListeners();
        }

    }

    @Override
    public int getItemCount() {
        return platos_listado.size();
    }

}
