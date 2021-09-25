package br.ufmt.alg3.dao;

import br.ufmt.alg3.entidades.Farmaceutico;
import java.util.List;

public interface FarmaceuticoDAO {
    public void adicionar(Farmaceutico object);
    public void atualizar(Farmaceutico object);
    public boolean remover(int id);
    public List<Farmaceutico> listar();
}
