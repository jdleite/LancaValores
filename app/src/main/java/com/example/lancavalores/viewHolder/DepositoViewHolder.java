package com.example.lancavalores.viewHolder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lancavalores.R;
import com.example.lancavalores.entidade.Deposito;
import com.example.lancavalores.listener.DepositoInterface;

public class DepositoViewHolder extends RecyclerView.ViewHolder {

    TextView txtValor,txtDta;
    private Context mContext;


    public DepositoViewHolder(@NonNull View itemView,Context context) {
        super(itemView);

        txtValor = itemView.findViewById(R.id.valor_id);
        txtDta = itemView.findViewById(R.id.dt_valor_id);
        mContext = context;
    }

    public  void bindData(Deposito deposito,DepositoInterface listener){
        txtValor.setText(String.valueOf(deposito.getValor()));
        txtDta.setText(deposito.getDt_deposito());
    }
}
