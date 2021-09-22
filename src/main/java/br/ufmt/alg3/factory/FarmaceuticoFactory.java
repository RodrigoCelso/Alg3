package br.ufmt.alg3.factory;

import br.ufmt.alg3.daoPostgres.FarmaceuticoDAOImpl;
import br.ufmt.alg3.dao.EntidadeDAO;

public class FarmaceuticoFactory {
    public static EntidadeDAO createDAO(){
        return new FarmaceuticoDAOImpl();
    }
}
