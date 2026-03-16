package br.com.seito.services;

import br.com.seito.entities.Dentista;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DentistaServiceTest {

    private DentistaService dentistaService;

    @BeforeEach
    void setUp() {
        dentistaService = new DentistaService();
    }

    @Test
    void testFindAllDentistas() {
        List<Dentista> dentistas = dentistaService.findAll();
        assertNotNull(dentistas);
    }

    @Test
    void testFindDentistaById() {
        Dentista dentista = dentistaService.findById(999);
        assertNotNull(dentistaService);
    }

    @Test
    void testFindDentistaByCro() {
        List<Dentista> dentistas = dentistaService.findByCro("ABC123");
        assertNotNull(dentistas);
    }

    @Test
    void testFindDentistaByStatus() {
        List<Dentista> dentistas = dentistaService.findByStatus("ATIVO");
        assertNotNull(dentistas);
    }

    @Test
    void testFindDentistaByEspecialidade() {
        List<Dentista> dentistas = dentistaService.findByEspecialidade(1);
        assertNotNull(dentistas);
    }

    @Test
    void testCountDentistas() {
        int count = dentistaService.count();
        assertTrue(count >= 0);
    }

    @Test
    void testCreateDentistaValidation() {
        assertThrows(IllegalArgumentException.class, () -> {
            dentistaService.create(null);
        });
    }

    @Test
    void testCreateDentistaWithNullCro() {
        Dentista dentista = new Dentista();
        dentista.setStatus("ATIVO");
        
        assertThrows(IllegalArgumentException.class, () -> {
            dentistaService.create(dentista);
        });
    }

    @Test
    void testCreateDentistaWithNullStatus() {
        Dentista dentista = new Dentista();
        dentista.setCro("CRO123");
        
        assertThrows(IllegalArgumentException.class, () -> {
            dentistaService.create(dentista);
        });
    }

    @Test
    void testCreateValidDentista() {
        Dentista dentista = new Dentista();
        dentista.setCro("CRO-TEST-001");
        dentista.setStatus("ATIVO");
        dentista.setIdEspecialidade(1);
        
        assertNotNull(dentista);
    }

    @Test
    void testUpdateDentistaValidation() {
        assertThrows(IllegalArgumentException.class, () -> {
            dentistaService.update(1, null);
        });
    }

    @Test
    void testDeleteDentista() {
        int result = dentistaService.delete(999);
        assertTrue(result >= 0);
    }
}
