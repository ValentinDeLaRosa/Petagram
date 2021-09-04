package com.example.animalandia.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.animalandia.Mascotas;
import com.example.animalandia.R;

import java.util.ArrayList;

public class ConstructorMascotas {
    private static final int LIKE = 1;
    private Context context;
    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascotas> obtenerMascotas(){
        /*
        ArrayList<Mascotas> mascotas = new ArrayList<>();
        mascotas.add(new Mascotas(R.drawable.mascota1,"Mascota 1",0));
        mascotas.add(new Mascotas(R.drawable.mascota2,"Mascota 2", 0));
        mascotas.add(new Mascotas(R.drawable.mascota3,"Mascota 3",0));
        mascotas.add(new Mascotas(R.drawable.mascota4,"Mascota 4",0));
        mascotas.add(new Mascotas(R.drawable.mascota5,"Mascota 5",0));
        mascotas.add(new Mascotas(R.drawable.mascota6,"Mascota 6",0));
        return mascotas;*/

        baseDatosAuxiliar db = new baseDatosAuxiliar((context));
        insertarCincoMascotas(db);
        return db.obtenerTodasLasMascotas();
    }

    public void  insertarCincoMascotas(baseDatosAuxiliar db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(constantesBD.TABLE_MASCOTAS_NOMBRE, "PERRO1");
        contentValues.put(constantesBD.TABLE_MASCOTAS_FOTO, R.drawable.mascota1);

        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(constantesBD.TABLE_MASCOTAS_NOMBRE, "PERRO2");
        contentValues.put(constantesBD.TABLE_MASCOTAS_FOTO, R.drawable.mascota2);

        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(constantesBD.TABLE_MASCOTAS_NOMBRE, "PERRO3");
        contentValues.put(constantesBD.TABLE_MASCOTAS_FOTO, R.drawable.mascota3);

        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(constantesBD.TABLE_MASCOTAS_NOMBRE, "PERRO4");
        contentValues.put(constantesBD.TABLE_MASCOTAS_FOTO, R.drawable.mascota4);

        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(constantesBD.TABLE_MASCOTAS_NOMBRE, "PERRO5");
        contentValues.put(constantesBD.TABLE_MASCOTAS_FOTO, R.drawable.mascota5);

        db.insertarMascotas(contentValues);
    }

    public void darLikeMascota(Mascotas mascota){
        baseDatosAuxiliar db = new baseDatosAuxiliar(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(constantesBD.TABLE_CONTEO_ID_MASCOTA, mascota.getId());
        contentValues.put(constantesBD.TABLE_CONTEO_LIKES, LIKE);
        System.out.println("=============================================================================================================================");
        System.out.println("=============================================================================================================================");
        System.out.println("=============================================================================================================================");
        System.out.println("=============================================================================================================================");
        System.out.println("=============================================================================================================================");
        System.out.println("=============================================================================================================================");
        System.out.println("=============================================================================================================================");
        System.out.println("=============================================================================================================================");
                System.out.println(contentValues);
        db.insertarLikeMascota(contentValues);
    }

    public int obtenerLikesMascota (Mascotas mascota){
        baseDatosAuxiliar db = new baseDatosAuxiliar(context);
        return db.obtenerLikesMascota(mascota);
    }
}
