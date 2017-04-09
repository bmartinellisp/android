package com.project.hackathon.saude.supermae.helper;

import android.widget.EditText;

import com.project.hackathon.saude.supermae.CadastroConsultaActivity;
import com.project.hackathon.saude.supermae.CadastroMedicamentoActivity;
import com.project.hackathon.saude.supermae.R;
import com.project.hackathon.saude.supermae.model.Consulta;
import com.project.hackathon.saude.supermae.model.Medicamento;

import java.util.Map;

/**
 * Created by Matheus on 09/04/2017.
 */

public class FormularioMedicamento {

    private EditText campoData;
    private EditText campoHora;
    private EditText campoNome;

    private Medicamento medicamento;

    public EditText getCampoData() {
        return campoData;
    }

    public void setCampoData(EditText campoData) {
        this.campoData = campoData;
    }

    public EditText getCampoHora() {
        return campoHora;
    }

    public void setCampoHora(EditText campoHora) {
        this.campoHora = campoHora;
    }

    public EditText getCampoNome() {
        return campoNome;
    }

    public void setCampoNome(EditText campoNome) {
        this.campoNome = campoNome;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public FormularioMedicamento(CadastroMedicamentoActivity activity) {

        campoData = (EditText) activity.findViewById(R.id.ed_data);
        campoHora = (EditText) activity.findViewById(R.id.ed_hora);
        campoNome = (EditText) activity.findViewById(R.id.ed_nome_remedio);


        medicamento = new Medicamento();
    }
}

