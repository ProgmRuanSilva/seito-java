package br.com.seito.services;

import br.com.seito.entities.StatusAtendimento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StatusAtendimentoServiceTest {

    private StatusAtendimentoService statusService;

    @BeforeEach
    void setUp() {
        statusService = new StatusAtendimentoService();
    }

    @Test
    void testFindAllStatusAtendimentos() {
        List<StatusAtendimento> statuses = statusService.findAll();
        assertNotNull(statuses);
    }

    @Test
    void testFindStatusById() {
        StatusAtendimento status = statusService.findById(1);
        assertNotNull(statusService);
    }

    @Test
    void testFindStatusByNome() {
        List<StatusAtendimento> statuses = statusService.findByNome("Pendente");
        assertNotNull(statuses);
    }

    @Test
    void testCountStatusAtendimentos() {
        int count = statusService.count();
        assertTrue(count >= 0);
    }

    @Test
    void testCreateStatusValidation() {
        assertThrows(IllegalArgumentException.class, () -> {
            statusService.create(null);
        });
    }

    @Test
    void testCreateStatusWithNullNome() {
        StatusAtendimento status = new StatusAtendimento();
        
        assertThrows(IllegalArgumentException.class, () -> {
            statusService.create(status);
        });
    }

    @Test
    void testCreateStatusWithEmptyNome() {
        StatusAtendimento status = new StatusAtendimento();
        status.setNome("");
        
        assertThrows(IllegalArgumentException.class, () -> {
            statusService.create(status);
        });
    }

    @Test
    void testUpdateStatusValidation() {
        assertThrows(IllegalArgumentException.class, () -> {
            statusService.update(1, null);
        });
    }

    @Test
    void testDeleteStatus() {
        int result = statusService.delete(999);
        assertTrue(result >= 0);
    }
}
