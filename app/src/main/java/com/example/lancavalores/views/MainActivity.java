package com.example.lancavalores.views;

import android.content.Intent;
import android.os.Bundle;

import com.example.lancavalores.R;
import com.example.lancavalores.adapter.Adapter;
import com.example.lancavalores.banco.CreateDatabase;
import com.example.lancavalores.banco.MyApp;
import com.example.lancavalores.entidade.Deposito;
import com.example.lancavalores.listener.DepositoInterface;
import com.example.lancavalores.repositorio.DepositoRepositorio;
import com.example.lancavalores.viewHolder.DepositoViewHolder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CustomDialog.AtualizaListener {

    private ViewHoler viewHoler = new ViewHoler();
    public DepositoInterface depositoInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().hide();
        CreateDatabase c = new CreateDatabase();
        c.criar();


        viewHoler.recyclerView = findViewById(R.id.deposito_recycler);
        viewHoler.edtData = findViewById(R.id.data_valor_id);

        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                onStateNotSaved();
                chamarInputDilog();


            }
        });

        depositoInterface = new DepositoInterface() {
            @Override
            public void onListClick(int id) {
                if (DepositoViewHolder.point == 1) {
                    chamarInputDilog();
                }
            }

            @Override
            public void onDeleteClick(int id) {

            }
        };


    }


    public void carregarDeposito() {
        List<Deposito> depositos = new ArrayList<>();

        DepositoRepositorio repositorio = new DepositoRepositorio();

        depositos.addAll(repositorio.listarDeposito());

        Adapter adapter = new Adapter(depositos, depositoInterface);

        viewHoler.recyclerView.setAdapter(adapter);
        viewHoler.recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void atualizar(String valor) {
        onResume();
    }


    public class ViewHoler {
        RecyclerView recyclerView;
        EditText edtData;
    }

    @Override
    protected void onResume() {
        super.onResume();

        carregarDeposito();
    }

    private void chamarInputDilog() {
        CustomDialog dialog = new CustomDialog();
        dialog.show(getSupportFragmentManager(), "Dialog");
    }


}
