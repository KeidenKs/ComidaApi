package com.example.comidaapi.Api;

import com.example.comidaapi.Model.ListaInformacionPlatos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ListarPlatos {


    public static final String BASE_URL = "https://www.themealdb.com";

    @GET("/api/json/v1/1/search.php?f=a")
    Call<ListaInformacionPlatos> listar_platos();

    @GET("/api/json/v1/1/lookup.php")
    Call<ListaInformacionPlatos> buscar_platos(@Query("i") String i);


}
