package br.ufmt.alg3.factory;

import br.ufmt.alg3.daoPostgres.VendaDAOImpl;
import br.ufmt.alg3.dao.EntidadeDAO;

public class VendaFactory {
    public static EntidadeDAO createDAO(){
        return new VendaDAOImpl();
    }
}