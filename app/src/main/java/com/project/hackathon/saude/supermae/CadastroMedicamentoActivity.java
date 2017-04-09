package com.project.hackathon.saude.supermae;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.project.hackathon.saude.supermae.handler.DatabaseHandlerConsulta;
import com.project.hackathon.saude.supermae.handler.DatabaseHandlerMedicamento;
import com.project.hackathon.saude.supermae.helper.DatePickerFragment;
import com.project.hackathon.saude.supermae.helper.FormularioConsulta;
import com.project.hackathon.saude.supermae.helper.FormularioMedicamento;
import com.project.hackathon.saude.supermae.model.Consulta;
import com.project.hackathon.saude.supermae.model.Medicamento;

/**
 * Created by Matheus on 09/04/2017.
 */

public class CadastroMedicamentoActivity extends AppCompatActivity {


    EditText ed_data, ed_hora, ed_nome;
    private FormularioMedicamento helperFormularioMedicamento;
    private DatabaseHandlerMedicamento db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_medicamento);

        helperFormularioMedicamento = new FormularioMedicamento(this);

        ed_data = (EditText) findViewById(R.id.ed_data);
        ed_nome = (EditText) findViewById(R.id.ed_nome_remedio);
        ed_hora = (EditText) findViewById(R.id.ed_hora);

        ed_data.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (hasFocus) {
                    DialogFragment newFragment = new DatePickerFragment(ed_data, helperFormularioMedicamento.getCampoHora());
                    newFragment.show(getSupportFragmentManager(), "datePicker");
                }
            }
        });

        db = new DatabaseHandlerMedicamento(this);

        Button btn_cadastrar = (Button) findViewById(R.id.btn_cadastrar);
        btn_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String tx_ed_data = ed_data.getText().toString();
                String tx_ed_hora = ed_hora.getText().toString();
                String tx_ed_nome = ed_nome.getText().toString();


                db.addMedicamento(new Medicamento(tx_ed_data, tx_ed_hora, tx_ed_nome));
                finish();
            }
        });

    }
}
