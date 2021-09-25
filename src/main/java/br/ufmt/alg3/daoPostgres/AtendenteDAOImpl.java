package br.ufmt.alg3.daoPostgres;

import br.ufmt.alg3.dao.AtendenteDAO;
import br.ufmt.alg3.entidades.Atendente;
import br.ufmt.alg3.main.Main;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AtendenteDAOImpl implements AtendenteDAO{

    @Override
    public void adicionar(Atendente atendente) {
        Main.abreConexao();
        String sql = "INSERT INTO Atendente(idempresa,nome) VALUES (?,?);";
        try {
            PreparedStatement pstm = Main.con.prepareStatement(sql);
            pstm.setInt(1,atendente.getEmpresa().getIdEmpresa());
            pstm.setString(2,atendente.getNome());
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        Main.fechaConexao();
    }

    @Override
    public void atualizar(Atendente atendente) {
        Main.abreConexao();
        String sql = "UPDATE Atendente SET (idEmpresa,nome) = (?,?) WHERE idAtendente = ?;";
        try {
            PreparedStatement pstm = Main.con.prepareStatement(sql);
            pstm.setInt(1,atendente.getEmpresa().getIdEmpresa());
            pstm.setString(2,atendente.getNome());
            pstm.setInt(3,atendente.getIdAtendente());
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        Main.fechaConexao();
    }

    @Override
    public boolean remover(int id) {
        Main.abreConexao();
        String sql = "DELETE FROM Atendente WHERE idAtendente = " + id + ";";
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
    public List<Atendente> listar() {
        Main.abreConexao();
        List<Atendente> lista = new ArrayList<Atendente>();
        String sql = "SELECT * FROM Cliente;";
        try {
            ResultSet rs = Main.con.createStatement().executeQuery(sql);
            while(rs.next()){
                Atendente temp = new Atendente();
                temp.setIdAtendente(rs.getInt("idAtendente"));
                temp.getEmpresa().setIdEmpresa(rs.getInt("idEmpresa"));
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
