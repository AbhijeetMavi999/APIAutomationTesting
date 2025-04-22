package day2;

import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * Different ways to create POST request body
 * Post request body using Hashmap
 * Post request body creation using org.json
 * using POJO class
 * using external json file data
 */

public class DiffWaysToCreatePostRequestBody {

    // POST request body using org.json library
    @Test
    void testPostUsingJsonLibrary() {
        JSONObject data = new JSONObject();
        data.put("name", "Scott Singh");
        data.put("address", "California");

       given()
                .contentType("application/json")
                .body(data.toString())

                .when()
                .post("http://localhost:8080/employee/")

                .then()
                .body("name", equalTo("Scott Singh"))
                .body("address", equalTo("California"))
//                .header("Content-Type", "application/json; charset=utf-8")
                .statusCode(201)
                .log().all();
    }

    // POST request body using POJO class
//    @Test
//    void testPostUsingJsonLibrary() {
//
//    }
}
