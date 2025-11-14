package com.example.proyectobd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class registrar extends AppCompatActivity implements View.OnClickListener {
    EditText rnombretxt,rtelefonotxt,rcorreotxt,rcontratxt;
    Button rconfirmarbt;
    DBregistrar dbregis ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrar);

        rnombretxt=findViewById(R.id.rnombretxt);
        rtelefonotxt=findViewById(R.id.rtelefonotxt);
        rcorreotxt=findViewById(R.id.rcorreotxt);
        rcontratxt=findViewById(R.id.rcontratxt);
        rconfirmarbt=findViewById(R.id.rconfirmarbt);
        dbregis=new DBregistrar(this);
        rconfirmarbt.setOnClickListener(this);
    }
    @Override
    public void onClick(View view){
        String nombre=rnombretxt.getText().toString();
        String telefono=rtelefonotxt.getText().toString();
        String correo=rcorreotxt.getText().toString();
        String password=rcontratxt.getText().toString();

        Usuario  usuario=new Usuario(0,nombre,telefono,correo,password);
        boolean exito=dbregis.registrado(usuario);
        if(exito){
            Toast.makeText(registrar.this,"Registro exitoso",Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(registrar.this,confirmar.class);
            intent.putExtra("correo",usuario.getCorreo());
            startActivity(intent);
        } else{
            Toast.makeText(getApplicationContext(),"Registro fallido",Toast.LENGTH_SHORT).show();
        }
    }
}
