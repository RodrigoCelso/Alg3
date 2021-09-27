package br.ufmt.alg3.daoPostgres;

import br.ufmt.alg3.dao.FarmaceuticoDAO;
import br.ufmt.alg3.entidades.Empresa;
import br.ufmt.alg3.entidades.Farmaceutico;
import br.ufmt.alg3.main.Main;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FarmaceuticoDAOImpl implements FarmaceuticoDAO{

    @Override
    public void adicionar(Farmaceutico farmaceutico) {
        Main.abreConexao();
        String sql = "INSERT INTO Farmaceutico(idempresa,nome,crf) VALUES (?,?,?);";
        try {
            PreparedStatement pstm = Main.con.prepareStatement(sql);
            pstm.setInt(1,farmaceutico.getEmpresa().getIdEmpresa());
            pstm.setString(2,farmaceutico.getNome());
            pstm.setString(3,farmaceutico.getCrf());
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        Main.fechaConexao();
    }

    @Override
    public void atualizar(Farmaceutico farmaceutico) {
        Main.abreConexao();
        String sql = "UPDATE Farmaceutico SET (idEmpresa,nome,crf) = (?,?,?) WHERE idFarmaceutico = ?;";
        try {
            PreparedStatement pstm = Main.con.prepareStatement(sql);
            pstm.setInt(1,farmaceutico.getEmpresa().getIdEmpresa());
            pstm.setString(2,farmaceutico.getNome());
            pstm.setString(3,farmaceutico.getCrf());
            pstm.setInt(4,farmaceutico.getIdFarmaceutico());
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        Main.fechaConexao();
    }

    @Override
    public boolean remover(int id) {
        Main.abreConexao();
        String sql = "DELETE FROM Farmaceutico WHERE idFarmaceutico = " + id + ";";
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
    public List<Farmaceutico> listar() {
        Main.abreConexao();
        List<Farmaceutico> lista = new ArrayList<Farmaceutico>();
        String sql = "SELECT * FROM Farmaceutico;";
        try {
            ResultSet rs = Main.con.createStatement().executeQuery(sql);
            while(rs.next()){
                Farmaceutico temp = new Farmaceutico();
                Empresa temp2 = new Empresa();
                temp.setIdFarmaceutico(rs.getInt("idFarmaceutico"));
                temp2.setIdEmpresa(rs.getInt("idEmpresa"));
                temp.setEmpresa(temp2);
                temp.setNome(rs.getString("nome"));
                temp.setCrf(rs.getString("crf"));
                lista.add(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        Main.fechaConexao();
        return lista;
    }
}
