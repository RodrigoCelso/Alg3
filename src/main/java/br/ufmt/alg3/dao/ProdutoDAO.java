package br.ufmt.alg3.dao;

import br.ufmt.alg3.entidades.Produto;
import java.util.List;

public interface ProdutoDAO {
    public void adicionar(Produto object);
    public void atualizar(Produto object);
    public boolean remover(int id);
    public List<Produto> listar();
}
