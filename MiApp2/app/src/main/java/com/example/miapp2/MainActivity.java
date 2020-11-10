package com.example.miapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2, et3;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.txtMatematicas);
        et2 = (EditText)findViewById(R.id.txtFisica);
        et3 = (EditText)findViewById(R.id.txtQuimica);
        tv1 = findViewById(R.id.tvEstatus);

    }

    public void estatus(View view){

        String Matematicas_String = et1.getText().toString();
        String Fisica_String = et2.getText().toString();
        String Quimica_String = et3.getText().toString();

        int Matematicas_int = Integer.parseInt(Matematicas_String);
        int Fisica_int = Integer.parseInt(Fisica_String);
        int Quimica_int = Integer.parseInt(Quimica_String);

        int promedio = (Matematicas_int + Fisica_int + Quimica_int) / 3;

        if(promedio >= 6){
            tv1.setText("Estatus: Aprobado con " + promedio);
        }else{
            tv1.setText("Estatus: Reprobado con " + promedio);
        }

    }

}