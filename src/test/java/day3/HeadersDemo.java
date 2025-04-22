package day3;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class HeadersDemo {

    @Test(priority = 1)
    @Ignore
    void catchHeaders() {
        given()

                .when()
                .get("https://www.google.com/")

                .then()
                .header("Content-Type", "text/html; charset=ISO-8859-1")
                .header("Content-Encoding", "gzip")
                .header("Server", "gws")
                .log().all();
    }

    @Test(priority = 1)
    void getHeadersInfo() {
        Response response = given()

                .when()
                .get("https://www.google.com/");

        // Get a specific header info
        System.out.println("Content-Type: "+response.getHeader("Content-Type"));

        // Get all header info
        Headers headersInfo = response.getHeaders();
        for(Header header: headersInfo) {
            System.out.println(header.getName()+"   :   "+header.getValue());
        }
    }
}
