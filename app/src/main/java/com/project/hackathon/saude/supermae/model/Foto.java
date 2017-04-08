package com.project.hackathon.saude.supermae.model;

/**
 * Created by Matheus on 08/04/2017.
 */

public class Foto {

    private String id;
    private String nome;
    private String data;
    private int imgPrincipal;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setDescricao(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getImgPrincipal() {
        return imgPrincipal;
    }

    public void setImgPrincipal(int imgPrincipal) {
        this.imgPrincipal = imgPrincipal;
    }

    public Foto() {
    }

    public Foto(String id, String descricao, String data, int imgPrincipal) {
        this.id = id;
        this.nome = descricao;
        this.data = data;
        this.imgPrincipal       = imgPrincipal;
    }
}
