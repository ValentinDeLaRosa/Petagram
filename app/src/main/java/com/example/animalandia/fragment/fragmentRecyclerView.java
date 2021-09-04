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
import com.example.animalandia.presentador.IRecyclerViewFragmentPresenter;
import com.example.animalandia.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;
import java.util.Collections;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class fragmentRecyclerView extends Fragment implements  IRecyclerViewFragmentView{
    ArrayList<Mascotas> mascotas;
    private RecyclerView listaMascotas;
    private IRecyclerViewFragmentPresenter presenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recylerview, container, false);
        inicializarListaMascotas();
        //return super.onCreateView(inflater, container, savedInstanceState);
        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());
        inicializarAdapdator();

        return v;
    }

    public void inicializarListaMascotas(){


    }

    public void inicializarAdapdator(){
    }


    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotasAdaptador crearAdaptador(ArrayList<Mascotas> mascotas) {
        MascotasAdaptador adaptador = new MascotasAdaptador(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotasAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);

    }
}

