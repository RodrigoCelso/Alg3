package br.ufmt.alg3.factory;

import br.ufmt.alg3.daoPostgres.CaixaDAOImpl;
import br.ufmt.alg3.dao.CaixaDAO;

public class CaixaFactory {
    public static CaixaDAO createDAO(){
        return new CaixaDAOImpl();
    }
}