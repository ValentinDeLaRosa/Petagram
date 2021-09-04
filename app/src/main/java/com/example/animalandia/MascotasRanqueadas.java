package com.example.animalandia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.animalandia.adapter.MascotasAdaptador;

import java.util.ArrayList;

public class MascotasRanqueadas extends AppCompatActivity {

    private RecyclerView rvlitaMejoresMascotas;

    ArrayList<Mascotas> mejoresMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_ranqueadas);

        Bundle parametros = this.getIntent().getExtras();

        ArrayList<Integer> imagen = (ArrayList<Integer>) parametros.getSerializable("imagen");
        ArrayList<String>  nombre = (ArrayList<String>)  parametros.getSerializable("nombre");
        ArrayList<Integer> likes  = (ArrayList<Integer>) parametros.getSerializable("likes");

        mejoresMascotas = new ArrayList<>();

        /*for ( int i = 0 ; i < imagen.size() ; ++i ){

            mejoresMascotas.add(new Mascotas(imagen.get(i), nombre.get(i) , likes.get(i) ));

        }*/

        rvlitaMejoresMascotas = (RecyclerView) findViewById(R.id.rvMascotasRanqueadas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvlitaMejoresMascotas.setLayoutManager(llm);
        inicializarAdapdator();

    }

    public void inicializarAdapdator(){
/*
        MascotasAdaptador adaptador = new MascotasAdaptador(mejoresMascotas);
        rvlitaMejoresMascotas.setAdapter(adaptador);*/
    }


}