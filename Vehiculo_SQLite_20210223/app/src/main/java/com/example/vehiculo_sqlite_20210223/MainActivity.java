package com.example.vehiculo_sqlite_20210223;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText jetPlaca, jetMarca, jetModelo, jetValor;
    Button jbtnGuardar, jbtnConsultar, jbtnEliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        jetPlaca = findViewById(R.id.etPlaca);
        jetMarca = findViewById(R.id.etMarca);
        jetModelo = findViewById(R.id.etModelo);
        jetValor = findViewById(R.id.etValor);
        jbtnGuardar = findViewById(R.id.btnGuardar);
        jbtnConsultar = findViewById(R.id.btnConsultar);
        jbtnEliminar = findViewById(R.id.btnEliminar);

    }//END onCreate()

    public void guardar(View v){

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "bdConcesionario", null, 1);
        SQLiteDatabase mydb = admin.getWritableDatabase();

        String placa, marca, modelo, valor;

        placa = jetPlaca.getText().toString();
        marca = jetMarca.getText().toString();
        modelo = jetModelo.getText().toString();
        valor = jetValor.getText().toString();

        if(placa.isEmpty() || marca.isEmpty() || modelo.isEmpty() || valor.isEmpty()){
            Toast.makeText(this, "Todos los datos son obligatorios", Toast.LENGTH_SHORT).show();
            jetPlaca.requestFocus();
        }else{

        }

    }

}//END MainActivity