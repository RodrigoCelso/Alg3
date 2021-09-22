package br.ufmt.alg3.factory;

import br.ufmt.alg3.daoPostgres.FabricanteDAOImpl;
import br.ufmt.alg3.dao.EntidadeDAO;

public class FabricanteFactory {
    public static EntidadeDAO createDAO(){
        return new FabricanteDAOImpl();
    }  
}
