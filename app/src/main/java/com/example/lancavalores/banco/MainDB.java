package com.example.lancavalores.banco;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//Classe que cria o nome.tabela e a versão do banco
public class MainDB extends SQLiteOpenHelper {
    public static String NOME_DB = "BANCO";
    public static String TABELA = "DEPOSITO";
    private static int VERSAO = 1;


    private static MainDB instancia;

    //Cria um instancia do banco
    public static MainDB getInstancia() {
        if (instancia == null) instancia = new MainDB();
        return instancia;
    }

    //Construtor da classe com o context,nome do banco, e a versão
    public MainDB() {
        super(MyApp.getContext(), NOME_DB, null, VERSAO);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //Esse metodo fecha o banco
    @Override
    public synchronized void close() {
        super.close();

    }
}
