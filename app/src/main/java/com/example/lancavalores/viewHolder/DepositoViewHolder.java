package com.example.lancavalores.viewHolder;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lancavalores.R;
import com.example.lancavalores.entidade.Deposito;
import com.example.lancavalores.listener.DepositoInterface;

import java.text.NumberFormat;

//A viewHolder para listar o valor e a data no list da activity principal

public class DepositoViewHolder extends RecyclerView.ViewHolder {

    private TextView txtValor, txtDta;
    private Context mContext;
    public static int point;


    public DepositoViewHolder(@NonNull View itemView, Context context) {
        super(itemView);

        txtValor = itemView.findViewById(R.id.valor_id);
        txtDta = itemView.findViewById(R.id.dt_valor_id);
        mContext = context;
    }

    public void bindData(final Deposito deposito, final DepositoInterface listener) {
        txtValor.setText(NumberFormat.getCurrencyInstance().format(deposito.getValor()));
        txtDta.setText(deposito.getDt_deposito());


        txtValor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                point = 1;
                listener.onListClick(deposito.getId());


            }
        });

        txtValor.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                new AlertDialog.Builder(mContext)
                        .setTitle(mContext.getString(R.string.remocao_titulo))
                        .setMessage(mContext.getString(R.string.remocao_valor))
                        .setIcon(R.drawable.remove)
                        .setPositiveButton(mContext.getString(R.string.sim), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                listener.onDeleteClick(deposito.getId());
                            }
                        })
                        .setNeutralButton(mContext.getString(R.string.nao), null)
                        .show();

                return true;
            }
        });
    }
}
