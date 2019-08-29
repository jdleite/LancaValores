package com.example.lancavalores.views;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.lancavalores.R;
import com.example.lancavalores.entidade.Deposito;
import com.example.lancavalores.repositorio.DepositoRepositorio;

import java.util.Calendar;

public class CustomDialog extends DialogFragment {

    private ViewHolder viewHolder = new ViewHolder();
    private DepositoRepositorio repositorio;
    private AtualizaListener atualiza;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_custom, container, false);


        viewHolder.edtValor = view.findViewById(R.id.edt_valor_id);
        viewHolder.edtData = view.findViewById(R.id.data_valor_id);
        viewHolder.txt_ok = view.findViewById(R.id.ok_id);
        viewHolder.txt_cancelar = view.findViewById(R.id.cancel_id);
        final Deposito deposito = new Deposito();
        repositorio = new DepositoRepositorio();
        Calendar c = Calendar.getInstance();

        final int dia = c.get(Calendar.DAY_OF_MONTH);
        final int mes = c.get(Calendar.MONTH) + 1;
        final int ano = c.get(Calendar.YEAR);

        viewHolder.edtData.setText(dia + "/" + mes + "/" + ano);


        viewHolder.txt_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deposito.setValor(Double.parseDouble(viewHolder.edtValor.getText().toString()));
                deposito.setDt_deposito(viewHolder.edtData.getText().toString());
                repositorio.cadastrar(deposito);
                atualiza.atualizar(viewHolder.edtValor.getText().toString());
                getDialog().dismiss();
            }
        });

        viewHolder.txt_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDialog().dismiss();
            }
        });

        carregarDados();

        return view;
    }

    private class ViewHolder {
        EditText edtValor, edtData;
        TextView txt_ok, txt_cancelar;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            atualiza = (AtualizaListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " deve ser implementado AtualizaListener");
        }

    }

    public interface AtualizaListener {
        void atualizar(String valor);

    }

    public void carregarDados() {


        if (MainActivity.ID_GLOBAL != 0) {
            Deposito deposito = repositorio.buscarPorId(MainActivity.ID_GLOBAL);
            viewHolder.edtValor.setText(String.valueOf(deposito.getValor()));
            viewHolder.edtData.setText(deposito.getDt_deposito());


        }
    }


}
