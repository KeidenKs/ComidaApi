package com.example.comidaapi.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.comidaapi.DetalleInformacionPlatos_Activity;
import com.example.comidaapi.MainActivity;
import com.example.comidaapi.NavigationHost;
import com.example.comidaapi.R;
import com.example.comidaapi.RegistrarUsuario_Activity;
import com.google.android.material.textfield.TextInputEditText;

public class Login_Fragment extends Fragment {

    Button login_registrar_usuario;
    Button login_iniciar_sesion_usuario;

    TextInputEditText login_username;
    TextInputEditText login_contraseña;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);



    }





    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.login_fragment, container, false);

        login_registrar_usuario = view.findViewById(R.id.login_registrar_usuario);
        login_iniciar_sesion_usuario = view.findViewById(R.id.login_iniciar_sesion_usuario);
        login_username = view.findViewById(R.id.login_nombre_usuario);
        login_contraseña = view.findViewById(R.id.login_contrasena_usuario);

        login_iniciar_sesion_usuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((NavigationHost) getActivity()).navigateTo(new ListaInformacionPlatos_Fragment(), false);
            }
        });
        login_registrar_usuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(getActivity(),RegistrarUsuario_Activity.class);
                startActivity(intent);

            }
        });


        return view;
    }






}
