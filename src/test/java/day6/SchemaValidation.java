package day6;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SchemaValidation {

    @Test
    void jsconSchemaValidation() {
        given()

                .when()
                .get("https://petstore.swagger.io/v2/store/inventory")

                .then()
                .assertThat().body(JsonSchemaValidator
                        .matchesJsonSchemaInClasspath("JsonSchema.json"));
    }
}
