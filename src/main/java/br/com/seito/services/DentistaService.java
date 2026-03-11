package br.com.seito.services;

import br.com.seito.dao.DentistaDAO;
import br.com.seito.entities.Dentista;
import java.util.List;

public class DentistaService {

    private final DentistaDAO dentistaDAO;

    public DentistaService() {
        this.dentistaDAO = new DentistaDAO();
    }

    public Dentista findById(int id) {
        return dentistaDAO.findById(id);
    }

    public List<Dentista> findAll() {
        return dentistaDAO.findAll();
    }

    public List<Dentista> findByEspecialidade(int idEspecialidade) {
        return dentistaDAO.findByIdEspecialidade(idEspecialidade);
    }

    public List<Dentista> findByStatus(String status) {
        return dentistaDAO.findByStatus(status);
    }

    public List<Dentista> findByCro(String cro) {
        return dentistaDAO.findByCro(cro);
    }

    public int create(Dentista dentista) {
        validateDentista(dentista);
        return dentistaDAO.insert(dentista);
    }

    public int update(int id, Dentista dentista) {
        validateDentista(dentista);
        return dentistaDAO.update(dentista, id);
    }

    public int delete(int id) {
        return dentistaDAO.delete(id);
    }

    public int count() {
        return dentistaDAO.count();
    }

    private void validateDentista(Dentista dentista) {
        if (dentista == null) {
            throw new IllegalArgumentException("Dentista cannot be null");
        }
        if (dentista.getCro() == null || dentista.getCro().trim().isEmpty()) {
            throw new IllegalArgumentException("CRO is required");
        }
        if (dentista.getStatus() == null || dentista.getStatus().trim().isEmpty()) {
            throw new IllegalArgumentException("Status is required");
        }
    }
}
