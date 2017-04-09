package com.project.hackathon.saude.supermae.handler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.project.hackathon.saude.supermae.model.Informacao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matheus on 09/04/2017.
 */

public class DatabaseHandlerInformacao extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "gerenciadorInformacaos";
    private static final String TABELA_CONSULTA = "informacaos";
    private static final String COD = "cod";
    private static final String QTDE_CESARIAS = "qtde_cesarias";
    private static final String NOME = "nome";
    private static final String SEMANA_GESTACAO = "semana_gestacao";
    private static final String POSICAO_FETO = "posicao_feto";
    private static final String QTDE_FILHOS = "qtde_filhos";
    private static final String CODIGO_POSTO = "codigo_posto";

    public DatabaseHandlerInformacao(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABELA_CONSULTA + "("
                + COD + " TEXT,"
                + NOME + " TEXT,"
                + QTDE_CESARIAS + " TEXT,"
                + SEMANA_GESTACAO + " TEXT,"
                + POSICAO_FETO + " TEXT,"
                + QTDE_FILHOS + " TEXT,"
                + CODIGO_POSTO + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_CONSULTA);

        // Create tables again
        onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    // Adding new informacao
    public void addInformacao(Informacao informacao) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COD, "" + informacao.getCodigo());
        values.put(NOME, "" + informacao.getNome());
        values.put(QTDE_CESARIAS, "" + informacao.getQtde_cesarias());
        values.put(SEMANA_GESTACAO, "" + informacao.getSemana_gestacao());
        values.put(POSICAO_FETO, "" + informacao.getPosicao_feto());
        values.put(QTDE_FILHOS, "" + informacao.getQtde_filhos());
        values.put(CODIGO_POSTO, "" + informacao.getCodigo_posto());

        // Inserting Row
        db.insert(TABELA_CONSULTA, null, values);
        db.close(); // Closing database connection
    }

    // Updating single contact
    public int updateInformacao(Informacao informacao) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NOME, informacao.getNome());
        values.put(QTDE_CESARIAS, informacao.getQtde_cesarias());
        values.put(SEMANA_GESTACAO, informacao.getSemana_gestacao());
        values.put(POSICAO_FETO, informacao.getPosicao_feto());
        values.put(QTDE_FILHOS, informacao.getQtde_filhos());
        values.put(CODIGO_POSTO, informacao.getCodigo_posto());

        // updating row
        return db.update(TABELA_CONSULTA, values, COD + " = ?",
                new String[]{String.valueOf(informacao.getCodigo())});
    }


    // Getting All Informacaos
    public List<Informacao> getAllInformacaos() {
        List<Informacao> informacaoList = new ArrayList<Informacao>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABELA_CONSULTA;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Informacao informacao = new Informacao();
                informacao.setCodigo(Integer.parseInt(cursor.getString(0)));
                informacao.setNome(cursor.getString(1));
                informacao.setQtde_cesarias(Integer.parseInt(cursor.getString(2)));
                informacao.setSemana_gestacao(Integer.parseInt(cursor.getString(3)));
                informacao.setPosicao_feto(Integer.parseInt(cursor.getString(4)));
                informacao.setQtde_filhos(Integer.parseInt(cursor.getString(5)));
                informacao.setCodigo_posto(Integer.parseInt(cursor.getString(6)));

                // Adding informacao to list
                informacaoList.add(informacao);
            } while (cursor.moveToNext());
        }

        // return informacao list
        return informacaoList;
    }

}
