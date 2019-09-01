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

public class DepositoRepositorio {

    public boolean cadastrar(Deposito deposito) {
        try {
            SQLiteDatabase db = MainDB.getInstancia().getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put(DepositoConstantes.VALOR, deposito.getValor());
            cv.put(DepositoConstantes.DT_DEPOSITO, deposito.getDt_deposito());
            db.insert(MainDB.TABELA, null, cv);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MainDB.getInstancia().close();
        }

        return true;
    }

    public List<Deposito> listarDeposito() {
        List<Deposito> depositos = new ArrayList<>();
        try {
            SQLiteDatabase db = MainDB.getInstancia().getReadableDatabase();
            String query = "select * from " + MainDB.TABELA + " ORDER BY ID DESC";
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
        } finally {
            MainDB.getInstancia().close();
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
        } finally {
            MainDB.getInstancia().close();
        }
        return false;
    }

    public boolean alterar(Deposito deposito) {
        try {
            SQLiteDatabase db = MainDB.getInstancia().getWritableDatabase();

            ContentValues cv = new ContentValues();


            cv.put(DepositoConstantes.VALOR, deposito.getValor());
            cv.put(DepositoConstantes.DT_DEPOSITO, deposito.getDt_deposito());

            String where = " ID = '" + deposito.getId() + "'";
            db.update(MainDB.TABELA, cv, where, null);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MainDB.getInstancia().close();
        }
        return false;


    }

    public Deposito buscarPorId(int id) {
        Deposito deposito = new Deposito();
        try {
            SQLiteDatabase db = MainDB.getInstancia().getReadableDatabase();
            String query = "SELECT * FROM " + MainDB.TABELA + " WHERE ID = '" + id + "'";
            Cursor c = db.rawQuery(query, null);

            if (c.moveToFirst()) {
                deposito.setId(c.getInt(0));
                deposito.setValor(c.getDouble(1));
                deposito.setDt_deposito(c.getString(2));
            }

            if (c != null) {
                c.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MainDB.getInstancia().close();
        }
        return deposito;

    }
}
