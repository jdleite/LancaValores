package com.example.lancavalores.banco;

import android.app.Application;
import android.content.Context;

//Esse classe já define a contexto para passar para o banco, não tendo necessidade de criar um context toda vez que cria uma conexão
public class MyApp extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
