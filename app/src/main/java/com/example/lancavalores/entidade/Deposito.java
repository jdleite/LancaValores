package com.example.lancavalores.entidade;

public class Deposito {
    private int id;
    private double valor;
    private String dt_deposito;

    public Deposito(){

    }

    public Deposito(int id, double valor, String dt_deposito) {
        this.id = id;
        this.valor = valor;
        this.dt_deposito = dt_deposito;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDt_deposito() {
        return dt_deposito;
    }

    public void setDt_deposito(String dt_deposito) {
        this.dt_deposito = dt_deposito;
    }
}
