package day9APIChaining;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUser {

    @Test
    void createUser(ITestContext context) {
        Faker faker = new Faker();
        JSONObject  jsonObject = new JSONObject();

        jsonObject.put("name", faker.name().fullName());
        jsonObject.put("gender", "Male");
        jsonObject.put("email", faker.internet().emailAddress());
        jsonObject.put("status", "inactive");

        String bearerToken = "51dd033e994f6f110505b4ffc4412e767286001ab4b0fa23b7ec2c07717beffd";

        int id = given()
                .headers("Authorization", "Bearer "+bearerToken)
                .contentType("application/json")
                .body(jsonObject.toString())

                .when()
                .post("https://gorest.co.in/public/v2/users")
                .jsonPath().getInt("id");

        System.out.println("Response Id: "+id);

        context.setAttribute("user_id", id);
    }
}
