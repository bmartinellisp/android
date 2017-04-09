package com.project.hackathon.saude.supermae;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.project.hackathon.saude.supermae.adapter.ConsultaCustomAdapter;
import com.project.hackathon.saude.supermae.handler.DatabaseHandlerConsulta;
import com.project.hackathon.saude.supermae.model.Consulta;

import java.util.ArrayList;

public class ConsultaActivity extends AppCompatActivity {

    DatabaseHandlerConsulta db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ConsultaActivity.this, CadastroConsultaActivity.class);
                startActivity(i);
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        db = new DatabaseHandlerConsulta(this);



        ListView listViewConsulta;
        listViewConsulta = (ListView) findViewById(R.id.listConsulta);

        ArrayList<Consulta> consulta = (ArrayList<Consulta>) db.getAllConsultas();

        ConsultaCustomAdapter rankingCustomAdapter;
        rankingCustomAdapter = new ConsultaCustomAdapter(consulta, this);

        listViewConsulta.setAdapter(rankingCustomAdapter);


    }
}
