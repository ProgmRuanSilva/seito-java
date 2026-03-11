package br.com.seito.dao;

import br.com.seito.entities.ProgramaSocial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProgramaSocialDAO extends BaseDAO<ProgramaSocial> {

    @Override
    protected String getTableName() {
        return "PROGRAMA_SOCIAL";
    }

    @Override
    protected String getIdColumnName() {
        return "ID_PROGRAMA";
    }

    @Override
    protected String[] getColumnNames() {
        return new String[]{"NOME", "DESCRICAO", "IDADE_MINIMA", "IDADE_MAXIMA"};
    }

    @Override
    protected ProgramaSocial mapResultSetToEntity(ResultSet rs) throws SQLException {
        ProgramaSocial programa = new ProgramaSocial();
        programa.setIdPrograma(rs.getInt("ID_PROGRAMA"));
        programa.setNome(rs.getString("NOME"));
        programa.setDescricao(rs.getString("DESCRICAO"));
        programa.setIdadeMinima(rs.getInt("IDADE_MINIMA"));
        programa.setIdadeMaxima(rs.getInt("IDADE_MAXIMA"));
        return programa;
    }

    @Override
    protected void setEntityParameters(PreparedStatement ps, ProgramaSocial entity) throws SQLException {
        ps.setString(1, entity.getNome());
        ps.setString(2, entity.getDescricao());
        ps.setInt(3, entity.getIdadeMinima());
        ps.setInt(4, entity.getIdadeMaxima());
    }

    public List<ProgramaSocial> findByNome(String nome) {
        List<ProgramaSocial> list = new ArrayList<>();
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
            throw new RuntimeException("Error finding ProgramaSocial by nome", e);
        }
        return list;
    }

    public List<ProgramaSocial> findByIdade(int idade) {
        List<ProgramaSocial> list = new ArrayList<>();
        String sql = "SELECT * FROM " + getTableName() + " WHERE IDADE_MINIMA <= ? AND IDADE_MAXIMA >= ?";
        try (Connection conn = connectionFactory.conexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idade);
            ps.setInt(2, idade);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(mapResultSetToEntity(rs));
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Error finding ProgramaSocial by idade", e);
        }
        return list;
    }
}
