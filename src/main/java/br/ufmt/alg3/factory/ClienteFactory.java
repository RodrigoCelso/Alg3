package br.ufmt.alg3.factory;

import br.ufmt.alg3.daoPostgres.ClienteDAOImpl;
import br.ufmt.alg3.dao.EntidadeDAO;

public class ClienteFactory {
    public static EntidadeDAO createDAO(String alo){
        return new ClienteDAOImpl();
    }
}