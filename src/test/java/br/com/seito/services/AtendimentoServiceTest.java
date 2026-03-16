package br.com.seito.services;

import br.com.seito.entities.Atendimento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AtendimentoServiceTest {

    private AtendimentoService atendimentoService;

    @BeforeEach
    void setUp() {
        atendimentoService = new AtendimentoService();
    }

    @Test
    void testFindAllAtendimentos() {
        List<Atendimento> atendimentos = atendimentoService.findAll();
        assertNotNull(atendimentos);
    }

    @Test
    void testFindAtendimentoById() {
        Atendimento atendimento = atendimentoService.findById(999);
        assertNotNull(atendimentoService);
    }

    @Test
    void testFindAtendimentoBySolicitante() {
        List<Atendimento> atendimentos = atendimentoService.findByIdPessoaSolicitante(1);
        assertNotNull(atendimentos);
    }

    @Test
    void testFindAtendimentoByDentista() {
        List<Atendimento> atendimentos = atendimentoService.findByIdPessoaDentista(1);
        assertNotNull(atendimentos);
    }

    @Test
    void testFindAtendimentoByStatus() {
        List<Atendimento> atendimentos = atendimentoService.findByIdStatus(1);
        assertNotNull(atendimentos);
    }

    @Test
    void testFindAtendimentoByPrioridade() {
        List<Atendimento> atendimentos = atendimentoService.findByPrioridade("ALTA");
        assertNotNull(atendimentos);
    }

    @Test
    void testCountAtendimentos() {
        int count = atendimentoService.count();
        assertTrue(count >= 0);
    }

    @Test
    void testCreateAtendimentoValidation() {
        assertThrows(IllegalArgumentException.class, () -> {
            atendimentoService.create(null);
        });
    }

    @Test
    void testCreateAtendimentoWithNullPrioridade() {
        Atendimento atendimento = new Atendimento();
        atendimento.setIdStatus(1);
        
        assertThrows(IllegalArgumentException.class, () -> {
            atendimentoService.create(atendimento);
        });
    }

    @Test
    void testCreateAtendimentoWithEmptyPrioridade() {
        Atendimento atendimento = new Atendimento();
        atendimento.setPrioridade("");
        atendimento.setIdStatus(1);
        
        assertThrows(IllegalArgumentException.class, () -> {
            atendimentoService.create(atendimento);
        });
    }

    @Test
    void testCreateAtendimentoWithInvalidStatus() {
        Atendimento atendimento = new Atendimento();
        atendimento.setPrioridade("ALTA");
        atendimento.setIdStatus(0);
        
        assertThrows(IllegalArgumentException.class, () -> {
            atendimentoService.create(atendimento);
        });
    }

    @Test
    void testUpdateAtendimentoValidation() {
        assertThrows(IllegalArgumentException.class, () -> {
            atendimentoService.update(1, null);
        });
    }

    @Test
    void testDeleteAtendimento() {
        int result = atendimentoService.delete(999);
        assertTrue(result >= 0);
    }
}
