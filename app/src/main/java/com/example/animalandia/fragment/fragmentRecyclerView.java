package com.example.animalandia.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.animalandia.Mascotas;
import com.example.animalandia.MascotasRanqueadas;
import com.example.animalandia.R;
import com.example.animalandia.activityAbout;
import com.example.animalandia.activityContact;
import com.example.animalandia.adapter.MascotasAdaptador;

import java.util.ArrayList;
import java.util.Collections;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class fragmentRecyclerView extends Fragment {
    ArrayList<Mascotas> mascotas;
    private RecyclerView listaMascotas;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recylerview, container, false);

        mascotas = new ArrayList<Mascotas>();
        mascotas.add(new Mascotas(R.drawable.mascota1,"Mascota 1",0));
        mascotas.add(new Mascotas(R.drawable.mascota2,"Mascota 2", 0));
        mascotas.add(new Mascotas(R.drawable.mascota3,"Mascota 3",0));
        mascotas.add(new Mascotas(R.drawable.mascota4,"Mascota 4",0));
        mascotas.add(new Mascotas(R.drawable.mascota5,"Mascota 5",0));
        mascotas.add(new Mascotas(R.drawable.mascota6,"Mascota 6",0));
        //return super.onCreateView(inflater, container, savedInstanceState);
        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdapdator();


        MascotasAdaptador adaptador = new MascotasAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);

        return v;
    }

    public void inicializarListaMascotas(){

    }

    public void inicializarAdapdator(){
    }



}

