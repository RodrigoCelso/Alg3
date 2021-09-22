package br.ufmt.alg3.factory;

import br.ufmt.alg3.daoPostgres.CaixaDAOImpl;
import br.ufmt.alg3.dao.EntidadeDAO;

public class CaixaFactory {
    public static EntidadeDAO createDAO(){
        return new CaixaDAOImpl();
    }
}