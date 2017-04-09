package com.project.hackathon.saude.supermae.helper;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.project.hackathon.saude.supermae.ConfiguracoesActivity;
import com.project.hackathon.saude.supermae.R;
import com.project.hackathon.saude.supermae.model.Informacao;

/**
 * Created by Matheus on 09/04/2017.
 */

public class FormularioInformacao {

    EditText qtde_cesarias;
    EditText semana_gestacao;
    ImageView posicao1;
    ImageView posicao2;
    ImageView posicao3;
    EditText qtde_filhos;
    EditText ed_codigo_posto;
    Button btn_cadastrar;

    private Informacao informacao;

    public EditText getQtde_cesarias() {
        return qtde_cesarias;
    }

    public void setQtde_cesarias(EditText qtde_cesarias) {
        this.qtde_cesarias = qtde_cesarias;
    }

    public EditText getSemana_gestacao() {
        return semana_gestacao;
    }

    public void setSemana_gestacao(EditText semana_gestacao) {
        this.semana_gestacao = semana_gestacao;
    }

    public ImageView getPosicao1() {
        return posicao1;
    }

    public void setPosicao1(ImageView posicao1) {
        this.posicao1 = posicao1;
    }

    public ImageView getPosicao2() {
        return posicao2;
    }

    public void setPosicao2(ImageView posicao2) {
        this.posicao2 = posicao2;
    }

    public ImageView getPosicao3() {
        return posicao3;
    }

    public void setPosicao3(ImageView posicao3) {
        this.posicao3 = posicao3;
    }

    public EditText getQtde_filhos() {
        return qtde_filhos;
    }

    public void setQtde_filhos(EditText qtde_filhos) {
        this.qtde_filhos = qtde_filhos;
    }

    public EditText getEd_codigo_posto() {
        return ed_codigo_posto;
    }

    public void setEd_codigo_posto(EditText ed_codigo_posto) {
        this.ed_codigo_posto = ed_codigo_posto;
    }

    public Button getBtn_cadastrar() {
        return btn_cadastrar;
    }

    public void setBtn_cadastrar(Button btn_cadastrar) {
        this.btn_cadastrar = btn_cadastrar;
    }

    public Informacao getInformacao() {
        return informacao;
    }

    public void setInformacao(Informacao informacao) {
        this.informacao = informacao;
    }

    public FormularioInformacao(ConfiguracoesActivity activity) {

        qtde_cesarias = (EditText) activity.findViewById(R.id.qtde_cesarias);
        semana_gestacao = (EditText) activity.findViewById(R.id.semana_gestacao);
        posicao1 = (ImageView) activity.findViewById(R.id.posicao1);
        posicao2 = (ImageView) activity.findViewById(R.id.posicao2);
        posicao3 = (ImageView) activity.findViewById(R.id.posicao3);
        qtde_filhos = (EditText) activity.findViewById(R.id.qtde_filhos);
        ed_codigo_posto = (EditText) activity.findViewById(R.id.ed_codigo_posto);
        btn_cadastrar = (Button) activity.findViewById(R.id.btn_cadastrar);

        informacao = new Informacao();
    }
}
