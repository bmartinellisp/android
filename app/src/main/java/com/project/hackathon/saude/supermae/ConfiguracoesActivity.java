package com.project.hackathon.saude.supermae;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.project.hackathon.saude.supermae.handler.DatabaseHandlerInformacao;
import com.project.hackathon.saude.supermae.model.Informacao;

import java.util.List;

/**
 * Created by Matheus on 08/04/2017.
 */

public class ConfiguracoesActivity extends AppCompatActivity {

    RadioButton radio_sim_primeira_gestacao;
    RadioButton radio_nao_primeira_gestacao;

    EditText qtde_cesarias;
    EditText nome;
    EditText semana_gestacao;
    ImageView posicao1;
    ImageView posicao2;
    ImageView posicao3;
    EditText qtde_filhos;
    EditText ed_codigo_posto;
    Button btn_cadastrar;

    int posicao;
    boolean alt = false;
    private DatabaseHandlerInformacao db;
    List<Informacao> informacoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracoes);

        db = new DatabaseHandlerInformacao(this);

        try {
            Log.d("Reading: ", "Reading all contacts..");
            informacoes = db.getAllInformacaos();
            if (informacoes.size() > 0) {
                alt = true;
            }
        } catch (Exception e) {

        }

        posicao = 0;


        nome = (EditText) findViewById(R.id.ed_nome);
        qtde_cesarias = (EditText) findViewById(R.id.qtde_cesarias);
        semana_gestacao = (EditText) findViewById(R.id.semana_gestacao);
        posicao1 = (ImageView) findViewById(R.id.posicao1);
        posicao2 = (ImageView) findViewById(R.id.posicao2);
        posicao3 = (ImageView) findViewById(R.id.posicao3);
        qtde_filhos = (EditText) findViewById(R.id.qtde_filhos);
        ed_codigo_posto = (EditText) findViewById(R.id.ed_codigo_posto);
        btn_cadastrar = (Button) findViewById(R.id.btn_cadastrar);

        if (alt == true) {

            nome.setText(informacoes.get(0).getNome());
            qtde_cesarias.setText("" + informacoes.get(0).getQtde_cesarias());
            semana_gestacao.setText("" + informacoes.get(0).getSemana_gestacao());

            if (informacoes.get(0).getPosicao_feto() == 1) {
                posicao = 1;
                posicao1.setImageResource(R.drawable.posicao1selecionada);
            } else if (informacoes.get(0).getPosicao_feto() == 2) {
                posicao = 2;
                posicao2.setImageResource(R.drawable.posicao2selecionada);
            } else if (informacoes.get(0).getPosicao_feto() == 3) {
                posicao = 3;
                posicao3.setImageResource(R.drawable.posicao3selecionada);
            }

            qtde_filhos.setText("" + informacoes.get(0).getQtde_filhos());
            ed_codigo_posto.setText("" + informacoes.get(0).getCodigo_posto());
        }

        posicao1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                posicao1.setImageResource(R.drawable.posicao1selecionada);
                posicao2.setImageResource(R.drawable.posicao2);
                posicao3.setImageResource(R.drawable.posicao3);
                posicao = 1;
            }
        });

        posicao2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                posicao2.setImageResource(R.drawable.posicao2selecionada);
                posicao1.setImageResource(R.drawable.posicao1);
                posicao3.setImageResource(R.drawable.posicao3);
                posicao = 2;
            }
        });

        posicao3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                posicao = 3;
                posicao3.setImageResource(R.drawable.posicao3selecionada);
                posicao1.setImageResource(R.drawable.posicao1);
                posicao2.setImageResource(R.drawable.posicao2);
            }
        });


        btn_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tx_codigo = 1;
                String tx_nome = nome.getText().toString();
                int tx_qtde_cesarias = Integer.parseInt(qtde_cesarias.getText().toString());
                int tx_semana_gestacao = Integer.parseInt(semana_gestacao.getText().toString());
                int tx_posicao_feto = posicao;
                int tx_qtde_filhos = Integer.parseInt(qtde_filhos.getText().toString());
                int tx_codigo_posto = Integer.parseInt(ed_codigo_posto.getText().toString());

                if (alt == true) {
                    db.updateInformacao(new Informacao(tx_codigo, tx_nome, tx_qtde_cesarias, tx_semana_gestacao, tx_posicao_feto, tx_qtde_filhos, tx_codigo_posto));
                } else {
                    db.addInformacao(new Informacao(tx_codigo, tx_nome, tx_qtde_cesarias, tx_semana_gestacao, tx_posicao_feto, tx_qtde_filhos, tx_codigo_posto));
                }
                finish();
            }
        });
    }

}

