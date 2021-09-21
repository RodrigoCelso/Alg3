package br.ufmt.alg3.entidades;

public class Empresa {
    private int idEmpresa;
    private String nome;
    private char[] cnpj = new char[18];

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char[] getCnpj() {
        return cnpj;
    }

    public void setCnpj(char[] cnpj) {
        this.cnpj = cnpj;
    }
    
    
}
