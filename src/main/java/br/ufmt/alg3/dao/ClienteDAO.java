package br.ufmt.alg3.dao;

import br.ufmt.alg3.entidades.Cliente;
import java.util.List;

public interface ClienteDAO {
    public void adicionar(Cliente object);
    public void atualizar(Cliente object);
    public boolean remover(int id);
    public List<Cliente> listar();
}
