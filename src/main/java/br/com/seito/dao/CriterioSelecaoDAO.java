package br.com.seito.dao;

import br.com.seito.entities.CriterioSelecao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CriterioSelecaoDAO extends BaseDAO<CriterioSelecao> {

    @Override
    protected String getTableName() {
        return "CRITERIO_SELECAO";
    }

    @Override
    protected String getIdColumnName() {
        return "ID_CRITERIO";
    }

    @Override
    protected String[] getColumnNames() {
        return new String[]{"NOME", "DESCRICAO"};
    }

    @Override
    protected CriterioSelecao mapResultSetToEntity(ResultSet rs) throws SQLException {
        CriterioSelecao criterio = new CriterioSelecao();
        criterio.setIdCriterio(rs.getInt("ID_CRITERIO"));
        criterio.setNome(rs.getString("NOME"));
        criterio.setDescricao(rs.getString("DESCRICAO"));
        return criterio;
    }

    @Override
    protected void setEntityParameters(PreparedStatement ps, CriterioSelecao entity) throws SQLException {
        ps.setString(1, entity.getNome());
        ps.setString(2, entity.getDescricao());
    }

    public List<CriterioSelecao> findByNome(String nome) {
        List<CriterioSelecao> list = new ArrayList<>();
        String sql = "SELECT * FROM " + getTableName() + " WHERE NOME LIKE ?";
        try (Connection conn = connectionFactory.conexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + nome + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(mapResultSetToEntity(rs));
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Error finding CriterioSelecao by nome", e);
        }
        return list;
    }
}
