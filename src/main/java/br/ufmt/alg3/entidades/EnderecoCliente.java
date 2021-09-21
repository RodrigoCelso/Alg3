package br.ufmt.alg3.entidades;

public class EnderecoCliente {
    private Cliente cliente;
    private String pontoReferencia;
    private int numero;
    private String complemento;
    private char[] cep = new char[9];

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getPontoReferencia() {
        return pontoReferencia;
    }

    public void setPontoReferencia(String pontoReferencia) {
        this.pontoReferencia = pontoReferencia;
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

    public char[] getCep() {
        return cep;
    }

    public void setCep(char[] cep) {
        this.cep = cep;
    }
    
    
}
