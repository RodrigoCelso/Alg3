package br.ufmt.alg3.factory;

import br.ufmt.alg3.daoPostgres.LVPDAOImpl;
import br.ufmt.alg3.dao.LVPDAO;

public class LVPFactory {
    public static LVPDAO createDAO(){
        return new LVPDAOImpl();
    }
}