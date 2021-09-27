package br.ufmt.alg3.daoPostgres;

import br.ufmt.alg3.dao.FabricanteDAO;
import br.ufmt.alg3.entidades.Fabricante;
import br.ufmt.alg3.main.Main;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FabricanteDAOImpl implements FabricanteDAO{

    @Override
    public void adicionar(Fabricante fabricante) {
        Main.abreConexao();
        String sql = "INSERT INTO Fabricante(cnpj,nome) VALUES (?,?);";
        try {
            PreparedStatement pstm = Main.con.prepareStatement(sql);
            pstm.setString(1,fabricante.getCnpj());
            pstm.setString(2,fabricante.getNome());
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        Main.fechaConexao();
    }

    @Override
    public void atualizar(Fabricante fabricante) {
        Main.abreConexao();
        String sql = "UPDATE Fabricante SET (cnpj,nome) = (?,?) WHERE idFabricante = ?;";
        try {
            PreparedStatement pstm = Main.con.prepareStatement(sql);
            pstm.setString(1,fabricante.getCnpj());
            pstm.setString(2,fabricante.getNome());
            pstm.setInt(3,fabricante.getIdFabricante());
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        Main.fechaConexao();
    }

    @Override
    public boolean remover(int id) {
        Main.abreConexao();
        String sql = "DELETE FROM Fabricante WHERE idFabricante = " + id + ";";
        try {
            int ret = Main.con.createStatement().executeUpdate(sql);
            return ret > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        Main.fechaConexao();
        return false;
    }

    @Override
    public List<Fabricante> listar() {
        Main.abreConexao();
        List<Fabricante> lista = new ArrayList<Fabricante>();
        String sql = "SELECT * FROM Fabricante;";
        try {
            ResultSet rs = Main.con.createStatement().executeQuery(sql);
            while(rs.next()){
                Fabricante temp = new Fabricante();
                temp.setIdFabricante(rs.getInt("idFabricante"));
                temp.setCnpj(rs.getString("cnpj"));
                temp.setNome(rs.getString("nome"));
                lista.add(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        Main.fechaConexao();
        return lista;
    }
    
}
