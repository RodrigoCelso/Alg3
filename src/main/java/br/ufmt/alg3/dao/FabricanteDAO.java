package br.ufmt.alg3.dao;

import br.ufmt.alg3.entidades.Fabricante;
import java.util.List;

public interface FabricanteDAO {
    public void adicionar(Fabricante object);
    public void atualizar(Fabricante object);
    public boolean remover(int id);
    public List<Fabricante> listar();
}
