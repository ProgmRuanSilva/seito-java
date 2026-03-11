package br.com.seito.dao;

import br.com.seito.entities.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO extends BaseDAO<Pessoa> {

    @Override
    protected String getTableName() {
        return "PESSOA";
    }

    @Override
    protected String getIdColumnName() {
        return "ID_PESSOA";
    }

    @Override
    protected String[] getColumnNames() {
        return new String[]{"EMAIL", "NOME", "TELEFONE", "LOGRADOURO", "DATA_CADASTRO"};
    }

    @Override
    protected Pessoa mapResultSetToEntity(ResultSet rs) throws SQLException {
        Pessoa pessoa = new Pessoa();
        pessoa.setIdPessoa(rs.getInt("ID_PESSOA"));
        pessoa.setEmail(rs.getString("EMAIL"));
        pessoa.setNome(rs.getString("NOME"));
        pessoa.setTelefone(rs.getString("TELEFONE"));
        pessoa.setLogradouro(rs.getString("LOGRADOURO"));
        pessoa.setDataCadastro(rs.getDate("DATA_CADASTRO"));
        return pessoa;
    }

    @Override
    protected void setEntityParameters(PreparedStatement ps, Pessoa pessoa) throws SQLException {
        ps.setString(1, pessoa.getEmail());
        ps.setString(2, pessoa.getNome());
        ps.setString(3, pessoa.getTelefone());
        ps.setString(4, pessoa.getLogradouro());
        ps.setDate(5, new java.sql.Date(pessoa.getDataCadastro().getTime()));
    }

    public List<Pessoa> findByNome(String nome) {
        List<Pessoa> pessoas = new ArrayList<>();
        String sql = "SELECT * FROM " + getTableName() + " WHERE NOME LIKE ?";
        try (Connection conn = connectionFactory.conexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + nome + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    pessoas.add(mapResultSetToEntity(rs));
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Error finding pessoas by nome", e);
        }
        return pessoas;
    }

    public List<Pessoa> findByEmail(String email) {
        List<Pessoa> pessoas = new ArrayList<>();
        String sql = "SELECT * FROM " + getTableName() + " WHERE EMAIL = ?";
        try (Connection conn = connectionFactory.conexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    pessoas.add(mapResultSetToEntity(rs));
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Error finding pessoas by email", e);
        }
        return pessoas;
    }
}
