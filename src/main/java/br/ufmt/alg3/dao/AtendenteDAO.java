package br.ufmt.alg3.dao;

import br.ufmt.alg3.entidades.Atendente;
import java.util.List;

public interface AtendenteDAO {
    public void adicionar(Atendente atendente);
    public void atualizar(Atendente atendente);
    public boolean remover(int id);
    public List<Atendente> listar();
}
