package br.com.seito.resources;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

@QuarkusTest
public class PessoaResourceTest {

    @Test
    void testFindAllPessoas() {
        given()
            .when().get("/api/pessoas")
            .then()
            .statusCode(200);
    }

    @Test
    void testFindPessoaById() {
        given()
            .when().get("/api/pessoas/999")
            .then()
            .statusCode(200);
    }

    @Test
    void testFindPessoaByNome() {
        given()
            .when().get("/api/pessoas/nome/Joao")
            .then()
            .statusCode(200);
    }

    @Test
    void testFindPessoaByEmail() {
        given()
            .when().get("/api/pessoas/email/teste@email.com")
            .then()
            .statusCode(200);
    }

    @Test
    void testCountPessoas() {
        given()
            .when().get("/api/pessoas/count")
            .then()
            .statusCode(200)
            .body(is(notNullValue()));
    }

    @Test
    void testCreatePessoaValidation() {
        given()
            .contentType("application/json")
            .body("{}")
            .when().post("/api/pessoas")
            .then()
            .statusCode(400);
    }
}
