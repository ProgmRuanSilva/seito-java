package br.com.seito.resources;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

@QuarkusTest
public class BeneficiarioResourceTest {

    @Test
    void testFindAllBeneficiarios() {
        given()
            .when().get("/api/beneficiarios")
            .then()
            .statusCode(200);
    }

    @Test
    void testFindBeneficiarioById() {
        given()
            .when().get("/api/beneficiarios/999")
            .then()
            .statusCode(200);
    }

    @Test
    void testFindBeneficiarioByPrograma() {
        given()
            .when().get("/api/beneficiarios/programa/1")
            .then()
            .statusCode(200);
    }

    @Test
    void testFindBeneficiarioByCriterio() {
        given()
            .when().get("/api/beneficiarios/criterio/1")
            .then()
            .statusCode(200);
    }

    @Test
    void testCountBeneficiarios() {
        given()
            .when().get("/api/beneficiarios/count")
            .then()
            .statusCode(200)
            .body(is(notNullValue()));
    }

    @Test
    void testCreateBeneficiarioValidation() {
        given()
            .contentType("application/json")
            .body("{}")
            .when().post("/api/beneficiarios")
            .then()
            .statusCode(400);
    }
}
