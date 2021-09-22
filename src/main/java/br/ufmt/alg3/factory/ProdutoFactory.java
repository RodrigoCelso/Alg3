package br.ufmt.alg3.factory;

import br.ufmt.alg3.daoPostgres.ProdutoDAOImpl;
import br.ufmt.alg3.dao.EntidadeDAO;

public class ProdutoFactory {
    public static EntidadeDAO createDAO(){
        return new ProdutoDAOImpl();
    }
}