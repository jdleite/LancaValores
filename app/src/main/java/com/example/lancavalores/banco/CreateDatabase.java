package com.example.lancavalores.banco;

import android.database.sqlite.SQLiteDatabase;

public class CreateDatabase {

    public void criar() {
        try {
            SQLiteDatabase db = MainDB.getInstancia().getWritableDatabase();
            String colunas = "(ID INTEGER PRIMERY KEY AUTOINCREMENT,VALOR REAL,DT_DEPOSITO VARCHAR)";
            String query = "CREATE TABLE IF NOT EXISTS " + MainDB.getInstancia() + colunas;
            db.execSQL(query);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void excluir(){
        try {
            SQLiteDatabase db = MainDB.getInstancia().getWritableDatabase();
            String query = "DROP TABLE IF EXISTS " + MainDB.TABELA;
            db.execSQL(query);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
