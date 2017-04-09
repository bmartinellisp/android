package com.project.hackathon.saude.supermae.handler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.project.hackathon.saude.supermae.model.Medicamento;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matheus on 09/04/2017.
 */

public class DatabaseHandlerMedicamento extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "gerenciadorMedicamentos";

    private static final String TABELA_CONSULTA = "medicamentos";

    private static final String DATA = "data";
    private static final String HORA = "hora";
    private static final String NOME = "nome";

    public DatabaseHandlerMedicamento(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABELA_CONSULTA + "("
                + DATA + " TEXT,"
                + HORA + " TEXT,"
                + NOME + " TEXT" + ")";
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

    // Adding new medicamento
    public void addMedicamento(Medicamento medicamento) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(DATA , medicamento.getData());
        values.put(HORA , medicamento.getHora());
        values.put(NOME , medicamento.getNome());

        // Inserting Row
        db.insert(TABELA_CONSULTA, null, values);
        db.close(); // Closing database connection
    }


    // Getting All Medicamentos
    public List<Medicamento> getAllMedicamentos() {
        List<Medicamento> medicamentoList = new ArrayList<Medicamento>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABELA_CONSULTA;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Medicamento medicamento = new Medicamento();
                medicamento.setData(cursor.getString(0));
                medicamento.setHora(cursor.getString(0));
                medicamento.setNome(cursor.getString(0));

                // Adding medicamento to list
                medicamentoList.add(medicamento);
            } while (cursor.moveToNext());
        }

        // return medicamento list
        return medicamentoList;
    }


}
