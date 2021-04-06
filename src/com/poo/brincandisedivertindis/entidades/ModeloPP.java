package com.poo.brincandisedivertindis.entidades;

public class ModeloPP extends MarcaPP{
    private String codigo;
    private String nome;

    @Override
    public String getCodigo() {
        return codigo;
    }

    @Override
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }
}
