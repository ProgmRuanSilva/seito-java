package br.com.seito.services;

import br.com.seito.entities.Beneficiario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BeneficiarioServiceTest {

    private BeneficiarioService beneficiarioService;

    @BeforeEach
    void setUp() {
        beneficiarioService = new BeneficiarioService();
    }

    @Test
    void testFindAllBeneficiarios() {
        List<Beneficiario> beneficiarios = beneficiarioService.findAll();
        assertNotNull(beneficiarios);
    }

    @Test
    void testFindBeneficiarioById() {
        Beneficiario beneficiario = beneficiarioService.findById(999);
        assertNotNull(beneficiarioService);
    }

    @Test
    void testFindBeneficiarioByIdPrograma() {
        List<Beneficiario> beneficiarios = beneficiarioService.findByIdPrograma(1);
        assertNotNull(beneficiarios);
    }

    @Test
    void testFindBeneficiarioByIdCriterio() {
        List<Beneficiario> beneficiarios = beneficiarioService.findByIdCriterio(1);
        assertNotNull(beneficiarios);
    }

    @Test
    void testCountBeneficiarios() {
        int count = beneficiarioService.count();
        assertTrue(count >= 0);
    }

    @Test
    void testCreateBeneficiarioValidation() {
        assertThrows(IllegalArgumentException.class, () -> {
            beneficiarioService.create(null);
        });
    }

    @Test
    void testCreateBeneficiarioWithNullTratamento() {
        Beneficiario beneficiario = new Beneficiario();
        beneficiario.setIdPrograma(1);
        beneficiario.setIdCriterio(1);
        
        assertThrows(IllegalArgumentException.class, () -> {
            beneficiarioService.create(beneficiario);
        });
    }

    @Test
    void testCreateBeneficiarioWithInvalidPrograma() {
        Beneficiario beneficiario = new Beneficiario();
        beneficiario.setTratamento("Tratamento A");
        beneficiario.setIdPrograma(0);
        
        assertThrows(IllegalArgumentException.class, () -> {
            beneficiarioService.create(beneficiario);
        });
    }

    @Test
    void testCreateBeneficiarioWithInvalidCriterio() {
        Beneficiario beneficiario = new Beneficiario();
        beneficiario.setTratamento("Tratamento A");
        beneficiario.setIdPrograma(1);
        beneficiario.setIdCriterio(0);
        
        assertThrows(IllegalArgumentException.class, () -> {
            beneficiarioService.create(beneficiario);
        });
    }

    @Test
    void testUpdateBeneficiarioValidation() {
        assertThrows(IllegalArgumentException.class, () -> {
            beneficiarioService.update(1, null);
        });
    }

    @Test
    void testDeleteBeneficiario() {
        int result = beneficiarioService.delete(999);
        assertTrue(result >= 0);
    }
}
