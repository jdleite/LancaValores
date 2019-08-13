package com.example.lancavalores.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lancavalores.R;
import com.example.lancavalores.entidade.Deposito;
import com.example.lancavalores.listener.DepositoInterface;
import com.example.lancavalores.viewHolder.DepositoViewHolder;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<DepositoViewHolder> {

    private List<Deposito> mDepositos;
    private DepositoInterface listener;


    public Adapter(List<Deposito> depositos, DepositoInterface depositoInterface) {
        mDepositos = depositos;
        listener = depositoInterface;
    }


    @NonNull
    @Override
    public DepositoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.depositro_row, parent, false);

        return new DepositoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DepositoViewHolder holder, int position) {

        Deposito deposito = mDepositos.get(position);

        holder.bindData(deposito);


    }

    @Override
    public int getItemCount() {
        return mDepositos.size();
    }
}
