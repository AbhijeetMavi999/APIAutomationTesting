package day3;

import io.restassured.response.Response;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class CookiesDemo {

    @Test(priority = 1)
    @Ignore
    void catchCookies() {
        given()

                .when()
                .get("https://www.google.com/")

                .then()
                .cookie("AEC", "AVcja2dnghsv0HFZ8GHEDF-gnWnfSipoD1tjDE0yG6qgOsMvUcJ90Xf5ew\n")
//                .cookie("NID", "523%3Daoh05AGWw1-88EEJLZ5q3RNLIxXvvstebQlPpjcYWgpoEraNKHarpTfB1hYGDa8mgxiJn5nhsbPZB386RfwNJSTa__rp7rPa3Leylp6kK4CINpoFlGpCzPSwf9PCEQ7Dl6nMO6S1H09WAYgEBekAhXnT4RP2vRl96hJgiGlvwkPSXPMSGOBu_VOU8sKkM2xLy-mElaJrpu5IBHyVYOnGq9KV34PF_z6W4eIo8yIt2bYLmts\n")
                .log().all();
    }

    @Test(priority = 2)
    void getCookiesInfo() {
        Response cookiesInfo = given()
                .when()
                .get("https://www.google.com/");

        // Getting info of single cookie
        System.out.println(cookiesInfo.getCookie("AEC"));

        // Get all cookies info
        Map<String, String> cookies = cookiesInfo.getCookies();
        System.out.println(cookies);
    }
}
