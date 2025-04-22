package day9APIChaining;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetUser {

    @Test
    void getUser(ITestContext context) {
        String bearerToken = "51dd033e994f6f110505b4ffc4412e767286001ab4b0fa23b7ec2c07717beffd";
        int id = (Integer) context.getAttribute("user_id");         // this will come from CreateUser

        given()
                .headers("Authorization", "Bearer "+bearerToken)
                .pathParams("id", id)
                .when()
                .get("https://gorest.co.in/public/v2/users/{id}")

                .then()
                .statusCode(200)
                .log().all();
    }
}
