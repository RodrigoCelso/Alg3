package br.ufmt.alg3.entidades;

public class LVP {
    // Solicita foi alterado para Lista de Vendas de Produtos (LVP)
    private int idLvp;
    private Venda venda;
    private Produto produto;
    private int quantidade;

    public int getIdLvp() {
        return idLvp;
    }

    public void setIdLvp(int idLvp) {
        this.idLvp = idLvp;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
}
