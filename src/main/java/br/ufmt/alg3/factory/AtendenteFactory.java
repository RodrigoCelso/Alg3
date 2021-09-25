package br.ufmt.alg3.factory;

import br.ufmt.alg3.dao.AtendenteDAO;
import br.ufmt.alg3.daoPostgres.AtendenteDAOImpl;

public class AtendenteFactory {
    public static AtendenteDAO createDAO(){
        return new AtendenteDAOImpl();
    }
}