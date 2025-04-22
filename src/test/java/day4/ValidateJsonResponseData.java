package day4;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ValidateJsonResponseData {

    @Test(priority = 1)
    void testJsonResponse() {

        given()
                .contentType("ContentType.JSON")

                .when()
                .get("https://reqres.in/api/users/2")

                .then()
                .statusCode(200)
                .header("Content-Type", "application/json; charset=utf-8")
                .body("data.email", equalTo("janet.weaver@reqres.in"))
                .body("data.last_name", equalTo("Weaver"))
                .body("support.url", equalTo("https://contentcaddy.io?utm_source=reqres&utm_medium=json&utm_campaign=referral"))
                .log().body();

    }
}
