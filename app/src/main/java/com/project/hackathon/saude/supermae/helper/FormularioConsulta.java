package com.project.hackathon.saude.supermae.helper;

import android.widget.EditText;

import com.project.hackathon.saude.supermae.CadastroConsultaActivity;
import com.project.hackathon.saude.supermae.R;
import com.project.hackathon.saude.supermae.model.Consulta;

import java.util.Date;
import java.util.Map;

/**
 * Created by Matheus on 08/04/2017.
 */

public class FormularioConsulta {

    private EditText campoData;
    private EditText campoNomeDoutor;
    private EditText campoCodigoPosto;
    private EditText campoHorario;
    private EditText campoLogradouro;
    private EditText campoCidade;
    private EditText campoBairro;
    private EditText campoCep;
    private EditText campoEstado;
    private EditText campoNumero;
    private EditText campoUF;

    private Consulta consulta;

    //Contrutor Getters E Setters

    public EditText getCampoLogradouro() {
        return campoLogradouro;
    }

    public void setCampoLogradouro(EditText campoLogradouro) {
        this.campoLogradouro = campoLogradouro;
    }

    public EditText getCampoCidade() {
        return campoCidade;
    }

    public void setCampoCidade(EditText campoCidade) {
        this.campoCidade = campoCidade;
    }

    public EditText getCampoBairro() {
        return campoBairro;
    }

    public void setCampoBairro(EditText campoBairro) {
        this.campoBairro = campoBairro;
    }

    public EditText getCampoCep() {
        return campoCep;
    }

    public void setCampoCep(EditText campoCep) {
        this.campoCep = campoCep;
    }

    public EditText getCampoEstado() {
        return campoEstado;
    }

    public void setCampoEstado(EditText campoEstado) {
        this.campoEstado = campoEstado;
    }

    public EditText getCampoNumero() {
        return campoNumero;
    }

    public void setCampoNumero(EditText campoNumero) {
        this.campoNumero = campoNumero;
    }


    public EditText getCampoData() {
        return campoData;
    }

    public void setCampoData(EditText campoData) {
        this.campoData = campoData;
    }

    public EditText getCampoNomeDoutor() {
        return campoNomeDoutor;
    }

    public void setCampoNomeDoutor(EditText campoNomeDoutor) {
        this.campoNomeDoutor = campoNomeDoutor;
    }

    public EditText getCampoCodigoPosto() {
        return campoCodigoPosto;
    }

    public void setCampoCodigoPosto(EditText campoCodigoPosto) {
        this.campoCodigoPosto = campoCodigoPosto;
    }

    public EditText getCampoHorario() {
        return campoHorario;
    }

    public void setCampoHorario(EditText campoHorario) {
        this.campoHorario = campoHorario;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public EditText getCampoUF() {
        return campoUF;
    }

    public void setCampoUF(EditText campoUF) {
        this.campoUF = campoUF;
    }

    public FormularioConsulta(CadastroConsultaActivity activity) {

        campoData = (EditText) activity.findViewById(R.id.ed_data);
        campoNomeDoutor = (EditText) activity.findViewById(R.id.ed_nome_doutor);
        campoCodigoPosto = (EditText) activity.findViewById(R.id.ed_codigo_posto);
        campoHorario = (EditText) activity.findViewById(R.id.ed_campo_horario);
        campoLogradouro = (EditText) activity.findViewById(R.id.ed_logradouro);
        campoCidade = (EditText) activity.findViewById(R.id.ed_cidade);
        campoBairro = (EditText) activity.findViewById(R.id.ed_bairro);
        campoCep = (EditText) activity.findViewById(R.id.ed_cep);
        campoEstado = (EditText) activity.findViewById(R.id.ed_estado);
        campoNumero = (EditText) activity.findViewById(R.id.ed_numero);
        campoUF = (EditText) activity.findViewById(R.id.ed_uf);

        consulta = new Consulta();
    }


    public Consulta getMembroFromData() {

        this.consulta.setData(campoData.getText().toString());
        this.consulta.setNomeDoutor(campoNomeDoutor.getText().toString());
        this.consulta.setCodigoPosto(Integer.parseInt(campoCodigoPosto.getText().toString()));
        this.consulta.setHorario(campoHorario.getText().toString());
        this.consulta.setLogradouro(campoLogradouro.getText().toString());
        this.consulta.setCidade(campoCidade.getText().toString());
        this.consulta.setBairro(campoBairro.getText().toString());
        this.consulta.setCep(campoCep.getText().toString());
        this.consulta.setEstado(campoEstado.getText().toString());
        this.consulta.setNumero(campoNumero.getText().toString());
        this.consulta.setUf(campoUF.getText().toString());
        return this.consulta;
    }

    public void preencherDadosEndereco(Map<String, String> dados) {
        this.campoCep.setText(dados.get("cep").toString());
        this.campoCidade.setText(dados.get("cidade").toString());
        this.campoBairro.setText(dados.get("bairro").toString());
        this.campoLogradouro.setText(dados.get("logradouro").toString());
        this.campoEstado.setText(dados.get("estado").toString());
        this.campoUF.setText(dados.get("uf").toString());
    }
}
