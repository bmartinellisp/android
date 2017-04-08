package com.project.hackathon.saude.supermae.model;

/**
 * Created by Matheus on 08/04/2017.
 */

public class Ranking {

    int id;
    int posicao;
    String nome;
    int imgMae;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getImgMae() {
        return imgMae;
    }

    public void setImgMae(int imgMae) {
        this.imgMae = imgMae;
    }

    public Ranking() {
    }

    public Ranking(int id, int posicao, String nome, int imgMae) {
        this.id = id;
        this.posicao = posicao;
        this.nome = nome;
        this.imgMae = imgMae;
    }

}
