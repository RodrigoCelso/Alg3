package br.ufmt.alg3.entidades;

public class Possui {
    private int idPossui;
    private Venda venda;
    private Produto produto;

    public int getIdPossui() {
        return idPossui;
    }

    public void setIdPossui(int idPossui) {
        this.idPossui = idPossui;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    
}
