package com.example.comidaapi;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.comidaapi.Api.ListarPlatos;
import com.example.comidaapi.Model.ListaInformacionPlatos;
import com.example.comidaapi.R;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetalleInformacionPlatos_Activity extends AppCompatActivity {

    Toolbar toolbar;
    String id_plato;

    ImageView detalle_plato_imagen;
    TextView detalle_plato_nombre;
    TextView detalle_plato_categoria;
    TextView detalle_plato_pais;
    TextView detalle_plato_descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_informacion_platos);

        vincular_views();
        id_plato = obtener_intents();
        asignar_valores(id_plato);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public void asignar_valores(String id){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ListarPlatos.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        ListarPlatos svc = retrofit.create(ListarPlatos.class);

        //CALL Colocar el id de la reserva
        Call<ListaInformacionPlatos> valor = svc.buscar_platos(id);


        valor.enqueue(new Callback<ListaInformacionPlatos>() {




            @Override
            public void onResponse(Call<ListaInformacionPlatos> call, Response<ListaInformacionPlatos> response) {
                if(!response.isSuccessful()){
                    Log.e("CallService.onResponse","Error" + response.code());
                }
                else{

                    ListaInformacionPlatos plato = response.body();

                    Picasso.get().load(plato.getMeals().get(0).getStrMealThumb()).error(R.mipmap.ic_launcher).into(detalle_plato_imagen);
                    detalle_plato_nombre.setText(plato.getMeals().get(0).getStrMeal());
                    detalle_plato_categoria.setText(plato.getMeals().get(0).getStrCategory());
                    detalle_plato_pais.setText(plato.getMeals().get(0).getStrArea());
                    detalle_plato_descripcion.setText(plato.getMeals().get(0).getStrInstructions());



                }
            }

            @Override
            public void onFailure(Call<ListaInformacionPlatos> call, Throwable t) {
                Log.e("CallService.onFailure", t.getLocalizedMessage());
            }
        });
    }

    public String obtener_intents(){

        Bundle extras = getIntent().getExtras();
        if(extras!= null) {

            String id_plato = extras.getString("id_plato");

            return id_plato;

        }
        return  null;

    }

    public void vincular_views(){
        detalle_plato_imagen = findViewById(R.id.detalle_plato_imagen);
        detalle_plato_nombre = findViewById(R.id.detalle_nombre_plato);
        detalle_plato_categoria = findViewById(R.id.detalle_categoria_plato);
        detalle_plato_pais = findViewById(R.id.detalle_pais_plato);
        detalle_plato_descripcion = findViewById(R.id.detalle_descripcion_plato);
    }


}
