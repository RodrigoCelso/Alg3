package br.ufmt.alg3.entidades;

public class EnderecoEmpresa {
    private Empresa empresa;
    private char[] cep = new char[9];
    private int numero;
    private String complemento;

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public char[] getCep() {
        return cep;
    }

    public void setCep(char[] cep) {
        this.cep = cep;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    
    
}
