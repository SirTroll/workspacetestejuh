package com.sirtprojects.testejuh.Models;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import com.sirtprojects.testejuh.Sqlite.DBHelper;

import java.util.ArrayList;

public class Exercise {

    private int codigo;
    private String nome;
    private String categoria;
    private String nivel;
    private String descricao;
    private boolean excluir;
    private Context context;

    public Exercise(Context context){
        this.context = context;
        codigo = -1;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isExcluir() {
        return excluir;
    }

    public void setExcluir(boolean excluir) {
        this.excluir = excluir;
    }

    public ArrayList<Exercise> getExercises() {
        DBHelper dbHelper = null;
        SQLiteDatabase sqLiteDatabase = null;
        Cursor cursor = null;
        ArrayList<Exercise> exercises = new ArrayList<>();
        try{
            dbHelper = new DBHelper(context);
            sqLiteDatabase = dbHelper.getReadableDatabase();

            String table = "exercicio";
            String[] tableColumns = new String[] {"categoria"};
            String whereClause = "categoria = ?";
            String[] selectionArgs = {"cone"};

            cursor = sqLiteDatabase.query("exercicio", null, null,
                    null,null,null,null);
            while(cursor.moveToNext()){
                Exercise exercise = new Exercise(context);
                exercise.codigo = cursor.getInt(cursor.getColumnIndex("codigo"));
                exercise.nome = cursor.getString(cursor.getColumnIndex("nome"));
                exercise.categoria = cursor.getString(cursor.getColumnIndex("categoria"));
                exercise.nivel = cursor.getString(cursor.getColumnIndex("nivel"));
                exercise.descricao = cursor.getString(cursor.getColumnIndex("descricao"));
                exercises.add(exercise);
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

        return exercises;
    }

    public ArrayList<Exercise> getExercisesByCategory(String categoria){
        DBHelper dbHelper = null;
        SQLiteDatabase sqLiteDatabase = null;
        Cursor cursor = null;
        ArrayList<Exercise> exercises = new ArrayList<>();
        try{
            dbHelper = new DBHelper(context);
            sqLiteDatabase = dbHelper.getReadableDatabase();

            String table = "exercicio";
            String[] tableColumns = new String[] {"codigo","nome","categoria","nivel","descricao"};
            String whereClause = "categoria = ?";
            String[] selectionArgs = {categoria};

            cursor = sqLiteDatabase.query(table, tableColumns, whereClause,
                    selectionArgs,null,null,null);
            while(cursor.moveToNext()){
                Exercise exercise = new Exercise(context);
                exercise.codigo = cursor.getInt(cursor.getColumnIndex("codigo"));
                exercise.nome = cursor.getString(cursor.getColumnIndex("nome"));
                exercise.categoria = cursor.getString(cursor.getColumnIndex("categoria"));
                exercise.nivel = cursor.getString(cursor.getColumnIndex("nivel"));
                exercise.descricao = cursor.getString(cursor.getColumnIndex("descricao"));
                exercises.add(exercise);
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

        return exercises;
    }

    public boolean save(){
        DBHelper dbHelper = null;
        SQLiteDatabase sqLiteDatabase = null;

        try{
            dbHelper = new DBHelper(context);
            sqLiteDatabase = dbHelper.getWritableDatabase();
            String sql = "";
            if (codigo == -1){
                sql = "INSERT INTO exercicio (nome,categoria,nivel,descricao) VALUES (?,?,?,?)";
            }else{
                sql = "UPDATE exercicio SET nome = ?, categoria = ?, nivel = ?, descricao = ? WHERE codigo = ?";
            }
            sqLiteDatabase.beginTransaction();

            SQLiteStatement sqLiteStatement = sqLiteDatabase.compileStatement(sql);
            sqLiteStatement.clearBindings();

            sqLiteStatement.bindString(1, nome);
            sqLiteStatement.bindString(2, categoria);
            sqLiteStatement.bindString(3, nivel);
            sqLiteStatement.bindString(4, descricao);

            if (codigo != -1)  sqLiteStatement.bindString(5, String.valueOf(codigo));

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

            sqLiteDatabase.delete("exercicio","codigo = ?",new String[]{String.valueOf(codigo)});

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

    public void exercicioByCode(int codigo){
        DBHelper dbHelper = null;
        SQLiteDatabase sqLiteDatabase = null;
        Cursor cursor = null;
        try{
            dbHelper = new DBHelper(context);
            sqLiteDatabase = dbHelper.getReadableDatabase();
            cursor = sqLiteDatabase.query("exercise",null,"codigo = ?",
                    new String[]{String.valueOf(codigo)},null,null,null);
            excluir = true;
            while(cursor.moveToNext()){
                this.codigo = cursor.getInt(cursor.getColumnIndex("codigo"));
                nome = cursor.getString(cursor.getColumnIndex("nome"));
                categoria = cursor.getString(cursor.getColumnIndex("categoria"));
                nivel = cursor.getString(cursor.getColumnIndex("nivel"));
                descricao = cursor.getString(cursor.getColumnIndex("descricao"));
                excluir = false;
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
    }

    public void exercicioByCategory(){
        DBHelper dbHelper = null;
        SQLiteDatabase sqLiteDatabase = null;
        Cursor cursor = null;
        try{
            dbHelper = new DBHelper(context);
            sqLiteDatabase = dbHelper.getReadableDatabase();
            cursor = sqLiteDatabase.query("exercicio", null, null,
                    null,null,null,null);
            excluir = true;
            while(cursor.moveToNext()){
                this.codigo = cursor.getInt(cursor.getColumnIndex("codigo"));
                nome = cursor.getString(cursor.getColumnIndex("nome"));
                categoria = cursor.getString(cursor.getColumnIndex("categoria"));
                nivel = cursor.getString(cursor.getColumnIndex("nivel"));
                descricao = cursor.getString(cursor.getColumnIndex("descricao"));
                excluir = false;
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
    }
}
