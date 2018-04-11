package br.com.ulbra;

import java.io.Serializable;

public class Usuario implements Serializable {

    private final ControladorConexao conexao;
    private String nome;

    public Usuario(ControladorConexao conexao) {
        this.conexao = conexao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ControladorConexao getConexao() {
        return conexao;
    }

    @Override
    public String toString() {
        return "Usuario{nome=" + nome + "}";
    }

}
