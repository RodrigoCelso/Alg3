package br.ufmt.alg3.daoPostgres;

import br.ufmt.alg3.dao.ServicosDAO;
import br.ufmt.alg3.entidades.Servicos;
import br.ufmt.alg3.main.Main;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServicosDAOImpl implements ServicosDAO{

    @Override
    public void adicionar(Servicos servicos) {
        Main.abreConexao();
        String sql = "INSERT INTO Servicos(nome,preco) VALUES (?,?);";
        try {
            PreparedStatement pstm = Main.con.prepareStatement(sql);
            pstm.setString(1,servicos.getNome());
            pstm.setDouble(2,servicos.getPreco());
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        Main.fechaConexao();
    }

    @Override
    public void atualizar(Servicos servicos) {
        Main.abreConexao();
        String sql = "UPDATE Servicos SET (nome,preco) = (?,?) WHERE idServicos = ?;";
        try {
            PreparedStatement pstm = Main.con.prepareStatement(sql);
            pstm.setString(1,servicos.getNome());
            pstm.setDouble(2,servicos.getPreco());
            pstm.setInt(3, servicos.getIdServicos());
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        Main.fechaConexao();
    }

    @Override
    public boolean remover(int id) {
        Main.abreConexao();
        String sql = "DELETE FROM Servicos WHERE idServicos = " + id + ";";
        try {
            int ret = Main.con.createStatement().executeUpdate(sql);
            return ret > 0;
        } catch (SQLException ex) {
        }
        Main.fechaConexao();
        return false;
    }

    @Override
    public List<Servicos> listar() {
        Main.abreConexao();
        List<Servicos> lista = new ArrayList<Servicos>();
        String sql = "SELECT * FROM Servicos;";
        try {
            ResultSet rs = Main.con.createStatement().executeQuery(sql);
            while(rs.next()){
                Servicos temp = new Servicos();
                temp.setIdServicos(rs.getInt("idServicos"));
                temp.setNome(rs.getString("nome"));
                temp.setPreco(rs.getDouble("preco"));
                lista.add(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        Main.fechaConexao();
        return lista;
    }
    
}
