package com.example.animalandia.DB;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.animalandia.Mascotas;

import java.util.ArrayList;

public class baseDatosAuxiliar extends SQLiteOpenHelper {
    private Context context;

    public baseDatosAuxiliar(@Nullable Context context) {
        super(context, constantesBD.DATABASE_NAME, null, constantesBD.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascota = "CREATE TABLE " + constantesBD.TABLE_MASCOTAS + " (" +
                constantesBD.TABLE_MASCOTAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                constantesBD.TABLE_MASCOTAS_NOMBRE + " TEXT, " +
                constantesBD.TABLE_MASCOTAS_FOTO + " INTEGER)";
        String queryCrearTablaLikesMascota = "CREATE TABLE " + constantesBD.TABLE_CONTEO + " (" +
                constantesBD.TABLE_CONTEO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                constantesBD.TABLE_CONTEO_ID_MASCOTA + " INTEGER, " +
                constantesBD.TABLE_CONTEO_LIKES + " INTEGER," +
                "FOREIGN KEY (" + constantesBD.TABLE_CONTEO_ID_MASCOTA + ") " +
                "REFERENCES " + constantesBD.TABLE_MASCOTAS + "(" + constantesBD.TABLE_MASCOTAS_ID + ")" +
                ")";
        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaLikesMascota);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + constantesBD.TABLE_MASCOTAS);
        db.execSQL("DROP TABLE IF EXISTS " + constantesBD.TABLE_CONTEO);
        onCreate(db);
    }

    public ArrayList<Mascotas> obtenerTodasLasMascotas () {
        ArrayList <Mascotas> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + constantesBD.TABLE_MASCOTAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()) {
            Mascotas mascotaActual = new Mascotas();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));

            mascotas.add(mascotaActual);
        }
        db.close();

        return mascotas;
    }

    public void insertarMascotas(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(constantesBD.TABLE_MASCOTAS, null, contentValues);
        db.close();
    }

    public void insertarLikeMascota(ContentValues contentValues){
        System.out.println("INGRESO AL INSERTAR LIKE MASCOTAAAAAAAAAAAAAAAAAAAAAAAAAAAAS");
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(constantesBD.TABLE_CONTEO, null, contentValues);
        db.close();
    }

    public int obtenerLikesMascota(Mascotas mascota){
        int likes = 0;
        String query = "SELECT COUNT (" +constantesBD.TABLE_CONTEO_LIKES + ")" + "FROM " + constantesBD.TABLE_CONTEO + " WHERE " +
                constantesBD.TABLE_CONTEO_ID_MASCOTA + "= " + mascota.getId();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);
        if(registros.moveToNext()){
            likes =registros.getInt(0);
        }
        db.close();
        return likes;
    }
}
