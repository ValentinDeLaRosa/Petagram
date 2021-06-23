package com.example.petagram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class detalleMascota extends AppCompatActivity {
    TextView tvNombre;
    TextView tvColor;
    TextView tvEdad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_mascota);
        Bundle datos = getIntent().getExtras();
        String nombre = datos.getString("nombre");
        String color = datos.getString("color");
        String edad = datos.getString("edad");

        tvNombre = (TextView) findViewById(R.id.txtdNombre);
        tvColor = (TextView) findViewById((R.id.txtdColor));
        tvEdad = (TextView) findViewById(R.id.txtdEdad);

        tvNombre.setText(nombre);
        tvColor.setText(color);
        tvEdad.setText(edad);
    }
}