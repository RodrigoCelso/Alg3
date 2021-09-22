package br.ufmt.alg3.entidades;

public class Atendente {
    private int idAtendente;
    private Empresa empresa;
    private String nome;

    public int getIdVendedor() {
        return idAtendente;
    }

    public void setIdVendedor(int idVendedor) {
        this.idAtendente = idVendedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
