package com.idnp.lab06_idnp_sp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.idnp.lab06_idnp_sp.db.DbHelper;
import com.idnp.lab06_idnp_sp.db.dbUsuarios;

public class MainActivity extends AppCompatActivity {
    Context context;
    SharedPreferences s1;
    DbHelper dbHelper;
    SQLiteDatabase db;

    EditText edit_name,edit_correo,edit_dni;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_name = (EditText)findViewById(R.id.nombre);
        edit_correo = (EditText)findViewById(R.id.correo);
        edit_dni = (EditText)findViewById(R.id.dni);

        dbHelper  = new DbHelper(MainActivity.this);
        /*Inicialización de la clase manejadora de preferencias de la aplicación*/
        SharedPefManager.init(getApplicationContext());
        db = dbHelper.getWritableDatabase();
    }
    /*Boton para guardar los datos registrados en el formulario*/
    public void Continuar(View view){

        Intent i = new Intent(this, MenuActivity.class);
        String name = edit_name.getText().toString();
        String email = edit_correo.getText().toString();
        String dni = edit_dni.getText().toString();

        dbUsuarios usuario = new dbUsuarios(MainActivity.this);
        long id = usuario.insertarUsuario(name, dni, email);

        /*SharedPefManager.write(SharedPefManager.NAME,name);
        SharedPefManager.write(SharedPefManager.EMAIL,email);
        SharedPefManager.write(SharedPefManager.DNI,dni);*/
        startActivity(i);
    }
    /*Método para acceder al perfil sin registrar datos
    * sirve para verificar que el retorno de datos de las preferencias
    * de usuario funcionan.*/
    public void SinRegistrar(View view){

        Intent i = new Intent(this, MenuActivity.class);
        startActivity(i);
    }

}