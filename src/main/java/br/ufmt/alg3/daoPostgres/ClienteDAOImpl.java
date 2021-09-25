package br.ufmt.alg3.daoPostgres;

import br.ufmt.alg3.dao.ClienteDAO;
import br.ufmt.alg3.entidades.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.ufmt.alg3.main.Main;

public class ClienteDAOImpl implements ClienteDAO{    
    
    //Os métodos adicionar e atualizar estão utilizando o PreparedStatement para executar a Query ao banco
    @Override
    public void adicionar(Cliente cliente) {
        Main.abreConexao();
        String sql = "INSERT INTO Cliente(nome,cpf,telefone) VALUES (?,?,?);";
        try {
            PreparedStatement pstm = Main.con.prepareStatement(sql);
            pstm.setString(1,cliente.getNome());
            pstm.setString(2,cliente.getCpf());
            pstm.setString(3,cliente.getTelefone());
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        Main.fechaConexao();
    }

    @Override
    public void atualizar(Cliente cliente) {
        Main.abreConexao();
        String sql = "UPDATE Cliente SET (nome,cpf,telefone) = (?,?,?) WHERE idCliente = ?;";
        try {
            PreparedStatement pstm = Main.con.prepareStatement(sql);
            pstm.setString(1,cliente.getNome());
            pstm.setString(2,cliente.getCpf());
            pstm.setString(3,cliente.getTelefone());
            pstm.setInt(4, cliente.getIdCliente());
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        Main.fechaConexao();
    }
    
    //Os métodos remover e listar estão utilizando o createStatement para executar a Query ao banco
    @Override
    public boolean remover(int id) {
        Main.abreConexao();
        String sql = "DELETE FROM Cliente WHERE idCliente = " + id + ";";
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
    public List<Cliente> listar() {
        Main.abreConexao();
        List<Cliente> lista = new ArrayList<Cliente>();
        String sql = "SELECT * FROM Cliente;";
        try {
            ResultSet rs = Main.con.createStatement().executeQuery(sql);
            while(rs.next()){
                Cliente temp = new Cliente();
                temp.setIdCliente(rs.getInt("idCliente"));
                temp.setNome(rs.getString("nome"));
                temp.setTelefone(rs.getString("telefone"));
                temp.setCpf(rs.getString("cpf"));
                lista.add(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        Main.fechaConexao();
        return lista;
    }
}
