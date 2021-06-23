package com.example.petagram;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import java.util.ArrayList;

public class activity1 extends AppCompatActivity {
ArrayList<mascota> mascotas;
private RecyclerView listaMascotas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        LinearLayoutManager LLM = new LinearLayoutManager(this);
        LLM.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(LLM);
        inicializasMascotas();
        inicializarAdaptador();





        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void inicializasMascotas(){
        mascotas = new ArrayList<mascota>();
        mascotas.add(new mascota(R.drawable.d_nq_np_915896_mco43523792971_092020_o, "Wendy", "Blanco - negro", "11"));
        mascotas.add(new mascota(R.drawable.descarga, "Flora", "Beige", "9"));
        mascotas.add(new mascota(R.drawable.dogecoin_memejpg, "Kitty", "Gris", "3"));
        mascotas.add(new mascota(R.drawable.dogecoin_memejpg, "Nicol", "negro", "3"));
    }

    public void inicializarAdaptador(){
        adapter adaptador = new adapter(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }
}