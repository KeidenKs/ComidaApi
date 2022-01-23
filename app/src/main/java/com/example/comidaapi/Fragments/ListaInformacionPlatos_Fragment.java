package com.example.comidaapi.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comidaapi.Adapter.ListaInformacionPlato_Adapter;
import com.example.comidaapi.Api.ListarPlatos;
import com.example.comidaapi.Model.ListaInformacionPlatos;
import com.example.comidaapi.Model.Platos;
import com.example.comidaapi.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListaInformacionPlatos_Fragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {



        View view = inflater.inflate(R.layout.lista_informacion_platos_grid, container, false);

        Retrofit retrofit = new Retrofit.Builder().baseUrl(ListarPlatos.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        ListarPlatos svc = retrofit.create(ListarPlatos.class);



        Call<ListaInformacionPlatos> lista_valores = svc.listar_platos();



        lista_valores.enqueue(new Callback<ListaInformacionPlatos>() {



            @Override
            public void onResponse(Call<ListaInformacionPlatos> call, Response<ListaInformacionPlatos> response) {
                if(!response.isSuccessful()){


                    Log.e("CallService.onResponse","Error" + response.code());
                }
                else{

                    ListaInformacionPlatos platos = response.body();



                    RecyclerView recyclerView = view.findViewById(R.id.recycler_view_lista_informacionj_platos);
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1, RecyclerView.VERTICAL, false));


                    Log.e("CallService.onResponse","Error");




                    List<Platos> lista = lista_platos(platos);






                    ListaInformacionPlato_Adapter adapter = new ListaInformacionPlato_Adapter(lista);

                    recyclerView.setAdapter(adapter);


                }




            }

            @Override
            public void onFailure(Call<ListaInformacionPlatos> call, Throwable t) {
                Log.e("CallService.onFailure", t.getLocalizedMessage());
            }
        });

        return  view;

    }

    public List<Platos> lista_platos(ListaInformacionPlatos platos){
        List<Platos> lista = new ArrayList<>();
        int tamaño = platos.getMeals().size();
        for(int i=0; i < tamaño; i++){
            Platos plato = platos.getMeals().get(i);
            lista.add(plato);
        }
        return lista;

    }




}
