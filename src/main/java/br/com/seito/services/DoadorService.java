package br.com.seito.services;

import br.com.seito.dao.DoadorDAO;
import br.com.seito.entities.Doador;
import java.util.List;

public class DoadorService {

    private final DoadorDAO doadorDAO;

    public DoadorService() {
        this.doadorDAO = new DoadorDAO();
    }

    public Doador findById(int id) {
        return doadorDAO.findById(id);
    }

    public List<Doador> findAll() {
        return doadorDAO.findAll();
    }

    public List<Doador> findByIdTipoDoacao(int idTipoDoacao) {
        return doadorDAO.findByIdTipoDoacao(idTipoDoacao);
    }

    public List<Doador> findByCpfCnpj(String cpfCnpj) {
        return doadorDAO.findByCpfCnpj(cpfCnpj);
    }

    public int create(Doador doador) {
        validateDoador(doador);
        return doadorDAO.insert(doador);
    }

    public int update(int id, Doador doador) {
        validateDoador(doador);
        return doadorDAO.update(doador, id);
    }

    public int delete(int id) {
        return doadorDAO.delete(id);
    }

    public int count() {
        return doadorDAO.count();
    }

    private void validateDoador(Doador doador) {
        if (doador == null) {
            throw new IllegalArgumentException("Doador cannot be null");
        }
        if (doador.getCpfCnpj() == null || doador.getCpfCnpj().trim().isEmpty()) {
            throw new IllegalArgumentException("CPF/CNPJ is required");
        }
        if (doador.getIdTipoDoacao() <= 0) {
            throw new IllegalArgumentException("ID Tipo Doacao is required");
        }
    }
}
