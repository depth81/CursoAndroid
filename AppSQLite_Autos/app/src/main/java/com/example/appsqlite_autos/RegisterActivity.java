package com.example.appsqlite_autos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText jetUsuario, jetNombre, jetClave1, jetClave2;
    Button jbtnConsultar, jbtnAdicionar, jbtnModificar, jbtnEliminar, jbtnLimpiar, jbtnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().hide();

        jetUsuario = findViewById(R.id.etUsuario);
        jetNombre = findViewById(R.id.etNombre);
        jetClave1 = findViewById(R.id.etClave1);
        jetClave2 = findViewById(R.id.etClave2);
        jbtnConsultar = findViewById(R.id.btnConsultar);
        jbtnAdicionar = findViewById(R.id.btnAdicionar);
        jbtnModificar = findViewById(R.id.btnModificar);
        jbtnEliminar = findViewById(R.id.btnEliminar);
        jbtnLimpiar = findViewById(R.id.btnLimpiar);
        jbtnRegresar = findViewById(R.id.btnRegresar);

    }

    public void Guardar(View v){

        MainSQLiteOpenHelper Admin = new MainSQLiteOpenHelper(this, "Concesionario", null, 1);

        //Abrir la conexión con la BD
        SQLiteDatabase mydb = Admin.getWritableDatabase();

        String usuario, nombre, clave1, clave2;

        //Pasar los datos a la memoria "intermedia" antes de insertar en la BD.
        usuario=jetUsuario.getText().toString();
        nombre=jetNombre.getText().toString();
        clave1=jetClave1.getText().toString();
        clave2=jetClave2.getText().toString();

        if(usuario.isEmpty() || nombre.isEmpty() || clave1.isEmpty() || clave2.isEmpty()){
            Toast.makeText(this, "Todos los datos son obligatorios", Toast.LENGTH_SHORT).show();
            jetUsuario.requestFocus();
        }
        else{
            if(!clave1.equals(clave2)){
                Toast.makeText(this, "Las claves no coinciden", Toast.LENGTH_SHORT).show();
                jetClave1.requestFocus();
            }
            else{

                //Definir un contenedor (ContentValues)
                ContentValues dato = new ContentValues();

                //En blanco lo de la memoria RAM intermedia o el contenedor.
                dato.put("idUsuario", usuario);
                dato.put("nombre", nombre);
                dato.put("clave", clave1);  //Ya se validaron las dos claves. Sirve cualquiera.

                //Guardar en la BD. Siempre responde en un "long"
                long resp = mydb.insert("tblUsuario", null, dato);

                if(resp > 0){
                    Toast.makeText(this, "Registro insertado con éxito", Toast.LENGTH_SHORT).show();
                    limpiarDatos();
                }
                else{
                    Toast.makeText(this, "Error guardando el registro", Toast.LENGTH_SHORT).show();
                }

            }
        }
        mydb.close();
    }

    public void Limpiar(View v){
        limpiarDatos();
    }

    //No tiene view como parámetro porque no está asociado a ninguna vista.
    public void limpiarDatos(){

        jetUsuario.setText("");
        jetNombre.setText("");
        jetClave1.setText("");
        jetClave2.setText("");
        jetUsuario.requestFocus();

    }

    public void Regresar(View v){

        //Regresar al MainActivity
        Intent intMain = new Intent(this,MainActivity.class);

        //Lanzar la actividad
        startActivity(intMain);
    }

}//END RegisterActivity