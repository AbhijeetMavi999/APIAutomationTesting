package com.day1;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/**
 * given() = Defines the pre-conditions like headers, query params, request body, etc.
 * when() = Specifies the action or HTTP method (GET, POST, PUT, DELETE).
 * then() = Used to write the assertions and validate the response.
 */

public class HttpRequests {

    private int id;

    @Test(priority = 3)
    void getUsers() {
        given()

                .when()
                        .get("https://reqres.in/api/users?page=2")

                .then()
                .statusCode(200)
                .body("page", equalTo(2))
                .log().all();
    }

    @Test(priority = 1)
    void createUser() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Pawan");
        map.put("job", "Trainer");

        id = given()
                .contentType("application/json ").body(map)

                .when()
                .post("https://reqres.in/api/users")
                .jsonPath().getInt("id");

//                .then()
//                .statusCode(201)
//                .log().all();
    }

    @Test(priority = 2, dependsOnMethods = {"createUser"})
    void updateUser() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Arjuna");
        map.put("job", "Trainer");

        given()
                .contentType("application/json ").body(map)

                .when()
                .put("https://reqres.in/api/users/" + id)

                .then()
                .statusCode(200)
                .log().all();
    }

    @Test(priority = 4)
    void deleteUser() {
        given()

                .when()
                .delete("https://reqres.in/api/users/"+id)

                .then().statusCode(204)
                .log().all();
    }
}
