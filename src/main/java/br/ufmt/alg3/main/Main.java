package br.ufmt.alg3.main;

import br.ufmt.alg3.telas.TelaJFrame;
import br.ufmt.alg3.daoPostgres.ClienteDAOImpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
   
    public static Connection con;
    
    public static void abreConexao(){
        try {
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/alg","postgres","123");
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void fechaConexao(){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args){
        TelaJFrame tela = new TelaJFrame();
        tela.setVisible(true);
    } 
}
