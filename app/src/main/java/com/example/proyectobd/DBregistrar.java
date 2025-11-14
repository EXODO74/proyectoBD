package com.example.proyectobd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBregistrar extends SQLiteOpenHelper {
    public DBregistrar(@Nullable Context context){
        super(context, "registrar.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      db.execSQL("CREATE TABLE usuarios(" +
              "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
              "nombre TEXT, " +
              "telefono TEXT, " +
              "correo TEXT, " +
              "password TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        onCreate(db);
    }

    public boolean registrado(Usuario usuario){
      SQLiteDatabase db=this.getWritableDatabase();
        ContentValues valores=new ContentValues();
        valores.put("nombre",usuario.getNombre());
        valores.put("telefono", usuario.getTelefono());
        valores.put("correo", usuario.getCorreo());
        valores.put("password", usuario.getPassword());

        if(usuario.getTelefono()!=null){
            valores.put("telefono", usuario.getTelefono());
        } else {
            valores.put("telefono","");
        }
        try{
            long resultado=db.insertOrThrow("usuarios",null,valores);
            db.close();
            return resultado!=-1;
        } catch (SQLException e) {
            Log.e("DB_error","Error al insertar usuario: "+e.getMessage());
            return false;
        }
    }
    public ArrayList<Usuario> obtenerUsuario(){
        ArrayList<Usuario> lista=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM usuarios",null);
        if(cursor.moveToFirst()){
            do{
                Usuario usuario=new Usuario(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4)
                );
                lista.add(usuario);
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return lista;
    }
}
