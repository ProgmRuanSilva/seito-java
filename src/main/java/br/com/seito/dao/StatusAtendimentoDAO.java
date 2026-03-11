package br.com.seito.dao;

import br.com.seito.entities.StatusAtendimento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatusAtendimentoDAO extends BaseDAO<StatusAtendimento> {

    @Override
    protected String getTableName() {
        return "STATUS_ATENDIMENTO";
    }

    @Override
    protected String getIdColumnName() {
        return "ID_STATUS";
    }

    @Override
    protected String[] getColumnNames() {
        return new String[]{"NOME", "DESCRICAO"};
    }

    @Override
    protected StatusAtendimento mapResultSetToEntity(ResultSet rs) throws SQLException {
        StatusAtendimento status = new StatusAtendimento();
        status.setIdStatus(rs.getInt("ID_STATUS"));
        status.setNome(rs.getString("NOME"));
        status.setDescricao(rs.getString("DESCRICAO"));
        return status;
    }

    @Override
    protected void setEntityParameters(PreparedStatement ps, StatusAtendimento entity) throws SQLException {
        ps.setString(1, entity.getNome());
        ps.setString(2, entity.getDescricao());
    }

    public List<StatusAtendimento> findByNome(String nome) {
        List<StatusAtendimento> list = new ArrayList<>();
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
            throw new RuntimeException("Error finding StatusAtendimento by nome", e);
        }
        return list;
    }
}
