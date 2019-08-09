package com.example.lancavalores.repositorio;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.lancavalores.banco.MainDB;
import com.example.lancavalores.constantes.DepositoConstantes;
import com.example.lancavalores.entidade.Deposito;

import java.util.ArrayList;
import java.util.List;

public class valoresRepositorio {

    public boolean cadastrar(Deposito deposito) {
        try {
            SQLiteDatabase db = MainDB.getInstancia().getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put(DepositoConstantes.VALOR, deposito.getValor());
            cv.put(DepositoConstantes.VALOR, deposito.getDt_deposito());
            db.insert(MainDB.TABELA, null, cv);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    public List<Deposito> listarDeposito() {
        List<Deposito> depositos = new ArrayList<>();
        try {
            SQLiteDatabase db = MainDB.getInstancia().getReadableDatabase();
            String query = "select * from " + MainDB.TABELA;
            Cursor cursor = db.rawQuery(query, null);

            if (cursor.moveToFirst()) {
                do {
                    Deposito deposito = new Deposito();
                    deposito.setId(cursor.getInt(0));
                    deposito.setValor(cursor.getDouble(1));
                    deposito.setDt_deposito(cursor.getString(2));
                    depositos.add(deposito);

                } while (cursor.moveToNext());
            }
            cursor.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return depositos;

    }

    public boolean deletar(int id) {
        try {
            SQLiteDatabase db = MainDB.getInstancia().getWritableDatabase();
            String whereClause = DepositoConstantes.ID + " = ?";
            String[] whereArgs = {String.valueOf(id)};
            db.delete(MainDB.TABELA, whereClause, whereArgs);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean alterar(Deposito deposito) {
        try {
            SQLiteDatabase db = MainDB.getInstancia().getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put(DepositoConstantes.VALOR, deposito.getValor());
            cv.put(DepositoConstantes.DT_DEPOSITO, deposito.getDt_deposito());

            String selection = DepositoConstantes.ID + " =?";
            String[] sectionArgs = {String.valueOf(deposito.getId())};
            db.update(MainDB.TABELA, cv, selection, sectionArgs);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;


    }

    public Deposito buscarPorId(int id) {
        Deposito deposito = new Deposito();
        try {
            SQLiteDatabase db = MainDB.getInstancia().getReadableDatabase();
            String query = "select * from " + MainDB.TABELA + "where id =" + id + "";
            Cursor c = db.rawQuery(query, null);

            if (c.moveToFirst()) {
                deposito.setId(c.getInt(0));
                deposito.setValor(c.getDouble(1));
                deposito.setDt_deposito(c.getString(2));
            }

            if (c != null){
                c.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return deposito;

    }
}
