package com.example.comidaapi.Holder;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comidaapi.DetalleInformacionPlatos_Activity;
import com.example.comidaapi.R;

public class ListaInformacionPlatos_Holder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public Context context;

    public ImageView lista_imagen_plato;
    public TextView lista_id_plato;
    public TextView lista_nombre_plato;
    public TextView lista_categoria_plato;
    public TextView lista_area_plato;
    public Button boton_lista_detalle_plato;



    public ListaInformacionPlatos_Holder(@NonNull View itemView) {
        super(itemView);

        itemView.getContext();
        context = itemView.getContext();

        lista_imagen_plato = itemView.findViewById(R.id.lista_imagen_plato);
        lista_id_plato = itemView.findViewById(R.id.lista_id_plato);
        lista_nombre_plato = itemView.findViewById(R.id.lista_nombre_plato);
        lista_categoria_plato = itemView.findViewById(R.id.lista_categoria_plato);
        lista_area_plato = itemView.findViewById(R.id.lista_area_plato);
        boton_lista_detalle_plato = itemView.findViewById(R.id.boton_lista_detalle_plato);


    }

    public void setOnclickListeners(){
        boton_lista_detalle_plato.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(context, DetalleInformacionPlatos_Activity.class);

        intent.putExtra("id_plato",lista_id_plato.getText());

        context.startActivity(intent);

    }
}
