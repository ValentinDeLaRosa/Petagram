package com.example.animalandia;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.animalandia.adapter.MascotasAdaptador;
import com.example.animalandia.adapter.pageAdapter;
import com.example.animalandia.fragment.fragmentRecyclerView;
import com.example.animalandia.fragment.perfilFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascotas> mascotas;
     RecyclerView listaMascotas;
     Toolbar toolbar;
     TabLayout tabLayout;
     ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar miToolbar = findViewById(R.id.MiToolbar);
        setSupportActionBar(miToolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setupViewPager();


    }

    private ArrayList<Fragment> agregarFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new fragmentRecyclerView());
        fragments.add(new perfilFragment());
        return fragments;


    }

    private void setupViewPager() {
        viewPager.setAdapter((new pageAdapter(getSupportFragmentManager(), agregarFragments())));
        tabLayout.setupWithViewPager((viewPager));
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_paw);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_star);
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        getMenuInflater().inflate(R.menu.menu_opciones, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mAbout:
                Intent about = new Intent(this, activityAbout.class);
                startActivity(about);
                break;

            case R.id.mContact:
                Intent settings = new Intent(this, activityContact.class);
                startActivity(settings);
                break;

            case R.id.TopCinco:
                Intent i = new Intent(this, MascotasRanqueadas.class);
                ArrayList<Mascotas> mascotasOrdenadas = new ArrayList<>();
                /*for (int j = 0; j < mascotas.size(); ++j) {
                    mascotasOrdenadas.add(new Mascotas(mascotas.get(j).getFoto(), mascotas.get(j).getNombre(), mascotas.get(j).getConteo()));
                }*/
                Collections.sort(mascotasOrdenadas);
                ArrayList<Integer> imagen = new ArrayList<>();
                ArrayList<String> nombre = new ArrayList<>();
                ArrayList<Integer> likes = new ArrayList<>();
                /*for (int k = 0; k < 5; ++k) {
                    imagen.add(mascotasOrdenadas.get(k).getFoto());
                    nombre.add(mascotasOrdenadas.get(k).getNombre());
                    likes.add(mascotasOrdenadas.get(k).getConteo());
                }*/

                i.putExtra("imagen", imagen);
                i.putExtra("nombre", nombre);
                i.putExtra("likes", likes);

                startActivity(i);
                break;

        }
        return super.onOptionsItemSelected(item);

    }
}