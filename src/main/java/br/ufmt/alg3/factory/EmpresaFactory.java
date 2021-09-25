package br.ufmt.alg3.factory;

import br.ufmt.alg3.dao.EmpresaDAO;
import br.ufmt.alg3.daoPostgres.EmpresaDAOImpl;

public class EmpresaFactory {
    public static EmpresaDAO createDAO(){
        return new EmpresaDAOImpl();
    }
}
