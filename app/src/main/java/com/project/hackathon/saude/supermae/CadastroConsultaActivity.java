package com.project.hackathon.saude.supermae;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.project.hackathon.saude.supermae.handler.DatabaseHandler;
import com.project.hackathon.saude.supermae.helper.CarregarEnderecoTask;
import com.project.hackathon.saude.supermae.helper.DatePickerFragment;
import com.project.hackathon.saude.supermae.helper.FormularioConsulta;
import com.project.hackathon.saude.supermae.model.Consulta;

public class CadastroConsultaActivity extends AppCompatActivity {

    EditText ed_campo_horario;
    EditText ed_data;
    EditText ed_nome_doutor;
    EditText ed_codigo_posto;
    EditText ed_cep;
    EditText ed_logradouro;
    EditText ed_numero;
    EditText ed_cidade;
    EditText ed_bairro;
    EditText ed_estado;
    EditText ed_ufEditText;

    private Button btn_buscar_cep, btn_cadastrar;
    private FormularioConsulta helperFormularioConsulta;
    private DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_consulta);

        helperFormularioConsulta = new FormularioConsulta(this);

        ed_campo_horario = (EditText) findViewById(R.id.ed_campo_horario);
        ed_data = (EditText) findViewById(R.id.ed_data);
        ed_nome_doutor = (EditText) findViewById(R.id.ed_nome_doutor);
        ed_codigo_posto = (EditText) findViewById(R.id.ed_codigo_posto);
        ed_cep = (EditText) findViewById(R.id.ed_cep);
        ed_logradouro = (EditText) findViewById(R.id.ed_logradouro);
        ed_numero = (EditText) findViewById(R.id.ed_numero);
        ed_cidade = (EditText) findViewById(R.id.ed_cidade);
        ed_bairro = (EditText) findViewById(R.id.ed_bairro);
        ed_estado = (EditText) findViewById(R.id.ed_estado);
        ed_ufEditText = (EditText) findViewById(R.id.ed_uf);


        ed_data.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (hasFocus) {
                    DialogFragment newFragment = new DatePickerFragment(ed_data, helperFormularioConsulta.getCampoCep());
                    newFragment.show(getSupportFragmentManager(), "datePicker");
                }
            }
        });

        final EditText et_cep = (EditText) findViewById(R.id.ed_cep);
        btn_buscar_cep = (Button) findViewById(R.id.btn_buscar_cep);
        btn_buscar_cep.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               CarregarEnderecoTask task = new CarregarEnderecoTask(et_cep.getText().toString(), helperFormularioConsulta.getCampoCep(), helperFormularioConsulta.getCampoCidade(), helperFormularioConsulta.getCampoBairro(), helperFormularioConsulta.getCampoLogradouro(), helperFormularioConsulta.getCampoUF(), helperFormularioConsulta.getCampoNumero(), CadastroConsultaActivity.this);
               task.execute();
           }
        });


        db = new DatabaseHandler(this);

        Button btn_cadastrar = (Button) findViewById(R.id.btn_cadastrar);
        btn_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String tx_ed_campo_horario = ed_campo_horario.getText().toString();
                String tx_ed_data = ed_data.getText().toString();
                String tx_ed_nome_doutor = ed_nome_doutor.getText().toString();
                String tx_ed_codigo_posto = ed_codigo_posto.getText().toString();
                String tx_ed_logradouro = ed_logradouro.getText().toString();
                String tx_ed_cidade = ed_cidade.getText().toString();
                String tx_ed_bairro = ed_bairro.getText().toString();
                String tx_ed_cep = ed_cep.getText().toString();
                String tx_ed_estado = ed_estado.getText().toString();
                String tx_ed_numero = ed_numero.getText().toString();
                String tx_ed_ufEditText = ed_ufEditText.getText().toString();

                db.addConsulta(new Consulta(tx_ed_data, tx_ed_nome_doutor, Integer.parseInt(tx_ed_codigo_posto),tx_ed_campo_horario, tx_ed_logradouro,tx_ed_cidade,tx_ed_bairro,tx_ed_cep,tx_ed_estado,tx_ed_numero,tx_ed_ufEditText ));
                finish();
            }
        });


    }
}
