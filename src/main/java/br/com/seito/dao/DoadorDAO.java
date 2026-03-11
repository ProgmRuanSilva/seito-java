package br.com.seito.dao;

import br.com.seito.entities.Doador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoadorDAO extends BaseDAO<Doador> {

    @Override
    protected String getTableName() {
        return "DOADOR";
    }

    @Override
    protected String getIdColumnName() {
        return "ID_DOADOR";
    }

    @Override
    protected String[] getColumnNames() {
        return new String[]{"ID_PESSOA", "CPF_CNPJ", "ID_TIPO_DOACAO", "VALOR_DOACAO", "DATA_DOACAO"};
    }

    @Override
    protected Doador mapResultSetToEntity(ResultSet rs) throws SQLException {
        Doador doador = new Doador();
        doador.setIdPessoa(rs.getInt("ID_PESSOA"));
        doador.setIdDoador(rs.getInt("ID_DOADOR"));
        doador.setCpfCnpj(rs.getString("CPF_CNPJ"));
        doador.setIdTipoDoacao(rs.getInt("ID_TIPO_DOACAO"));
        doador.setValorDoacao(rs.getDouble("VALOR_DOACAO"));
        doador.setDataDoacao(rs.getDate("DATA_DOACAO"));
        return doador;
    }

    @Override
    protected void setEntityParameters(PreparedStatement ps, Doador entity) throws SQLException {
        ps.setInt(1, entity.getIdPessoa());
        ps.setString(2, entity.getCpfCnpj());
        ps.setInt(3, entity.getIdTipoDoacao());
        ps.setDouble(4, entity.getValorDoacao());
        ps.setDate(5, new java.sql.Date(entity.getDataDoacao().getTime()));
    }

    public List<Doador> findByIdTipoDoacao(int idTipoDoacao) {
        List<Doador> list = new ArrayList<>();
        String sql = "SELECT * FROM " + getTableName() + " WHERE ID_TIPO_DOACAO = ?";
        try (Connection conn = connectionFactory.conexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idTipoDoacao);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(mapResultSetToEntity(rs));
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Error finding Doador by tipo doacao", e);
        }
        return list;
    }

    public List<Doador> findByCpfCnpj(String cpfCnpj) {
        List<Doador> list = new ArrayList<>();
        String sql = "SELECT * FROM " + getTableName() + " WHERE CPF_CNPJ = ?";
        try (Connection conn = connectionFactory.conexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cpfCnpj);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(mapResultSetToEntity(rs));
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Error finding Doador by CPF/CNPJ", e);
        }
        return list;
    }
}
