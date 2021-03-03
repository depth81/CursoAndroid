package com.example.vehiculo_sqlite_20210223;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText jetPlaca, jetMarca, jetModelo, jetValor;
    Button jbtnGuardar, jbtnConsultar, jbtnEliminar, jbtnLimpiar;
    int sw = 0;
    long resp;

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
        jbtnLimpiar = findViewById(R.id.btnLimpiar);

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
            ContentValues datos = new ContentValues();
            datos.put("placa", placa);
            datos.put("marca", marca);
            datos.put("modelo", modelo);
            datos.put("valor", valor);

            if(sw == 0){
                resp = mydb.insert("tblAuto",null, datos);
            }else{
                resp = mydb.update("tblAuto", datos,"placa='" + placa + "'", null);
                sw=0;
            }

            //resp = mydb.insert("tblAuto", null, datos);

            if(resp != -1){
                Toast.makeText(this, "Registro guardado ", Toast.LENGTH_SHORT).show();
                limpiar();
            }else{
                Toast.makeText(this,"Ha habido un error", Toast.LENGTH_SHORT).show();
            }
        }
        mydb.close();
    }

    public void limpiar(){
        jetPlaca.setText("");
        jetValor.setText("");
        jetModelo.setText("");
        jetMarca.setText("");
        jetPlaca.requestFocus();
        sw=0;
    }

    public void limpiarDatos(View v){
        limpiar();
    }

    public void consultar(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "bdConcesionario", null, 1);
        SQLiteDatabase mydb = admin.getReadableDatabase();

        String placa = jetPlaca.getText().toString();

        if(placa.isEmpty()){
            Toast.makeText(this,"La placa es requerida", Toast.LENGTH_SHORT).show();
            jetPlaca.requestFocus();
        }else{
            Cursor myCursor = mydb.rawQuery("select * from tblAuto where placa = '" + placa + "'", null);
            if(myCursor.moveToFirst()){
                jetMarca.setText(myCursor.getString(1));
                jetModelo.setText(myCursor.getString(2));
                jetValor.setText(myCursor.getString(3));
                sw=1;
            }else{
                Toast.makeText(this, "Automovil no registrado", Toast.LENGTH_SHORT).show();
                jetPlaca.requestFocus();
            }
        }

        mydb.close();

    }

}//END MainActivity