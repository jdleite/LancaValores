package com.example.lancavalores.repositorio;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.example.lancavalores.banco.MainDB;
import com.example.lancavalores.constantes.DepositoConstantes;
import com.example.lancavalores.entidade.Deposito;

public class valoresRepositorio {

    public boolean cadastrar(Deposito deposito){
        try {
            SQLiteDatabase db = MainDB.getInstancia().getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put(DepositoConstantes.VALOR,deposito.getValor());
            cv.put(DepositoConstantes.VALOR,deposito.getDt_deposito());
            db.insert(MainDB.TABELA,null,cv);
        }catch (Exception e){
            e.printStackTrace();
        }

        return true;
    }
}
