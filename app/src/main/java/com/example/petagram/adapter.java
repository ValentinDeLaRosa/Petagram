package com.example.petagram;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapter extends  RecyclerView.Adapter<adapter.mascotaViewHolder>{

    ArrayList<mascota> mascotas;
    Activity activity;
    public adapter (ArrayList<mascota> mascotas, Activity activity){
        this.activity = activity;
        this.mascotas = mascotas;
    }

    @NonNull
    @Override
    public mascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent,false);
        return new mascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull mascotaViewHolder holder, int position) {
        mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.txtNombre.setText(mascota.getNombre());
        mascotaViewHolder.txtColor.setText(mascota.getColor());
        mascotaViewHolder.imgFoto.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, mascota.getNombre(), Toast.LENGTH_SHORT).show();
                System.out.println("CLICK");
                Intent intent = new Intent(activity, detalleMascota.class);
                intent.putExtra("nombre", mascota.getNombre());
                intent.putExtra("color", mascota.getColor());
                intent.putExtra("edad", mascota.getEdad());
                activity.startActivity(intent);
            }
        });

        mascotaViewHolder.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(mascota.getNombre());
            }
        });

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class mascotaViewHolder extends RecyclerView.ViewHolder {

        private static ImageView imgFoto;
        private static TextView txtNombre;
        private static TextView txtColor;
        private static ImageButton like;
        public mascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.fotoMascota);
            txtNombre = (TextView) itemView.findViewById(R.id.txtNombre);
            txtColor = (TextView) itemView.findViewById(R.id.txtColor);
            like = (ImageButton) itemView.findViewById((R.id.like));
        }
    }
}
