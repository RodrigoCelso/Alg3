package br.ufmt.alg3.factory;

import br.ufmt.alg3.daoPostgres.ProdutoDAOImpl;
import br.ufmt.alg3.dao.ProdutoDAO;

public class ProdutoFactory {
    public static ProdutoDAO createDAO(){
        return new ProdutoDAOImpl();
    }
}