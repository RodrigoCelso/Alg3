package br.ufmt.alg3.daoPostgres;

import br.ufmt.alg3.dao.CaixaDAO;
import br.ufmt.alg3.entidades.Caixa;
import br.ufmt.alg3.entidades.Empresa;
import br.ufmt.alg3.main.Main;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CaixaDAOImpl implements CaixaDAO{

    @Override
    public void adicionar(Caixa caixa) {
        Main.abreConexao();
        String sql = "INSERT INTO Caixa(idEmpresa,nome,horaAbertura,horaFechamento) VALUES (?,?,?,?);";
        try {
            PreparedStatement pstm = Main.con.prepareStatement(sql);
            pstm.setInt(1,caixa.getEmpresa().getIdEmpresa());
            pstm.setString(2,caixa.getNome());
            pstm.setString(3,caixa.getHoraAbertura());
            pstm.setString(4,caixa.getHoraFechamento());
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        Main.fechaConexao();
    }

    @Override
    public void atualizar(Caixa caixa) {
        Main.abreConexao();
        String sql = "UPDATE Caixa SET (idEmpresa,nome,horaAbertura,horaFechamento) = (?,?,?,?) WHERE idCaixa = ?;";
        try {
            PreparedStatement pstm = Main.con.prepareStatement(sql);
            pstm.setInt(1,caixa.getEmpresa().getIdEmpresa());
            pstm.setString(2,caixa.getNome());
            pstm.setString(3,caixa.getHoraAbertura());
            pstm.setString(4,caixa.getHoraFechamento());
            pstm.setInt(5,caixa.getIdCaixa());
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        Main.fechaConexao();
    }

    @Override
    public boolean remover(int id) {
        Main.abreConexao();
        String sql = "DELETE FROM Caixa WHERE idCaixa = " + id + ";";
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
    public List<Caixa> listar() {
        Main.abreConexao();
        List<Caixa> lista = new ArrayList<Caixa>();
        String sql = "SELECT * FROM Caixa;";
        try {
            ResultSet rs = Main.con.createStatement().executeQuery(sql);
            while(rs.next()){
                Caixa temp = new Caixa();
                Empresa empresaTemp = new Empresa();
                temp.setIdCaixa(rs.getInt("idCaixa"));
                empresaTemp.setIdEmpresa(rs.getInt("idEmpresa"));
                temp.setEmpresa(empresaTemp);
                temp.setNome(rs.getString("nome"));
                temp.setHoraAbertura(rs.getString("horaAbertura"));
                temp.setHoraFechamento(rs.getString("horaFechamento"));
                lista.add(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        Main.fechaConexao();
        return lista;
    }
}
