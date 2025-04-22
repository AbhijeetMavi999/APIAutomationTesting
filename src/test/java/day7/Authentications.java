package day7;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Authentications {

    // Basic Authentication
    @Test
    @Ignore
    void testBasicAuthentication() {
        given()
                .auth().basic("postman", "password")
                .when()
                .get("https://postman-echo.com/bacis-auth")
                .then()
                .statusCode(200)
                .body("authenticated", equalTo(true));
    }

    @Test
    void testBearerTokenAuthentication() {
        String bearerToken = "provide_bearer_token_here";

        given()
                .headers("Authorization", "Bearer "+bearerToken)

                .when()
                .get("provide_url_here")

                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    void testOAuth2Authentication() {
        given()
                .auth().oauth2("provide_oauth2_token_here")
                .when()
                .get("provide_url_here")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    void testAPIKeyAuthentication() {

    }
}
