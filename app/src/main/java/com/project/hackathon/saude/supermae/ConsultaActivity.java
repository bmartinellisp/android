package com.project.hackathon.saude.supermae;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.project.hackathon.saude.supermae.adapter.ConsultaCustomAdapter;
import com.project.hackathon.saude.supermae.handler.DatabaseHandler;
import com.project.hackathon.saude.supermae.helper.DatePickerFragment;
import com.project.hackathon.saude.supermae.model.Consulta;
import com.project.hackathon.saude.supermae.model.Consulta;

import java.util.ArrayList;
import java.util.List;

public class ConsultaActivity extends AppCompatActivity {

    DatabaseHandler db;
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
        db = new DatabaseHandler(this);



        ListView listViewConsulta;
        listViewConsulta = (ListView) findViewById(R.id.listConsulta);

        ArrayList<Consulta> consulta = (ArrayList<Consulta>) db.getAllConsultas();

        ConsultaCustomAdapter rankingCustomAdapter;
        rankingCustomAdapter = new ConsultaCustomAdapter(consulta, this);

        listViewConsulta.setAdapter(rankingCustomAdapter);

        for (Consulta cn : consulta) {
            String log = "Código Posto: " + cn.getCodigoPosto();
            // Writing Contacts to log
            Log.d("Name: ", log);

        }
    }
}
