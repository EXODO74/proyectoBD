package com.example.proyectobd;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class confirmar extends AppCompatActivity {
    Button btver;
    EditText vcorreotxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmar);

        EditText vcorreotxt=findViewById(R.id.vcorreotxt);
        Button btver=findViewById(R.id.btver);
        String correo=getIntent().getStringExtra("correo");
        if(correo!=null){
            vcorreotxt.setText(correo);
        }else {
            vcorreotxt.setText("correo no encontrado");
        }
        btver.setOnClickListener(v -> {
            Intent intent= new Intent(confirmar.this,ActivityVistaDatos.class);
            startActivity(intent);
        });
    }
}
