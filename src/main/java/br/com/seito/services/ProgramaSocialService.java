package br.com.seito.services;

import br.com.seito.dao.ProgramaSocialDAO;
import br.com.seito.entities.ProgramaSocial;
import java.util.List;

public class ProgramaSocialService {

    private final ProgramaSocialDAO programaSocialDAO;

    public ProgramaSocialService() {
        this.programaSocialDAO = new ProgramaSocialDAO();
    }

    public ProgramaSocial findById(int id) {
        return programaSocialDAO.findById(id);
    }

    public List<ProgramaSocial> findAll() {
        return programaSocialDAO.findAll();
    }

    public List<ProgramaSocial> findByNome(String nome) {
        return programaSocialDAO.findByNome(nome);
    }

    public List<ProgramaSocial> findByIdade(int idade) {
        return programaSocialDAO.findByIdade(idade);
    }

    public int create(ProgramaSocial programaSocial) {
        validateProgramaSocial(programaSocial);
        return programaSocialDAO.insert(programaSocial);
    }

    public int update(int id, ProgramaSocial programaSocial) {
        validateProgramaSocial(programaSocial);
        return programaSocialDAO.update(programaSocial, id);
    }

    public int delete(int id) {
        return programaSocialDAO.delete(id);
    }

    public int count() {
        return programaSocialDAO.count();
    }

    private void validateProgramaSocial(ProgramaSocial programaSocial) {
        if (programaSocial == null) {
            throw new IllegalArgumentException("ProgramaSocial cannot be null");
        }
        if (programaSocial.getNome() == null || programaSocial.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome is required");
        }
        if (programaSocial.getIdadeMinima() < 0) {
            throw new IllegalArgumentException("Idade minima cannot be negative");
        }
        if (programaSocial.getIdadeMaxima() < 0) {
            throw new IllegalArgumentException("Idade maxima cannot be negative");
        }
        if (programaSocial.getIdadeMinima() > programaSocial.getIdadeMaxima()) {
            throw new IllegalArgumentException("Idade minima cannot be greater than idade maxima");
        }
    }
}
