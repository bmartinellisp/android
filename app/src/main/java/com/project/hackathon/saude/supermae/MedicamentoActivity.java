package com.project.hackathon.saude.supermae;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.project.hackathon.saude.supermae.adapter.MedicamentoCustomAdapter;
import com.project.hackathon.saude.supermae.handler.DatabaseHandlerMedicamento;
import com.project.hackathon.saude.supermae.model.Medicamento;

import java.util.ArrayList;

public class MedicamentoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicamento);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MedicamentoActivity.this, CadastroMedicamentoActivity.class);
                startActivity(i);
            }
        });
    }

    DatabaseHandlerMedicamento db;

    @Override
    protected void onResume() {
        super.onResume();
        db = new DatabaseHandlerMedicamento(this);

        ListView listViewMedicamento;
        listViewMedicamento = (ListView) findViewById(R.id.listMedicamento);

        ArrayList<Medicamento> consulta = (ArrayList<Medicamento>) db.getAllMedicamentos();

        MedicamentoCustomAdapter rankingCustomAdapter;
        rankingCustomAdapter = new MedicamentoCustomAdapter(consulta, this);

        listViewMedicamento.setAdapter(rankingCustomAdapter);
    }

}
