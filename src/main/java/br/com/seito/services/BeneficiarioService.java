package br.com.seito.services;

import br.com.seito.dao.BeneficiarioDAO;
import br.com.seito.entities.Beneficiario;
import java.util.List;

public class BeneficiarioService {

    private final BeneficiarioDAO beneficiarioDAO;

    public BeneficiarioService() {
        this.beneficiarioDAO = new BeneficiarioDAO();
    }

    public Beneficiario findById(int id) {
        return beneficiarioDAO.findById(id);
    }

    public List<Beneficiario> findAll() {
        return beneficiarioDAO.findAll();
    }

    public List<Beneficiario> findByIdPrograma(int idPrograma) {
        return beneficiarioDAO.findByIdPrograma(idPrograma);
    }

    public List<Beneficiario> findByIdCriterio(int idCriterio) {
        return beneficiarioDAO.findByIdCriterio(idCriterio);
    }

    public int create(Beneficiario beneficiario) {
        validateBeneficiario(beneficiario);
        return beneficiarioDAO.insert(beneficiario);
    }

    public int update(int id, Beneficiario beneficiario) {
        validateBeneficiario(beneficiario);
        return beneficiarioDAO.update(beneficiario, id);
    }

    public int delete(int id) {
        return beneficiarioDAO.delete(id);
    }

    public int count() {
        return beneficiarioDAO.count();
    }

    private void validateBeneficiario(Beneficiario beneficiario) {
        if (beneficiario == null) {
            throw new IllegalArgumentException("Beneficiario cannot be null");
        }
        if (beneficiario.getTratamento() == null || beneficiario.getTratamento().trim().isEmpty()) {
            throw new IllegalArgumentException("Tratamento is required");
        }
        if (beneficiario.getIdPrograma() <= 0) {
            throw new IllegalArgumentException("ID Programa is required");
        }
        if (beneficiario.getIdCriterio() <= 0) {
            throw new IllegalArgumentException("ID Criterio is required");
        }
    }
}
