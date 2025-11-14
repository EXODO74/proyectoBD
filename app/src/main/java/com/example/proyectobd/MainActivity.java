package com.example.proyectobd;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
Button pcontibt,pregisbt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     pcontibt= findViewById(R.id.pcontibt);
     pregisbt= findViewById(R.id.pregisbt);

     pcontibt.setOnClickListener(v -> {
         Intent intent= new Intent(MainActivity.this,inicio.class);
         startActivity(intent);
     });
     pregisbt.setOnClickListener(v -> {
         Intent intent= new Intent(MainActivity.this,registrar.class);
         startActivity(intent);
     });

    }
}