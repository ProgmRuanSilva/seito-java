package br.com.seito.services;

import br.com.seito.dao.AtendimentoDAO;
import br.com.seito.entities.Atendimento;
import java.util.List;

public class AtendimentoService {

    private final AtendimentoDAO atendimentoDAO;

    public AtendimentoService() {
        this.atendimentoDAO = new AtendimentoDAO();
    }

    public Atendimento findById(int id) {
        return atendimentoDAO.findById(id);
    }

    public List<Atendimento> findAll() {
        return atendimentoDAO.findAll();
    }

    public List<Atendimento> findByIdPessoaSolicitante(int idPessoa) {
        return atendimentoDAO.findByIdPessoaSolicitante(idPessoa);
    }

    public List<Atendimento> findByIdPessoaDentista(int idPessoaDentista) {
        return atendimentoDAO.findByIdPessoaDentista(idPessoaDentista);
    }

    public List<Atendimento> findByIdStatus(int idStatus) {
        return atendimentoDAO.findByIdStatus(idStatus);
    }

    public List<Atendimento> findByPrioridade(String prioridade) {
        return atendimentoDAO.findByPrioridade(prioridade);
    }

    public int create(Atendimento atendimento) {
        validateAtendimento(atendimento);
        return atendimentoDAO.insert(atendimento);
    }

    public int update(int id, Atendimento atendimento) {
        validateAtendimento(atendimento);
        return atendimentoDAO.update(atendimento, id);
    }

    public int delete(int id) {
        return atendimentoDAO.delete(id);
    }

    public int count() {
        return atendimentoDAO.count();
    }

    private void validateAtendimento(Atendimento atendimento) {
        if (atendimento == null) {
            throw new IllegalArgumentException("Atendimento cannot be null");
        }
        if (atendimento.getPrioridade() == null || atendimento.getPrioridade().trim().isEmpty()) {
            throw new IllegalArgumentException("Prioridade is required");
        }
        if (atendimento.getIdStatus() <= 0) {
            throw new IllegalArgumentException("ID Status is required");
        }
    }
}
