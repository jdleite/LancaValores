package com.example.lancavalores.listener;

//Interface que funciona como um listener para passar o valor do id entre as classes e o viewHolder
public interface DepositoInterface {
    void onListClick(int id);

    void onDeleteClick(int id);
}
