package br.com.seito.services;

import br.com.seito.dao.StatusAtendimentoDAO;
import br.com.seito.entities.StatusAtendimento;
import java.util.List;

public class StatusAtendimentoService {

    private final StatusAtendimentoDAO statusAtendimentoDAO;

    public StatusAtendimentoService() {
        this.statusAtendimentoDAO = new StatusAtendimentoDAO();
    }

    public StatusAtendimento findById(int id) {
        return statusAtendimentoDAO.findById(id);
    }

    public List<StatusAtendimento> findAll() {
        return statusAtendimentoDAO.findAll();
    }

    public List<StatusAtendimento> findByNome(String nome) {
        return statusAtendimentoDAO.findByNome(nome);
    }

    public int create(StatusAtendimento statusAtendimento) {
        validateStatusAtendimento(statusAtendimento);
        return statusAtendimentoDAO.insert(statusAtendimento);
    }

    public int update(int id, StatusAtendimento statusAtendimento) {
        validateStatusAtendimento(statusAtendimento);
        return statusAtendimentoDAO.update(statusAtendimento, id);
    }

    public int delete(int id) {
        return statusAtendimentoDAO.delete(id);
    }

    public int count() {
        return statusAtendimentoDAO.count();
    }

    private void validateStatusAtendimento(StatusAtendimento statusAtendimento) {
        if (statusAtendimento == null) {
            throw new IllegalArgumentException("StatusAtendimento cannot be null");
        }
        if (statusAtendimento.getNome() == null || statusAtendimento.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome is required");
        }
    }
}
