package br.ufmt.alg3.dao;

import br.ufmt.alg3.entidades.Caixa;
import java.util.List;

public interface CaixaDAO {
    public void adicionar(Caixa object);
    public void atualizar(Caixa object);
    public boolean remover(int id);
    public List<Caixa> listar();
}
