package com.robson.model;

import java.util.Objects;

public class Aluno {
    private String nome;

    public Aluno(String nome) { this.nome = nome;}

    @Override
    public String toString() {
        return "Aluno: " + nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aluno)) return false;
        Aluno aluno = (Aluno) o;
        return getNome().equals(aluno.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
