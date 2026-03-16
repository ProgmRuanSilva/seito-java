package br.com.seito.resources;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

@QuarkusTest
public class DentistaResourceTest {

    @Test
    void testFindAllDentistas() {
        given()
            .when().get("/api/dentistas")
            .then()
            .statusCode(200);
    }

    @Test
    void testFindDentistaById() {
        given()
            .when().get("/api/dentistas/999")
            .then()
            .statusCode(200);
    }

    @Test
    void testFindDentistaByCro() {
        given()
            .when().get("/api/dentistas/cro/ABC123")
            .then()
            .statusCode(200);
    }

    @Test
    void testFindDentistaByStatus() {
        given()
            .when().get("/api/dentistas/status/ATIVO")
            .then()
            .statusCode(200);
    }

    @Test
    void testFindDentistaByEspecialidade() {
        given()
            .when().get("/api/dentistas/especialidade/1")
            .then()
            .statusCode(200);
    }

    @Test
    void testCountDentistas() {
        given()
            .when().get("/api/dentistas/count")
            .then()
            .statusCode(200)
            .body(is(notNullValue()));
    }

    @Test
    void testCreateDentistaValidation() {
        given()
            .contentType("application/json")
            .body("{}")
            .when().post("/api/dentistas")
            .then()
            .statusCode(400);
    }
}
