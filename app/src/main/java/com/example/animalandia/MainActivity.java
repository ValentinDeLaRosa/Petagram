package com.example.animalandia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascotas> mascotas;

    private RecyclerView listaMascotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdapdator();

        Toolbar miToolbar = findViewById(R.id.MiToolbar);
        setSupportActionBar(miToolbar);


    }

    public void inicializarAdapdator(){

        MascotasAdaptador adaptador = new MascotasAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }


    public void inicializarListaMascotas(){

        mascotas = new ArrayList<Mascotas>();

        mascotas.add(new Mascotas(R.drawable.mascota1,"Mascota 1",0));
        mascotas.add(new Mascotas(R.drawable.mascota2,"Mascota 2", 0));
        mascotas.add(new Mascotas(R.drawable.mascota3,"Mascota 3",0));
        mascotas.add(new Mascotas(R.drawable.mascota4,"Mascota 4",0));
        mascotas.add(new Mascotas(R.drawable.mascota5,"Mascota 5",0));
        mascotas.add(new Mascotas(R.drawable.mascota6,"Mascota 6",0));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent i = new Intent(this, MascotasRanqueadas.class);


        ArrayList<Mascotas> mascotasOrdenadas = new ArrayList<>();

        for (int j = 0 ; j< mascotas.size(); ++j){

          mascotasOrdenadas.add(new Mascotas(mascotas.get(j).getFoto(), mascotas.get(j).getNombre() , mascotas.get(j).getConteo()));

        }

        Collections.sort(mascotasOrdenadas);

        ArrayList<Integer> imagen = new ArrayList<>();
        ArrayList<String>  nombre = new ArrayList<>();
        ArrayList<Integer> likes  = new ArrayList<>();

        for ( int k = 0; k < 5 ; ++k){

            imagen.add(mascotasOrdenadas.get(k).getFoto());
            nombre.add(mascotasOrdenadas.get(k).getNombre());
            likes.add(mascotasOrdenadas.get(k).getConteo());

        }

        i.putExtra("imagen" , imagen);
        i.putExtra("nombre" , nombre);
        i.putExtra("likes" , likes);

        startActivity(i);
        return super.onOptionsItemSelected(item);
    }
}