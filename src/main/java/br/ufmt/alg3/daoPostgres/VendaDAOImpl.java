package br.ufmt.alg3.daoPostgres;

import br.ufmt.alg3.dao.VendaDAO;
import br.ufmt.alg3.entidades.Venda;
import br.ufmt.alg3.main.Main;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VendaDAOImpl implements VendaDAO{

    @Override
    public void adicionar(Venda venda) {
        Main.abreConexao();
        String sql = "INSERT INTO Venda(entrega,valor,modoPagamento,data) VALUES (?,?,?,?);";
        try {
            PreparedStatement pstm = Main.con.prepareStatement(sql);
            pstm.setBoolean(1,venda.isEntrega());
            pstm.setDouble(2,venda.getValor());
            pstm.setString(3,venda.getModoPagamento());
            pstm.setString(4,venda.getData());
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        Main.fechaConexao();
    }

    @Override
    public void atualizar(Venda venda) {
        Main.abreConexao();
        String sql = "UPDATE Venda SET (entrega,valor,modoPagamento,data) = (?,?,?,?) WHERE idVenda = ?;";
        try {
            PreparedStatement pstm = Main.con.prepareStatement(sql);
            pstm.setBoolean(1,venda.isEntrega());
            pstm.setDouble(2,venda.getValor());
            pstm.setString(3,venda.getModoPagamento());
            pstm.setString(3,venda.getData());
            pstm.setInt(5, venda.getIdVenda());
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        Main.fechaConexao();
    }

    @Override
    public boolean remover(int id) {
        Main.abreConexao();
        String sql = "DELETE FROM Venda WHERE idVenda = " + id + ";";
        try {
            int ret = Main.con.createStatement().executeUpdate(sql);
            return ret > 0;
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        Main.fechaConexao();
        return false;
    }

    @Override
    public List<Venda> listar() {
        Main.abreConexao();
        List<Venda> lista = new ArrayList<Venda>();
        String sql = "SELECT * FROM Venda;";
        try {
            ResultSet rs = Main.con.createStatement().executeQuery(sql);
            while(rs.next()){
                Venda temp = new Venda();
                temp.setIdVenda(rs.getInt("idVenda"));
                temp.setEntrega(rs.getBoolean("entrega"));
                temp.setValor(rs.getDouble("valor"));
                temp.setModoPagamento(rs.getString("modoPagamento"));
                temp.setData(rs.getString("data"));
                lista.add(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        Main.fechaConexao();
        return lista;
    }

}
