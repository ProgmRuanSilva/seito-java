package br.com.seito.dao;

import br.com.seito.entities.TipoDoacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoDoacaoDAO extends BaseDAO<TipoDoacao> {

    @Override
    protected String getTableName() {
        return "TIPO_DOACAO";
    }

    @Override
    protected String getIdColumnName() {
        return "ID_TIPO_DOACAO";
    }

    @Override
    protected String[] getColumnNames() {
        return new String[]{"NOME", "DESCRICAO"};
    }

    @Override
    protected TipoDoacao mapResultSetToEntity(ResultSet rs) throws SQLException {
        TipoDoacao tipoDoacao = new TipoDoacao();
        tipoDoacao.setIdTipoDoacao(rs.getInt("ID_TIPO_DOACAO"));
        tipoDoacao.setNome(rs.getString("NOME"));
        tipoDoacao.setDescricao(rs.getString("DESCRICAO"));
        return tipoDoacao;
    }

    @Override
    protected void setEntityParameters(PreparedStatement ps, TipoDoacao entity) throws SQLException {
        ps.setString(1, entity.getNome());
        ps.setString(2, entity.getDescricao());
    }

    public List<TipoDoacao> findByNome(String nome) {
        List<TipoDoacao> list = new ArrayList<>();
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
            throw new RuntimeException("Error finding TipoDoacao by nome", e);
        }
        return list;
    }
}
