package com.example.lancavalores.banco;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MainDB extends SQLiteOpenHelper {
    public static String NOME_DB = "BANCO";
    public static String TABELA = "DEPOSITO";
    private static int VERSAO = 1;



    private static MainDB instancia;

    public static MainDB getInstancia(){
        if (instancia == null) instancia = new MainDB();
        return instancia;
    }

    public MainDB() {
        super(MyApp.getContext(), NOME_DB, null, VERSAO);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    @Override
    public synchronized void close() {
        super.close();

    }
}
