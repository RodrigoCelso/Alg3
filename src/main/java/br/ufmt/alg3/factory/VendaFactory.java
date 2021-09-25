package br.ufmt.alg3.factory;

import br.ufmt.alg3.daoPostgres.VendaDAOImpl;
import br.ufmt.alg3.dao.VendaDAO;

public class VendaFactory {
    public static VendaDAO createDAO(){
        return new VendaDAOImpl();
    }
}