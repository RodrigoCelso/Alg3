package br.ufmt.alg3.dao;

import br.ufmt.alg3.entidades.LVP;
import java.util.List;

public interface LVPDAO {
    public void adicionar(LVP object);
    public void atualizar(LVP object);
    public boolean remover(int id);
    public List<LVP> listar();
}
