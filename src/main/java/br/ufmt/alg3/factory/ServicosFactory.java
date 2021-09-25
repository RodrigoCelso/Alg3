package br.ufmt.alg3.factory;

import br.ufmt.alg3.daoPostgres.ServicosDAOImpl;
import br.ufmt.alg3.dao.ServicosDAO;

public class ServicosFactory {
    public static ServicosDAO createDAO(){
        return new ServicosDAOImpl();
    }
}