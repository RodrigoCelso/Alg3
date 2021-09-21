package br.ufmt.alg3.entidades;

public class Fabricante {
    private int idFabricante;
    private char[] cnpj = new char[18];
    private String nome;

    public int getIdFabricante() {
        return idFabricante;
    }

    public void setIdFabricante(int idFabricante) {
        this.idFabricante = idFabricante;
    }

    public char[] getCnpj() {
        return cnpj;
    }

    public void setCnpj(char[] cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
