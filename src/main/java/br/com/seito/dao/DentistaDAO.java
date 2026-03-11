package br.com.seito.dao;

import br.com.seito.entities.Dentista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DentistaDAO extends BaseDAO<Dentista> {

    @Override
    protected String getTableName() {
        return "DENTISTA";
    }

    @Override
    protected String getIdColumnName() {
        return "ID_DENTISTA";
    }

    @Override
    protected String[] getColumnNames() {
        return new String[]{"ID_PESSOA", "CRO", "ID_ESPECIALIDADE", "STATUS"};
    }

    @Override
    protected Dentista mapResultSetToEntity(ResultSet rs) throws SQLException {
        Dentista dentista = new Dentista();
        dentista.setIdPessoa(rs.getInt("ID_PESSOA"));
        dentista.setIdDentista(rs.getInt("ID_DENTISTA"));
        dentista.setCro(rs.getString("CRO"));
        dentista.setIdEspecialidade(rs.getInt("ID_ESPECIALIDADE"));
        dentista.setStatus(rs.getString("STATUS"));
        return dentista;
    }

    @Override
    protected void setEntityParameters(PreparedStatement ps, Dentista entity) throws SQLException {
        ps.setInt(1, entity.getIdPessoa());
        ps.setString(2, entity.getCro());
        ps.setInt(3, entity.getIdEspecialidade());
        ps.setString(4, entity.getStatus());
    }

    public List<Dentista> findByIdEspecialidade(int idEspecialidade) {
        List<Dentista> list = new ArrayList<>();
        String sql = "SELECT * FROM " + getTableName() + " WHERE ID_ESPECIALIDADE = ?";
        try (Connection conn = connectionFactory.conexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idEspecialidade);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(mapResultSetToEntity(rs));
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Error finding Dentista by especialidade", e);
        }
        return list;
    }

    public List<Dentista> findByStatus(String status) {
        List<Dentista> list = new ArrayList<>();
        String sql = "SELECT * FROM " + getTableName() + " WHERE STATUS = ?";
        try (Connection conn = connectionFactory.conexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, status);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(mapResultSetToEntity(rs));
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Error finding Dentista by status", e);
        }
        return list;
    }

    public List<Dentista> findByCro(String cro) {
        List<Dentista> list = new ArrayList<>();
        String sql = "SELECT * FROM " + getTableName() + " WHERE CRO = ?";
        try (Connection conn = connectionFactory.conexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cro);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(mapResultSetToEntity(rs));
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Error finding Dentista by CRO", e);
        }
        return list;
    }
}
