package br.ufmt.alg3.dao;

import br.ufmt.alg3.entidades.Servicos;
import java.util.List;

public interface ServicosDAO {
    public void adicionar(Servicos object);
    public void atualizar(Servicos object);
    public boolean remover(int id);
    public List<Servicos> listar();
}
