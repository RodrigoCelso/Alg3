package br.ufmt.alg3.daoPostgres;

import br.ufmt.alg3.dao.LVPDAO;
import br.ufmt.alg3.entidades.LVP;
import br.ufmt.alg3.entidades.Produto;
import br.ufmt.alg3.entidades.Venda;
import br.ufmt.alg3.main.Main;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LVPDAOImpl implements LVPDAO{

    @Override
    public void adicionar(LVP lvp) {
        Main.abreConexao();
        String sql = "INSERT INTO Possui(idProduto,idVenda,quantidade) VALUES (?,?,?);";
        try {
            PreparedStatement pstm = Main.con.prepareStatement(sql);
            pstm.setInt(1,lvp.getProduto().getIdProduto());
            pstm.setInt(2,lvp.getVenda().getIdVenda());
            pstm.setInt(3,lvp.getQuantidade());
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        Main.fechaConexao();
    }

    @Override
    public void atualizar(LVP lvp) {
        Main.abreConexao();
        String sql = "UPDATE Possui SET (idProduto,idVenda,quantidade) = (?,?,?) WHERE idPossui = ?;";
        try {
            PreparedStatement pstm = Main.con.prepareStatement(sql);
            pstm.setInt(1,lvp.getProduto().getIdProduto());
            pstm.setInt(2,lvp.getVenda().getIdVenda());
            pstm.setInt(3,lvp.getQuantidade());
            pstm.setInt(4,lvp.getIdLvp());
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        Main.fechaConexao();
    }

    @Override
    public boolean remover(int id) {
        Main.abreConexao();
        String sql = "DELETE FROM Possui WHERE idPossui = " + id + ";";
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
    public List<LVP> listar() {
        Main.abreConexao();
        List<LVP> lista = new ArrayList<LVP>();
        String sql = "SELECT * FROM Possui;";
        try {
            ResultSet rs = Main.con.createStatement().executeQuery(sql);
            while(rs.next()){
                LVP temp = new LVP();
                Produto temp2 = new Produto();
                Venda temp3 = new Venda();
                temp.setIdLvp(rs.getInt("idPossui"));
                temp2.setIdProduto(rs.getInt("idProduto"));
                temp.setProduto(temp2);
                temp3.setIdVenda(rs.getInt("idVenda"));
                temp.setVenda(temp3);
                temp.setQuantidade(rs.getInt("quantidade"));
                lista.add(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        Main.fechaConexao();
        return lista;
    }
    
}
