package br.ufmt.alg3.factory;

import br.ufmt.alg3.dao.EntidadeDAO;
import br.ufmt.alg3.daoPostgres.EmpresaDAOImpl;

public class EmpresaFactory {
    public static EntidadeDAO createDAO(){
        return new EmpresaDAOImpl();
    }
}
