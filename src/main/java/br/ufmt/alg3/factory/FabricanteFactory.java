package br.ufmt.alg3.factory;

import br.ufmt.alg3.daoPostgres.FabricanteDAOImpl;
import br.ufmt.alg3.dao.FabricanteDAO;

public class FabricanteFactory {
    public static FabricanteDAO createDAO(){
        return new FabricanteDAOImpl();
    }  
}
