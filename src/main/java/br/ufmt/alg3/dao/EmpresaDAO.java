package br.ufmt.alg3.dao;

import br.ufmt.alg3.entidades.Empresa;
import java.util.List;

public interface EmpresaDAO {
    public void adicionar(Empresa object);
    public void atualizar(Empresa object);
    public boolean remover(int id);
    public List<Empresa> listar();
}
