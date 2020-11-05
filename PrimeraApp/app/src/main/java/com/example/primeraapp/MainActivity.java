package com.example.primeraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* this: Se pasa al constructor de la clase TextView la clase en donde nos encontramos,
         en este caso MainActivity */
        /* TextView miTexto = new TextView(this);

        miTexto.setText("Hola Paulo Enrique!");

        setContentView(miTexto);  //Vista que muestra la actividad. */

    }




}