package br.com.seito.services;

import br.com.seito.entities.Pessoa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PessoaServiceTest {

    private PessoaService pessoaService;

    @BeforeEach
    void setUp() {
        pessoaService = new PessoaService();
    }

    @Test
    void testFindAllPessoas() {
        List<Pessoa> pessoas = pessoaService.findAll();
        assertNotNull(pessoas);
    }

    @Test
    void testFindPessoaById() {
        Pessoa pessoa = pessoaService.findById(999);
        assertNotNull(pessoaService);
    }

    @Test
    void testFindPessoaByNome() {
        List<Pessoa> pessoas = pessoaService.findByNome("Joao");
        assertNotNull(pessoas);
    }

    @Test
    void testFindPessoaByEmail() {
        List<Pessoa> pessoas = pessoaService.findByEmail("teste@email.com");
        assertNotNull(pessoas);
    }

    @Test
    void testCountPessoas() {
        int count = pessoaService.count();
        assertTrue(count >= 0);
    }

    @Test
    void testCreatePessoaValidation() {
        assertThrows(IllegalArgumentException.class, () -> {
            pessoaService.create(null);
        });
    }

    @Test
    void testCreatePessoaWithNullEmail() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Joao Silva");
        
        assertThrows(IllegalArgumentException.class, () -> {
            pessoaService.create(pessoa);
        });
    }

    @Test
    void testCreatePessoaWithEmptyEmail() {
        Pessoa pessoa = new Pessoa();
        pessoa.setEmail("");
        pessoa.setNome("Joao Silva");
        
        assertThrows(IllegalArgumentException.class, () -> {
            pessoaService.create(pessoa);
        });
    }

    @Test
    void testCreatePessoaWithNullNome() {
        Pessoa pessoa = new Pessoa();
        pessoa.setEmail("teste@email.com");
        
        assertThrows(IllegalArgumentException.class, () -> {
            pessoaService.create(pessoa);
        });
    }

    @Test
    void testCreatePessoaWithEmptyNome() {
        Pessoa pessoa = new Pessoa();
        pessoa.setEmail("teste@email.com");
        pessoa.setNome("");
        
        assertThrows(IllegalArgumentException.class, () -> {
            pessoaService.create(pessoa);
        });
    }

    @Test
    void testUpdatePessoaValidation() {
        assertThrows(IllegalArgumentException.class, () -> {
            pessoaService.update(1, null);
        });
    }

    @Test
    void testDeletePessoa() {
        int result = pessoaService.delete(999);
        assertTrue(result >= 0);
    }
}
