package br.com.seito.services;

import br.com.seito.dao.TipoDoacaoDAO;
import br.com.seito.entities.TipoDoacao;
import java.util.List;

public class TipoDoacaoService {

    private final TipoDoacaoDAO tipoDoacaoDAO;

    public TipoDoacaoService() {
        this.tipoDoacaoDAO = new TipoDoacaoDAO();
    }

    public TipoDoacao findById(int id) {
        return tipoDoacaoDAO.findById(id);
    }

    public List<TipoDoacao> findAll() {
        return tipoDoacaoDAO.findAll();
    }

    public List<TipoDoacao> findByNome(String nome) {
        return tipoDoacaoDAO.findByNome(nome);
    }

    public int create(TipoDoacao tipoDoacao) {
        validateTipoDoacao(tipoDoacao);
        return tipoDoacaoDAO.insert(tipoDoacao);
    }

    public int update(int id, TipoDoacao tipoDoacao) {
        validateTipoDoacao(tipoDoacao);
        return tipoDoacaoDAO.update(tipoDoacao, id);
    }

    public int delete(int id) {
        return tipoDoacaoDAO.delete(id);
    }

    public int count() {
        return tipoDoacaoDAO.count();
    }

    private void validateTipoDoacao(TipoDoacao tipoDoacao) {
        if (tipoDoacao == null) {
            throw new IllegalArgumentException("TipoDoacao cannot be null");
        }
        if (tipoDoacao.getNome() == null || tipoDoacao.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome is required");
        }
    }
}
