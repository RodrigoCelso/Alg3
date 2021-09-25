package br.ufmt.alg3.dao;

import br.ufmt.alg3.entidades.Venda;
import java.util.List;

public interface VendaDAO {
    public void adicionar(Venda object);
    public void atualizar(Venda object);
    public boolean remover(int id);
    public List<Venda> listar();
}
