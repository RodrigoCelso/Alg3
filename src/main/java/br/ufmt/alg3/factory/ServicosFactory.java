package br.ufmt.alg3.factory;

import br.ufmt.alg3.daoPostgres.ServicosDAOImpl;
import br.ufmt.alg3.dao.EntidadeDAO;

public class ServicosFactory {
    public static EntidadeDAO createDAO(){
        return new ServicosDAOImpl();
    }
}