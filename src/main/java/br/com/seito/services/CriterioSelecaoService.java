package br.com.seito.services;

import br.com.seito.dao.CriterioSelecaoDAO;
import br.com.seito.entities.CriterioSelecao;
import java.util.List;

public class CriterioSelecaoService {

    private final CriterioSelecaoDAO criterioSelecaoDAO;

    public CriterioSelecaoService() {
        this.criterioSelecaoDAO = new CriterioSelecaoDAO();
    }

    public CriterioSelecao findById(int id) {
        return criterioSelecaoDAO.findById(id);
    }

    public List<CriterioSelecao> findAll() {
        return criterioSelecaoDAO.findAll();
    }

    public List<CriterioSelecao> findByNome(String nome) {
        return criterioSelecaoDAO.findByNome(nome);
    }

    public int create(CriterioSelecao criterioSelecao) {
        validateCriterioSelecao(criterioSelecao);
        return criterioSelecaoDAO.insert(criterioSelecao);
    }

    public int update(int id, CriterioSelecao criterioSelecao) {
        validateCriterioSelecao(criterioSelecao);
        return criterioSelecaoDAO.update(criterioSelecao, id);
    }

    public int delete(int id) {
        return criterioSelecaoDAO.delete(id);
    }

    public int count() {
        return criterioSelecaoDAO.count();
    }

    private void validateCriterioSelecao(CriterioSelecao criterioSelecao) {
        if (criterioSelecao == null) {
            throw new IllegalArgumentException("CriterioSelecao cannot be null");
        }
        if (criterioSelecao.getNome() == null || criterioSelecao.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome is required");
        }
    }
}
