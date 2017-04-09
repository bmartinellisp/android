package com.project.hackathon.saude.supermae.model;

/**
 * Created by Matheus on 09/04/2017.
 */

public class Medicamento {

    private String data;
    private String hora;
    private String nome;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Medicamento(){

    }

    public Medicamento(String data, String hora, String nome){
        this.data = data;
        this.nome = nome;
        this.hora = hora;
    }
}
