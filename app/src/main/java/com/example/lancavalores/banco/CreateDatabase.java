package com.example.lancavalores.banco;

import android.database.sqlite.SQLiteDatabase;

public class CreateDatabase {
    //Cria o banco
    public boolean criar() {
        try {
            SQLiteDatabase db = MainDB.getInstancia().getWritableDatabase();
            String colunas = "(ID INTEGER PRIMARY KEY AUTOINCREMENT,VALOR REAL,DT_DEPOSITO VARCHAR)";
            String query = "CREATE TABLE IF NOT EXISTS " + MainDB.TABELA + colunas;
            db.execSQL(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;


    }

    //Exclui o banco
    public void excluir() {
        try {
            SQLiteDatabase db = MainDB.getInstancia().getWritableDatabase();
            String query = "DROP TABLE IF EXISTS " + MainDB.TABELA;
            db.execSQL(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
