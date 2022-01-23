package com.example.comidaapi.Model;

import java.util.ArrayList;

public class ListaInformacionPlatos {

    ArrayList<Platos> meals;

    public ListaInformacionPlatos(ArrayList<Platos> meals) {
        this.meals = meals;
    }

    public ArrayList<Platos> getMeals() {
        return meals;
    }

    public void setMeals(ArrayList<Platos> meals) {
        this.meals = meals;
    }
}
