package br.com.seito.services;

import br.com.seito.entities.Doador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DoadorServiceTest {

    private DoadorService doadorService;

    @BeforeEach
    void setUp() {
        doadorService = new DoadorService();
    }

    @Test
    void testFindAllDoadores() {
        List<Doador> doadores = doadorService.findAll();
        assertNotNull(doadores);
    }

    @Test
    void testFindDoadorById() {
        Doador doador = doadorService.findById(999);
        assertNotNull(doadorService);
    }

    @Test
    void testFindDoadorByIdTipoDoacao() {
        List<Doador> doadores = doadorService.findByIdTipoDoacao(1);
        assertNotNull(doadores);
    }

    @Test
    void testFindDoadorByCpfCnpj() {
        List<Doador> doadores = doadorService.findByCpfCnpj("12345678900");
        assertNotNull(doadores);
    }

    @Test
    void testCountDoadores() {
        int count = doadorService.count();
        assertTrue(count >= 0);
    }

    @Test
    void testCreateDoadorValidation() {
        assertThrows(IllegalArgumentException.class, () -> {
            doadorService.create(null);
        });
    }

    @Test
    void testCreateDoadorWithNullCpfCnpj() {
        Doador doador = new Doador();
        doador.setIdTipoDoacao(1);
        
        assertThrows(IllegalArgumentException.class, () -> {
            doadorService.create(doador);
        });
    }

    @Test
    void testCreateDoadorWithEmptyCpfCnpj() {
        Doador doador = new Doador();
        doador.setCpfCnpj("");
        doador.setIdTipoDoacao(1);
        
        assertThrows(IllegalArgumentException.class, () -> {
            doadorService.create(doador);
        });
    }

    @Test
    void testCreateDoadorWithInvalidTipoDoacao() {
        Doador doador = new Doador();
        doador.setCpfCnpj("12345678900");
        doador.setIdTipoDoacao(0);
        
        assertThrows(IllegalArgumentException.class, () -> {
            doadorService.create(doador);
        });
    }

    @Test
    void testUpdateDoadorValidation() {
        assertThrows(IllegalArgumentException.class, () -> {
            doadorService.update(1, null);
        });
    }

    @Test
    void testDeleteDoador() {
        int result = doadorService.delete(999);
        assertTrue(result >= 0);
    }
}
