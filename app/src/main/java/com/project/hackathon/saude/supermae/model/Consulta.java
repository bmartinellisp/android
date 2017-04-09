package com.project.hackathon.saude.supermae.model;

/**
 * Created by Matheus on 08/04/2017.
 */

public class Consulta {

    private String data;
    private String nomeDoutor;
    private int codigoPosto;
    private String horario;
    private String logradouro;
    private String cidade;
    private String bairro;
    private String cep;
    private String estado;
    private String numero;
    private String uf;


    public Consulta(String data, String nomeDoutor, int codigoPosto, String horario, String logradouro, String cidade, String bairro, String cep, String estado, String numero, String uf) {
        this.data = data;
        this.nomeDoutor = nomeDoutor;
        this.codigoPosto = codigoPosto;
        this.horario = horario;
        this.logradouro = logradouro;
        this.cidade = cidade;
        this.bairro = bairro;
        this.cep = cep;
        this.estado = estado;
        this.numero = numero;
        this.uf = uf;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getNomeDoutor() {
        return nomeDoutor;
    }

    public void setNomeDoutor(String nomeDoutor) {
        this.nomeDoutor = nomeDoutor;
    }

    public int getCodigoPosto() {
        return codigoPosto;
    }

    public void setCodigoPosto(int codigoPosto) {
        this.codigoPosto = codigoPosto;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Consulta() {

    }


}
