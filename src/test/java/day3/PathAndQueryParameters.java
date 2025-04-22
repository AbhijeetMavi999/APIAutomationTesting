package day3;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathAndQueryParameters {

    @Test
    void testQueryAndPathParameters() {
        given()
                .pathParams("mypath", "users")      // path parameters
                .queryParam("page", 2)      // query parameters
                .queryParam("id", 5)        // query parameters

                .when()
                .get("https://reqres.in/api/{mypath}")

                .then()
                .statusCode(200)
                .log().all();
    }
}
