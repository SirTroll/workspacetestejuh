package com.sirtprojects.testejuh.Models;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import com.sirtprojects.testejuh.Sqlite.DBHelper;

import java.util.ArrayList;

/**
 * Criado por Felipe Campos on 24/11/2018.
 */
public class Treino{

    private int codigo_treino;
    private String nome_treino;
    private String exercicios_treino;
    private Context context;
    private boolean excluir;

    public Treino(Context context) {
        this.context = context;
        codigo_treino = -1;
    }

    public int getCodigo_treino() {
        return codigo_treino;
    }

    public void setCodigo_treino(int codigo_treino) {
        this.codigo_treino = codigo_treino;
    }

    public String getNome_treino() {
        return nome_treino;
    }

    public void setNome_treino(String nome_treino) {
        this.nome_treino = nome_treino;
    }

    public String getExercicios_treino() {
        return exercicios_treino;
    }

    public void setExercicios_treino(String exercicios_treino) {
        this.exercicios_treino = exercicios_treino;
    }

    public boolean isExcluir(){
        return excluir;
    }

    public ArrayList<Treino> getExercises() {
        DBHelper dbHelper = null;
        SQLiteDatabase sqLiteDatabase = null;
        Cursor cursor = null;
        ArrayList<Treino> treinos_list = new ArrayList<>();
        try{
            dbHelper = new DBHelper(context);
            sqLiteDatabase = dbHelper.getReadableDatabase();

            String table = "treino";
            //String[] tableColumns = new String[] {"categoria"};
            //String whereClause = "categoria = ?";
            //String[] selectionArgs = {"cone"};

            cursor = sqLiteDatabase.query(table, null, null,
                    null,null,null,null);
            while(cursor.moveToNext()){
                Treino treinos = new Treino(context);
                treinos.codigo_treino = cursor.getInt(cursor.getColumnIndex("codigo"));
                treinos.nome_treino = cursor.getString(cursor.getColumnIndex("nome"));
                treinos.exercicios_treino = cursor.getString(cursor.getColumnIndex("exercicios"));
                treinos_list.add(treinos);
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if ((cursor != null) && (!cursor.isClosed()))
                cursor.close();
            if (sqLiteDatabase != null)
                sqLiteDatabase.close();
            if (dbHelper != null)
                dbHelper.close();
        }

        return treinos_list;
    }

    public boolean save(){
        DBHelper dbHelper = null;
        SQLiteDatabase sqLiteDatabase = null;

        try{
            dbHelper = new DBHelper(context);
            sqLiteDatabase = dbHelper.getWritableDatabase();
            String sql = "";
            if (codigo_treino == -1){
                sql = "INSERT INTO treino (nome,exercicios) VALUES (?,?)";
            }else{
                sql = "UPDATE treino SET nome = ?, exercicios = ?";
            }
            sqLiteDatabase.beginTransaction();

            SQLiteStatement sqLiteStatement = sqLiteDatabase.compileStatement(sql);
            sqLiteStatement.clearBindings();

            sqLiteStatement.bindString(1, nome_treino);
            sqLiteStatement.bindString(2, exercicios_treino);

            if (codigo_treino != -1)  sqLiteStatement.bindString(5, String.valueOf(codigo_treino));

            sqLiteStatement.executeInsert();

            sqLiteDatabase.setTransactionSuccessful();
            sqLiteDatabase.endTransaction();
            return true;

        }catch(Exception e){
            e.printStackTrace();
            assert sqLiteDatabase != null;
            sqLiteDatabase.endTransaction();
            return false;
        }finally {
            if (sqLiteDatabase != null)
                sqLiteDatabase.close();
            if (dbHelper != null)
                dbHelper.close();
        }
    }

    public boolean delete(){
        DBHelper dbHelper = null;
        SQLiteDatabase sqLiteDatabase = null;

        try{
            dbHelper = new DBHelper(context);
            sqLiteDatabase = dbHelper.getWritableDatabase();
            sqLiteDatabase.beginTransaction();

            sqLiteDatabase.delete("treino","codigo = ?",new String[]{String.valueOf(codigo_treino)});

            excluir = true;

            sqLiteDatabase.setTransactionSuccessful();
            sqLiteDatabase.endTransaction();
            return true;

        }catch(Exception e){
            e.printStackTrace();
            sqLiteDatabase.endTransaction();
            return false;
        }finally {
            if (sqLiteDatabase != null)
                sqLiteDatabase.close();
            if (dbHelper != null)
                dbHelper.close();
        }
    }

}
