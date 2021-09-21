package br.ufmt.alg3.entidades;

public class Venda {
    private int idVenda;
    private boolean entrega;
    private double valor;
    private char[] modoPagamento = new char[20];
    private String data;

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public boolean isEntrega() {
        return entrega;
    }

    public void setEntrega(boolean entrega) {
        this.entrega = entrega;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public char[] getModoPagamento() {
        return modoPagamento;
    }

    public void setModoPagamento(char[] modoPagamento) {
        this.modoPagamento = modoPagamento;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    
}
