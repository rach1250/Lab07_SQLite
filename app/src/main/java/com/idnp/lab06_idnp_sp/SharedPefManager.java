package com.idnp.lab06_idnp_sp;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class SharedPefManager {
    private static SharedPreferences objSharedPreferences;
    /*Creacion de variables asociadas a las claves que se guardan en preferencias*/
    public static final String NAME= "NAME";
    public static final String EMAIL= "EMAIL";
    public static final String DNI= "DNI";
    /*Creación del objeto editor para eliminar las claves de preferencias en el método borrarPreferencias*/
    private SharedPreferences.Editor editor;

    private SharedPefManager(){

    }
    /*Método para inicializar el objeto de shared Preferences*/
    public static void init(Context context){
        if(objSharedPreferences == null){
            objSharedPreferences = context.getSharedPreferences(context.getPackageName(), Activity.MODE_PRIVATE);
        }
    }
    /*Metodo para leer datos guardados en las preferencias de usuario*/
    public static String read(String key, String defValue) {
        return objSharedPreferences.getString(key, defValue);
    }
    /*Metodo para escribir en el archivo de preferencias de usuario*/
    public static void write(String key, String value) {
        SharedPreferences.Editor prefsEditor = objSharedPreferences.edit();
        prefsEditor.putString(key, value);
        prefsEditor.commit();
    }
    /*Método para borrar los datos guardados de preferencias de usuario*/
    public static void borrarPreferencias(){
        SharedPreferences.Editor editor = objSharedPreferences.edit();
        editor.clear();
        editor.commit();
    }
}
