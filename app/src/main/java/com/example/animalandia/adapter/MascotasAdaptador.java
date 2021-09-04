package com.example.animalandia.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animalandia.DB.ConstructorMascotas;
import com.example.animalandia.Mascotas;
import com.example.animalandia.R;

import java.util.ArrayList;

public class MascotasAdaptador extends RecyclerView.Adapter<MascotasAdaptador.MascotasViewHolder> {

    ArrayList<Mascotas> mascotas;
    Activity activity;
    Integer             contador;



    public MascotasAdaptador(ArrayList<Mascotas> mascotas, Activity activity){
        this.activity = activity;
        this.mascotas = mascotas;
    }



    @NonNull
    @Override
    public MascotasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas, parent, false);
        return new MascotasViewHolder(v);
    }
    //Asocia cada elemento de la lista con cada view.
    @Override
    public void onBindViewHolder(@NonNull MascotasViewHolder mascotasViewHolder, int position) {

        Mascotas mascota = mascotas.get(position);
        String stringconteo = Integer.toString(mascota.getConteo());
        mascotasViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotasViewHolder.tvNombreCV.setText(mascota.getNombre());
        mascotasViewHolder.conteoLikes.setText(stringconteo);
        System.out.println(mascota.getId());


        mascotasViewHolder.btnLike.setOnClickListener(new View.OnClickListener(){
            public void  onClick(View v){
                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity); //Revisar el activity
                constructorMascotas.darLikeMascota(mascota);
                System.out.println(constructorMascotas.obtenerLikesMascota(mascota));
                mascotasViewHolder.conteoLikes.setText(constructorMascotas.obtenerLikesMascota(mascota)+"");


            }

        });

      //  String contadorPalabra = contador.toString();
    }

    @Override
    public int getItemCount() {   // Cantidad de elementos que contiene la lista, en este caso de mascotas
        return mascotas.size();
    }

    public static class  MascotasViewHolder extends RecyclerView.ViewHolder{

        private ImageView   imgFoto;
        private TextView    tvNombreCV;
        private ImageButton btnLike;
        private TextView    conteoLikes;




        public MascotasViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto     =   (ImageView)     itemView.findViewById(R.id.imgFoto);
            tvNombreCV  =   (TextView)      itemView.findViewById(R.id.tvNombre);
            btnLike     =   (ImageButton)   itemView.findViewById(R.id.btnLike);
            conteoLikes =   (TextView)      itemView.findViewById(R.id.ConteodeLikes);

        }
    }

}
