package br.com.seito.dao;

import br.com.seito.entities.Beneficiario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BeneficiarioDAO extends BaseDAO<Beneficiario> {

    @Override
    protected String getTableName() {
        return "BENEFICIARIO";
    }

    @Override
    protected String getIdColumnName() {
        return "ID_BENEFICIARIO";
    }

    @Override
    protected String[] getColumnNames() {
        return new String[]{"ID_PESSOA", "DATA_NASCIMENTO", "ID_PROGRAMA", "ID_CRITERIO", "TRATAMENTO"};
    }

    @Override
    protected Beneficiario mapResultSetToEntity(ResultSet rs) throws SQLException {
        Beneficiario beneficiario = new Beneficiario();
        beneficiario.setIdPessoa(rs.getInt("ID_PESSOA"));
        beneficiario.setIdBeneficiado(rs.getInt("ID_BENEFICIARIO"));
        beneficiario.setDataNascimento(rs.getDate("DATA_NASCIMENTO"));
        beneficiario.setIdPrograma(rs.getInt("ID_PROGRAMA"));
        beneficiario.setIdCriterio(rs.getInt("ID_CRITERIO"));
        beneficiario.setTratamento(rs.getString("TRATAMENTO"));
        return beneficiario;
    }

    @Override
    protected void setEntityParameters(PreparedStatement ps, Beneficiario entity) throws SQLException {
        ps.setInt(1, entity.getIdPessoa());
        ps.setDate(2, new java.sql.Date(entity.getDataNascimento().getTime()));
        ps.setInt(3, entity.getIdPrograma());
        ps.setInt(4, entity.getIdCriterio());
        ps.setString(5, entity.getTratamento());
    }

    public List<Beneficiario> findByIdPrograma(int idPrograma) {
        List<Beneficiario> list = new ArrayList<>();
        String sql = "SELECT * FROM " + getTableName() + " WHERE ID_PROGRAMA = ?";
        try (Connection conn = connectionFactory.conexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idPrograma);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(mapResultSetToEntity(rs));
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Error finding Beneficiario by programa", e);
        }
        return list;
    }

    public List<Beneficiario> findByIdCriterio(int idCriterio) {
        List<Beneficiario> list = new ArrayList<>();
        String sql = "SELECT * FROM " + getTableName() + " WHERE ID_CRITERIO = ?";
        try (Connection conn = connectionFactory.conexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idCriterio);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(mapResultSetToEntity(rs));
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Error finding Beneficiario by criterio", e);
        }
        return list;
    }
}
