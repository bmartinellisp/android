package com.project.hackathon.saude.supermae.model;

/**
 * Created by Matheus on 09/04/2017.
 */

public class Informacao {

    int codigo;
    String nome;
    int qtde_cesarias;
    int semana_gestacao;
    int posicao_feto;
    int qtde_filhos;
    int codigo_posto;

    public Informacao(int codigo, String nome, int qtde_cesarias, int semana_gestacao, int posicao_feto, int qtde_filhos, int codigo_posto) {
        this.codigo = codigo;
        this.nome = nome;
        this.qtde_cesarias = qtde_cesarias;
        this.semana_gestacao = semana_gestacao;
        this.posicao_feto = posicao_feto;
        this.qtde_filhos = qtde_filhos;

        this.codigo_posto  = codigo_posto;
    }

    public Informacao(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getQtde_cesarias() {
        return qtde_cesarias;
    }

    public void setQtde_cesarias(int qtde_cesarias) {
        this.qtde_cesarias = qtde_cesarias;
    }

    public int getSemana_gestacao() {
        return semana_gestacao;
    }

    public void setSemana_gestacao(int semana_gestacao) {
        this.semana_gestacao = semana_gestacao;
    }

    public int getPosicao_feto() {
        return posicao_feto;
    }

    public void setPosicao_feto(int posicao_feto) {
        this.posicao_feto = posicao_feto;
    }

    public int getQtde_filhos() {
        return qtde_filhos;
    }

    public void setQtde_filhos(int qtde_filhos) {
        this.qtde_filhos = qtde_filhos;
    }

    public int getCodigo_posto() {
        return codigo_posto;
    }

    public void setCodigo_posto(int codigo_posto) {
        this.codigo_posto = codigo_posto;
    }
}
