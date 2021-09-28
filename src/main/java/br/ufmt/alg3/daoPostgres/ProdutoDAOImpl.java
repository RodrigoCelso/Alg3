package br.ufmt.alg3.daoPostgres;

import br.ufmt.alg3.entidades.Fabricante;
import br.ufmt.alg3.dao.ProdutoDAO;
import br.ufmt.alg3.entidades.Produto;
import br.ufmt.alg3.main.Main;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutoDAOImpl implements ProdutoDAO{

    @Override
    public void adicionar(Produto produto) {
        Main.abreConexao();
        String sql = "INSERT INTO Produto(idFabricante,nome,preco,quantidade) VALUES (?,?,?,?);";
        try {
            PreparedStatement pstm = Main.con.prepareStatement(sql);
            pstm.setInt(1,produto.getFabricante().getIdFabricante());
            pstm.setString(2,produto.getNome());
            pstm.setDouble(3,produto.getPreco());
            pstm.setInt(4,produto.getQuantidade());
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        Main.fechaConexao();
    }

    @Override
    public void atualizar(Produto produto) {
        Main.abreConexao();
        String sql = "UPDATE Produto SET (idFabricante,nome,preco,quantidade) = (?,?,?,?) WHERE idProduto = ?;";
        try {
            PreparedStatement pstm = Main.con.prepareStatement(sql);
            pstm.setInt(1,produto.getFabricante().getIdFabricante());
            pstm.setString(2,produto.getNome());
            pstm.setDouble(3,produto.getPreco());
            pstm.setInt(4,produto.getQuantidade());
            pstm.setInt(5,produto.getIdProduto());
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        Main.fechaConexao();
    }

    @Override
    public boolean remover(int id) {
        Main.abreConexao();
        String sql = "DELETE FROM Produto WHERE idProduto = " + id + ";";
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
    public List<Produto> listar() {
        Main.abreConexao();
        List<Produto> lista = new ArrayList<Produto>();
        String sql = "SELECT * FROM Produto;";
        try {
            ResultSet rs = Main.con.createStatement().executeQuery(sql);
            while(rs.next()){
                Produto temp = new Produto();
                Fabricante empresaTemp = new Fabricante();
                temp.setIdProduto(rs.getInt("idProduto"));
                empresaTemp.setIdFabricante(rs.getInt("idFabricante"));
                temp.setFabricante(empresaTemp);
                temp.setNome(rs.getString("nome"));
                temp.setPreco(rs.getDouble("preco"));
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
