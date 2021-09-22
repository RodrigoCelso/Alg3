package br.ufmt.alg3.factory;

import br.ufmt.alg3.daoPostgres.AtendenteDAOImpl;
import br.ufmt.alg3.dao.EntidadeDAO;

public class AtendenteFactory {
    public static EntidadeDAO createDAO(){
        return new AtendenteDAOImpl();
    }
}