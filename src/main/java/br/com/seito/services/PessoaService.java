package br.com.seito.services;

import br.com.seito.dao.PessoaDAO;
import br.com.seito.entities.Pessoa;
import java.util.List;

public class PessoaService {

    private final PessoaDAO pessoaDAO;

    public PessoaService() {
        this.pessoaDAO = new PessoaDAO();
    }

    public Pessoa findById(int id) {
        return pessoaDAO.findById(id);
    }

    public List<Pessoa> findAll() {
        return pessoaDAO.findAll();
    }

    public List<Pessoa> findByNome(String nome) {
        return pessoaDAO.findByNome(nome);
    }

    public List<Pessoa> findByEmail(String email) {
        return pessoaDAO.findByEmail(email);
    }

    public int create(Pessoa pessoa) {
        validatePessoa(pessoa);
        return pessoaDAO.insert(pessoa);
    }

    public int update(int id, Pessoa pessoa) {
        validatePessoa(pessoa);
        return pessoaDAO.update(pessoa, id);
    }

    public int delete(int id) {
        return pessoaDAO.delete(id);
    }

    public int count() {
        return pessoaDAO.count();
    }

    private void validatePessoa(Pessoa pessoa) {
        if (pessoa == null) {
            throw new IllegalArgumentException("Pessoa cannot be null");
        }
        if (pessoa.getEmail() == null || pessoa.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("Email is required");
        }
        if (pessoa.getNome() == null || pessoa.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome is required");
        }
    }
}
