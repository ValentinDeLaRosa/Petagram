package com.example.animalandia.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animalandia.Mascotas;
import com.example.animalandia.R;
import com.example.animalandia.adapter.MascotasAdaptador;

import java.util.ArrayList;

public class perfilFragment extends Fragment {
    ArrayList<Mascotas> mascotas;
    private RecyclerView rvPerfil;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        mascotas = new ArrayList<Mascotas>();
        /*mascotas.add(new Mascotas(R.drawable.mascota1,"Mascota 1",0));
        mascotas.add(new Mascotas(R.drawable.mascota2,"Mascota 2", 0));
        mascotas.add(new Mascotas(R.drawable.mascota3,"Mascota 3",0));
        mascotas.add(new Mascotas(R.drawable.mascota4,"Mascota 4",0));
        mascotas.add(new Mascotas(R.drawable.mascota5,"Mascota 5",0));
        mascotas.add(new Mascotas(R.drawable.mascota6,"Mascota 6",0));
        //return super.onCreateView(inflater, container, savedInstanceState);
        rvPerfil = (RecyclerView) v.findViewById(R.id.rvPerfil);
        GridLayoutManager glm = new GridLayoutManager(getActivity(),3,GridLayoutManager.VERTICAL, false);
        rvPerfil.setLayoutManager(glm);
        MascotasAdaptador adaptador = new MascotasAdaptador(mascotas);
        rvPerfil.setAdapter(adaptador);*/

        return v;
    }



}
