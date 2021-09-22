package br.ufmt.alg3.factory;

import br.ufmt.alg3.daoPostgres.LVPDAOImpl;
import br.ufmt.alg3.dao.EntidadeDAO;

public class LVPFactory {
    public static EntidadeDAO createDAO(){
        return new LVPDAOImpl();
    }
}