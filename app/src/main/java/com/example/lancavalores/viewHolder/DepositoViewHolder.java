package com.example.lancavalores.viewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lancavalores.R;
import com.example.lancavalores.entidade.Deposito;

public class DepositoViewHolder extends RecyclerView.ViewHolder {

    TextView txtValor;


    public DepositoViewHolder(@NonNull View itemView) {
        super(itemView);

        txtValor = itemView.findViewById(R.id.valor_id);
    }

    public  void bindData(Deposito deposito){
        txtValor.setText(String.valueOf(deposito.getValor()));
    }
}
