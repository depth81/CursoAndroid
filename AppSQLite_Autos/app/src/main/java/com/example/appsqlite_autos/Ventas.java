package com.example.appsqlite_autos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Ventas extends AppCompatActivity {

    TextView jtvVentas, jtvSINOv;
    EditText jetPlacaV, jetModeloV, jetMarcaV, jetValorV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventas);

        getSupportActionBar().hide();

        jtvVentas = findViewById(R.id.tvVentas);
        jtvSINOv = findViewById(R.id.tvSINOv);
        jetPlacaV = findViewById(R.id.etPlacaV);
        jetModeloV = findViewById(R.id.etModeloV);
        jetMarcaV = findViewById(R.id.etMarcaV);
        jetValorV = findViewById(R.id.etValorV);

    }


    public void LimpiarVentas(View V){limpiarDatos();}

    public void limpiarDatos(){

        jetValorV.setText("");
        jtvSINOv.setText("SI / NO");
        jetMarcaV.setText("");
        jetModeloV.setText("");
        jetPlacaV.setText("");

    }

    public void RegresarVentas(View v){

        //Regresar al MainActivity
        Intent intMain  = new Intent(this,MainActivity.class);
        //Lanzar la actividad
        startActivity(intMain);
    }

}