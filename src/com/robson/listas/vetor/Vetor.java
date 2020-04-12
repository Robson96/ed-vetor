package com.robson.listas.vetor;

import java.util.function.Supplier;

public class Vetor<T> {

    private T[] alunos = (T[]) new Object[100];

    private int posicaoDeAlunos = 0;


    public void adicionar(T t) {
        garantaEspaco();
        alunos[posicaoDeAlunos] = t;
        posicaoDeAlunos++;
    }

    private void garantaEspaco() {
        if (posicaoDeAlunos == alunos.length) {
            T[] novosAlunos = (T[]) new Object[alunos.length * 2];
            for (int i = 0; i < alunos.length; i++) {
                novosAlunos[i] = alunos[i];
            }
            alunos =  novosAlunos;
        }
    }

    public void adicionar(int posicao, T t) {
        garantaEspaco();
        if (!posicaoValida(posicao))
            throw new IllegalArgumentException("Posicao Invalida");

        for (int i = posicaoDeAlunos - 1; i >= posicao; i--) {
            alunos[i + 1] = alunos[i];
        }
        alunos[posicao] = t;
        posicaoDeAlunos++;

    }

    public T pega(int posicao) {
        if (!posicaoValida(posicao))
            throw new IllegalArgumentException("Posiçao Invalida");
        return alunos[posicao];
    }


    /*
         0   1   2   3   4
        [1, 2,  3,  4,  5]
                <================
         0  1   2   3
        [1, 2,  4,  5]
     */
    public void remove(int posicao) {
        if (!posicaoValida(posicao))
            throw new IllegalArgumentException();

        for (int i = posicao; i <= posicaoDeAlunos - 1; i++) {
            alunos[i] = alunos[i + 1];
        }
        posicaoDeAlunos--;
    }

    public boolean contem(T t) {
        for (int i = 0; i < posicaoDeAlunos; i++) {
            if (t.equals(alunos[i]))
                return true;
        }
        return false;
    }

    public int tamanho() {
        return posicaoDeAlunos;
    }

    private boolean posicaoValida(int posicao) {
        return posicao >= 0 && posicao <= posicaoDeAlunos;
    }

    public String toString() {
        if (posicaoDeAlunos == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < posicaoDeAlunos - 1; i++) {
            sb.append(alunos[i]);
            sb.append(", ");
        }
        sb.append(alunos[posicaoDeAlunos - 1]);
        sb.append("]");
        return sb.toString();
    }


}
