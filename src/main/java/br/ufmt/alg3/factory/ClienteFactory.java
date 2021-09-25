package br.ufmt.alg3.factory;

import br.ufmt.alg3.dao.ClienteDAO;
import br.ufmt.alg3.daoPostgres.ClienteDAOImpl;

public class ClienteFactory {
    public static ClienteDAO createDAO(){
        return new ClienteDAOImpl();
    }
}