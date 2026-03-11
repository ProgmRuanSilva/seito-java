package br.com.seito.dao;

import br.com.seito.entities.Atendimento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AtendimentoDAO extends BaseDAO<Atendimento> {

    @Override
    protected String getTableName() {
        return "ATENDIMENTO";
    }

    @Override
    protected String getIdColumnName() {
        return "ID_ATENDIMENTO";
    }

    @Override
    protected String[] getColumnNames() {
        return new String[]{"ID_PESSOA_SOLICITANTE", "DATA_HORA", "ID_PESSOA_DENTISTA", "ID_STATUS", "PRIORIDADE", "DESCRICAO"};
    }

    @Override
    protected Atendimento mapResultSetToEntity(ResultSet rs) throws SQLException {
        Atendimento atendimento = new Atendimento();
        atendimento.setIdAtendimento(rs.getInt("ID_ATENDIMENTO"));
        atendimento.setIdPessoaSolicitante(rs.getInt("ID_PESSOA_SOLICITANTE"));
        atendimento.setDataHora(rs.getDate("DATA_HORA"));
        atendimento.setIdPessoaDentista(rs.getInt("ID_PESSOA_DENTISTA"));
        atendimento.setIdStatus(rs.getInt("ID_STATUS"));
        atendimento.setPrioridade(rs.getString("PRIORIDADE"));
        atendimento.setDescricao(rs.getString("DESCRICAO"));
        return atendimento;
    }

    @Override
    protected void setEntityParameters(PreparedStatement ps, Atendimento entity) throws SQLException {
        ps.setInt(1, entity.getIdPessoaSolicitante());
        ps.setDate(2, new java.sql.Date(entity.getDataHora().getTime()));
        ps.setInt(3, entity.getIdPessoaDentista());
        ps.setInt(4, entity.getIdStatus());
        ps.setString(5, entity.getPrioridade());
        ps.setString(6, entity.getDescricao());
    }

    public List<Atendimento> findByIdPessoaSolicitante(int idPessoa) {
        List<Atendimento> list = new ArrayList<>();
        String sql = "SELECT * FROM " + getTableName() + " WHERE ID_PESSOA_SOLICITANTE = ?";
        try (Connection conn = connectionFactory.conexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idPessoa);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(mapResultSetToEntity(rs));
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Error finding Atendimento by solicitante", e);
        }
        return list;
    }

    public List<Atendimento> findByIdPessoaDentista(int idPessoaDentista) {
        List<Atendimento> list = new ArrayList<>();
        String sql = "SELECT * FROM " + getTableName() + " WHERE ID_PESSOA_DENTISTA = ?";
        try (Connection conn = connectionFactory.conexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idPessoaDentista);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(mapResultSetToEntity(rs));
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Error finding Atendimento by dentista", e);
        }
        return list;
    }

    public List<Atendimento> findByIdStatus(int idStatus) {
        List<Atendimento> list = new ArrayList<>();
        String sql = "SELECT * FROM " + getTableName() + " WHERE ID_STATUS = ?";
        try (Connection conn = connectionFactory.conexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idStatus);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(mapResultSetToEntity(rs));
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Error finding Atendimento by status", e);
        }
        return list;
    }

    public List<Atendimento> findByPrioridade(String prioridade) {
        List<Atendimento> list = new ArrayList<>();
        String sql = "SELECT * FROM " + getTableName() + " WHERE PRIORIDADE = ?";
        try (Connection conn = connectionFactory.conexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, prioridade);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(mapResultSetToEntity(rs));
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Error finding Atendimento by prioridade", e);
        }
        return list;
    }
}
