package br.com.seito.dao;

import br.com.seito.factories.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Abstract base class for all DAOs providing common CRUD operations.
 * Uses the existing ConnectionFactory for database connections.
 */
public abstract class BaseDAO<T> {

    protected ConnectionFactory connectionFactory;

    public BaseDAO() {
        this.connectionFactory = new ConnectionFactory();
    }

    /**
     * Returns the table name for the entity.
     */
    protected abstract String getTableName();

    /**
     * Maps a ResultSet to an entity object.
     */
    protected abstract T mapResultSetToEntity(ResultSet rs) throws SQLException;

    /**
     * Returns the column names for insert/update operations.
     */
    protected abstract String[] getColumnNames();

    /**
     * Sets the parameters for a prepared statement for insert/update.
     */
    protected abstract void setEntityParameters(PreparedStatement ps, T entity) throws SQLException;

    /**
     * Returns the ID column name for the entity.
     */
    protected abstract String getIdColumnName();

    /**
     * Finds an entity by ID.
     */
    public T findById(int id) {
        String sql = "SELECT * FROM " + getTableName() + " WHERE " + getIdColumnName() + " = ?";
        try (Connection conn = connectionFactory.conexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToEntity(rs);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Error finding entity by ID: " + id, e);
        }
        return null;
    }

    /**
     * Finds all entities.
     */
    public List<T> findAll() {
        List<T> entities = new ArrayList<>();
        String sql = "SELECT * FROM " + getTableName();
        try (Connection conn = connectionFactory.conexao();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                entities.add(mapResultSetToEntity(rs));
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Error finding all entities", e);
        }
        return entities;
    }

    /**
     * Inserts a new entity.
     */
    public int insert(T entity) {
        String[] columns = getColumnNames();
        String columnNames = String.join(", ", columns);
        String placeholders = String.join(", ", java.util.Collections.nCopies(columns.length, "?"));
        String sql = "INSERT INTO " + getTableName() + " (" + columnNames + ") VALUES (" + placeholders + ")";
        
        try (Connection conn = connectionFactory.conexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            setEntityParameters(ps, entity);
            return ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Error inserting entity", e);
        }
    }

    /**
     * Updates an existing entity.
     */
    public int update(T entity, int id) {
        String[] columns = getColumnNames();
        StringBuilder setClause = new StringBuilder();
        for (int i = 0; i < columns.length; i++) {
            setClause.append(columns[i]).append(" = ?");
            if (i < columns.length - 1) {
                setClause.append(", ");
            }
        }
        String sql = "UPDATE " + getTableName() + " SET " + setClause + " WHERE " + getIdColumnName() + " = ?";
        
        try (Connection conn = connectionFactory.conexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            setEntityParameters(ps, entity);
            ps.setInt(columns.length + 1, id);
            return ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Error updating entity", e);
        }
    }

    /**
     * Deletes an entity by ID.
     */
    public int delete(int id) {
        String sql = "DELETE FROM " + getTableName() + " WHERE " + getIdColumnName() + " = ?";
        try (Connection conn = connectionFactory.conexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Error deleting entity", e);
        }
    }

    /**
     * Counts all entities.
     */
    public int count() {
        String sql = "SELECT COUNT(*) FROM " + getTableName();
        try (Connection conn = connectionFactory.conexao();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Error counting entities", e);
        }
        return 0;
    }
}
