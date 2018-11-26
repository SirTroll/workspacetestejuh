package com.sirtprojects.testejuh.Models;

/**
 * Criado por Felipe Campos on 26/11/2018.
 */
public class ExercicioLista {

    private String nome;
    private String nivel;
    private String categoria;
    private String descricao;

    public ExercicioLista(String nome, String nivel, String categoria, String descricao){
        super();
        this.nome = nome;
        this.nivel = nivel;
        this.categoria = categoria;
        this.descricao = descricao;
    }

    public String getName() {
        return nome;
    }

    public void setName(String name) {
        this.nome = name;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return nome;
    }
}
