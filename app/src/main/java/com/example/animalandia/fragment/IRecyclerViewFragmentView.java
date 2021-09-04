package com.example.animalandia.fragment;

import com.example.animalandia.Mascotas;
import com.example.animalandia.adapter.MascotasAdaptador;

import java.util.ArrayList;

public interface IRecyclerViewFragmentView {
    public void generarLinearLayoutVertical();
    public MascotasAdaptador crearAdaptador(ArrayList<Mascotas> mascotas);
    public void inicializarAdaptadorRV(MascotasAdaptador adaptador);

}
