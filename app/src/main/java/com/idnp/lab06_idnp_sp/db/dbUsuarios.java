package com.idnp.lab06_idnp_sp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.idnp.lab06_idnp_sp.entidades.Usuario;

public class dbUsuarios extends  DbHelper{
    Context context;

    public dbUsuarios(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarUsuario(String nombre, String dni, String correo){
        long id = 0;
        try{
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nombre", nombre);
            values.put("dni", dni);
            values.put("correo", correo);

            id = db.insert(TABLA, null, values);
        }
        catch(Exception e){
            e.toString();
        }
        return id;
    }

    public Usuario retornarDatoUsuario(){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Usuario user = new Usuario();

        Cursor cursorUser = db.rawQuery("SELECT * FROM "+ TABLA, null);

        cursorUser.moveToFirst();
        user.setId(cursorUser.getInt(0));
        user.setNombre(cursorUser.getString(1));
        user.setDni(cursorUser.getString(2));
        user.setCorreo(cursorUser.getString(3));

        return user;
    }
}
