package br.ufmt.alg3.dao;

import br.ufmt.alg3.entidades.Cliente;
import java.util.List;

public interface EntidadeDAO {
    public void adicionar(Cliente cliente);
    public void atualizar(Cliente cliente);
    public boolean remover(int id);
    public List<Cliente> listar();
}
