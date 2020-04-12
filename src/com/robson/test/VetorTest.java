package com.robson.test;

import com.robson.listas.vetor.Vetor;
import com.robson.model.Aluno;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class VetorTest {

    Vetor lista;

    @BeforeAll
    void setup() {
        lista = new Vetor();
    }

    @Test
    @Order(2)
    void adicionar() {
        int size = lista.tamanho();
        lista.adicionar(new Aluno("Robson"));
        lista.adicionar(new Aluno("Z"));
        assertEquals(size + 2, lista.tamanho());
    }

    @Test
    @Order(8)
    void dicionarPosicao() {
        int size = lista.tamanho();
        lista.adicionar(2, new Aluno("Y"));
        assertEquals(size + 1, lista.tamanho());
    }

    @Test
    @Order(7)
    void dicionarPosicaoExeption() {
        assertThrows(IllegalArgumentException.class, () ->
                lista.adicionar(100, new Aluno("X")));
    }

    @Test
    @Order(5)
    void pegaPosicaoValida() {
        assertTrue(lista.pega(0) instanceof Aluno);
    }

    @Test
    @Order(6)
    void pegaPosicaoExeption() {
        assertThrows(IllegalArgumentException.class, () -> lista.pega(-200));
    }

    @Test
    @Order(9)
    void remove() {
        int size = lista.tamanho();
        lista.remove(0);
        assertEquals(size - 1, lista.tamanho());
    }

    @Test
    @Order(4)
    void contem() {
        assertTrue(lista.contem(new Aluno("Robson")));
    }

    @Test
    @Order(5)
    void naoContem() {
        assertFalse(lista.contem(new Aluno("XY")));
    }

    @Test
    @Order(1)
    void tamanhoVazia() {
        assertEquals(0, lista.tamanho());
    }

    @Test
    @Order(3)
    void tamanhoNaoVazia() {
        assertTrue(lista.tamanho() > 0);
    }
}