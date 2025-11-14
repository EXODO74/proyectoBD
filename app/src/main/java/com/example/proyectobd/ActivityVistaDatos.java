package com.example.proyectobd;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ActivityVistaDatos extends AppCompatActivity {
    private RecyclerView recyclerUsuario;
    private UsuarioAdapter usuarioAdapter;
    private List<Usuario> listaUsuarios;
    private DBregistrar db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_datos);

        recyclerUsuario = findViewById(R.id.RecyclerUsuario);
        recyclerUsuario.setLayoutManager(new LinearLayoutManager(this));
        db = new DBregistrar(this);
        listaUsuarios = db.obtenerUsuario();
        usuarioAdapter = new UsuarioAdapter(listaUsuarios);
        recyclerUsuario.setAdapter(usuarioAdapter);

    }
}