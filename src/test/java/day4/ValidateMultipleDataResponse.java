package day4;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ValidateMultipleDataResponse {

    @Test
    void testMultipleJsonResponse() {

        // Approach 1
//        given()
//                .contentType(ContentType.JSON)
//                .when()
//                .get("https://reqres.in/api/users?page=2")
//                .then()
//                .statusCode(200)
//                .body("data[5].last_name", equalTo("Howell"));

        // Approach 2 (Mostly used in Real world project)
        Response response = given().contentType(ContentType.JSON)
                .when()
                .get("https://reqres.in/api/users?page=2");

        JsonPath json = response.jsonPath();

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(json.getString("data[5].last_name"),
                "Howell", "Last name mismatch");
    }
}
