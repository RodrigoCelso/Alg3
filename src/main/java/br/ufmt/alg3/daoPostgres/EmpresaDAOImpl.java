package br.ufmt.alg3.daoPostgres;

import br.ufmt.alg3.dao.EmpresaDAO;
import br.ufmt.alg3.entidades.Empresa;
import br.ufmt.alg3.main.Main;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmpresaDAOImpl implements EmpresaDAO{

    @Override
    public void adicionar(Empresa empresa) {
        Main.abreConexao();
        String sql = "INSERT INTO Empresa(nome,cnpj) VALUES (?,?);";
        try {
            PreparedStatement pstm = Main.con.prepareStatement(sql);
            pstm.setString(1,empresa.getNome());
            pstm.setString(2,empresa.getCnpj());
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        Main.fechaConexao();
    }

    @Override
    public void atualizar(Empresa empresa) {
        Main.abreConexao();
        String sql = "UPDATE Empresa SET (nome,cnpj) = (?,?) WHERE idEmpresa = ?;";
        try {
            PreparedStatement pstm = Main.con.prepareStatement(sql);
            pstm.setString(1,empresa.getNome());
            pstm.setString(2,empresa.getCnpj());
            pstm.setInt(3, empresa.getIdEmpresa());
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        Main.fechaConexao();
    }

    @Override
    public boolean remover(int id) {
        Main.abreConexao();
        String sql = "DELETE FROM Empresa WHERE idEmpresa = " + id + ";";
        try {
            int ret = Main.con.createStatement().executeUpdate(sql);
            return ret > 0;
        } catch (SQLException ex) {
        }
        Main.fechaConexao();
        return false;
    }

    @Override
    public List<Empresa> listar() {
        Main.abreConexao();
        List<Empresa> lista = new ArrayList<Empresa>();
        String sql = "SELECT * FROM Empresa;";
        try {
            ResultSet rs = Main.con.createStatement().executeQuery(sql);
            while(rs.next()){
                Empresa temp = new Empresa();
                temp.setIdEmpresa(rs.getInt("idEmpresa"));
                temp.setNome(rs.getString("nome"));
                temp.setCnpj(rs.getString("cnpj"));
                lista.add(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        Main.fechaConexao();
        return lista;
    }
}
