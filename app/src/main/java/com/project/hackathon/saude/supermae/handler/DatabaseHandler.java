package com.project.hackathon.saude.supermae.handler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.project.hackathon.saude.supermae.model.Consulta;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matheus on 08/04/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "gerenciadorConsultas";

    private static final String TABELA_CONSULTA = "consultas";

    private static final String DATA = "data";
    private static final String NOME_DOUTOR = "nomeDoutor";
    private static final String CODIGO_POSTO = "codigoPosto";
    private static final String HORARIO = "horario";
    private static final String CEP = "cep";
    private static final String LOGRADOURO = "logradouro";
    private static final String CIDADE = "cidade";
    private static final String BAIRRO = "bairro";
    private static final String ESTADO = "estado";
    private static final String NUMERO = "numero";
    private static final String UF = "uf";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABELA_CONSULTA + "("
                + DATA + " TEXT,"
                + NOME_DOUTOR + " TEXT,"
                + CODIGO_POSTO + " TEXT,"
                + HORARIO + " TEXT,"
                + CEP + " TEXT,"
                + LOGRADOURO + " TEXT,"
                + CIDADE + " TEXT,"
                + BAIRRO + " TEXT,"
                + ESTADO + " TEXT,"
                + NUMERO + " TEXT,"
                + UF + " TEXT" + ")";
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

    // Adding new consulta
    public void addConsulta(Consulta consulta) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(DATA , consulta.getData());
        values.put(NOME_DOUTOR , consulta.getNomeDoutor());
        values.put(CODIGO_POSTO , consulta.getCodigoPosto());
        values.put(HORARIO , consulta.getHorario());
        values.put(CEP , consulta.getLogradouro());
        values.put(LOGRADOURO , consulta.getCidade());
        values.put(CIDADE , consulta.getBairro());
        values.put(BAIRRO , consulta.getCep());
        values.put(ESTADO , consulta.getEstado());
        values.put(NUMERO , consulta.getNumero());
        values.put(UF , consulta.getUf());

        // Inserting Row
        db.insert(TABELA_CONSULTA, null, values);
        db.close(); // Closing database connection
    }


    // Getting All Consultas
    public List<Consulta> getAllConsultas() {
        List<Consulta> consultaList = new ArrayList<Consulta>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABELA_CONSULTA;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Consulta consulta = new Consulta();
                consulta.setData(cursor.getString(0));
                consulta.setNomeDoutor(cursor.getString(1));
                consulta.setCodigoPosto(Integer.parseInt(cursor.getString(2)));
                consulta.setHorario(cursor.getString(3));
                consulta.setLogradouro(cursor.getString(4));
                consulta.setCidade(cursor.getString(5));
                consulta.setBairro(cursor.getString(6));
                consulta.setCep(cursor.getString(7));
                consulta.setEstado(cursor.getString(8));

                // Adding consulta to list
                consultaList.add(consulta);
            } while (cursor.moveToNext());
        }

        // return consulta list
        return consultaList;
    }


}