package br.ufmt.alg3.factory;

import br.ufmt.alg3.daoPostgres.FarmaceuticoDAOImpl;
import br.ufmt.alg3.dao.FarmaceuticoDAO;

public class FarmaceuticoFactory {
    public static FarmaceuticoDAO createDAO(){
        return new FarmaceuticoDAOImpl();
    }
}
