package br.ufmt.alg3.daoPostgres;

import br.ufmt.alg3.entidades.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.ufmt.alg3.dao.EntidadeDAO;

public class ClienteDAOImpl implements EntidadeDAO{

    private Connection con;
    
    private void abreConexao(){
        try {
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/alg","postgres","123");
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Os métodos adicionar e atualizar estão utilizando o PreparedStatement para executar a Query ao banco
    @Override
    public void adicionar(Cliente cliente) {
        String sql = "INSERT INTO Cliente(nome,cpf,telefone) VALUES (?,?,?);";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1,cliente.getNome());
            pstm.setString(2,cliente.getCpf());
            pstm.setString(3,cliente.getTelefone());
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void atualizar(Cliente cliente, String campo) {
        String sql = "UPDATE Cliente SET ? = ? WHERE idCliente = ?;";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1,campo);
            
            //Verificar qual tipo de alteração será feita
            if(campo.toUpperCase().equals("NOME")){
                pstm.setString(2,cliente.getNome());
            }else if(campo.toUpperCase().equals("CPF")){
                pstm.setString(2,cliente.getCpf());
            }else if(campo.toUpperCase().equals("TELEFONE")){
                pstm.setString(2,cliente.getTelefone());
            }
            
            pstm.setInt(3, cliente.getIdCliente());
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Os métodos remover e listar estão utilizando o createStatement para executar a Query ao banco
    @Override
    public boolean remover(int id) {
        String sql = "DELETE FROM Disciplina WHERE idDisciplina = " + id + ";";
        try {
            int ret = con.createStatement().executeUpdate(sql);
            return ret > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<Cliente> listar() {
        List<Cliente> lista = new ArrayList<Cliente>();
        String sql = "SELECT * FROM Cliente;";
        try {
            ResultSet rs = con.createStatement().executeQuery(sql);
            while(rs.next()){
                Cliente temp = new Cliente();
                temp.setIdCliente(rs.getInt("idCliente"));
                temp.setNome(rs.getString("nome"));
                temp.setCpf(rs.getString("cpf"));
                lista.add(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
