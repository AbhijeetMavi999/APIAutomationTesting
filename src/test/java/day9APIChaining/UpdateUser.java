package day9APIChaining;

import com.github.javafaker.Faker;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdateUser {

    @Test
    void updateUser(ITestContext context) {
        Faker faker = new Faker();
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("name", faker.name().fullName());
        jsonObject.put("gender", "Female");
        jsonObject.put("email", faker.internet().emailAddress());
        jsonObject.put("status", "active");

        String bearerToken = "51dd033e994f6f110505b4ffc4412e767286001ab4b0fa23b7ec2c07717beffd";
        int id = (Integer) context.getAttribute("user_id");

        given()
                .headers("Authorization", "Bearer "+bearerToken)
                .contentType("application/json")
                .pathParams("id", id)
                .body(jsonObject.toString())

                .when()
                .put("https://gorest.co.in/public/v2/users/{id}")
                .then()
                .statusCode(200)
                .log().all();
    }
}
