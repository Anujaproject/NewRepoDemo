package RestAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class FirstDemo {
	String id; // To store created user ID

    @Test(priority = 1)
    void getUsers() {
        given()
        .when()
            .get("https://reqres.in/api/users?page=2")
        .then()
            .statusCode(200)
            .body("page", equalTo(2))
            .log().all();
    }

    @Test(priority = 2)
    void createUser() {
        HashMap<String, String> data = new HashMap<>();
        data.put("name", "anuja");
        data.put("job", "doctor");

        Response response = given()
                .contentType(ContentType.JSON)
                .body(data)
        .when()
                .post("https://reqres.in/api/users");

        response.then()
                .statusCode(200)
                .log().all();

        id = response.jsonPath().getString("id");
        System.out.println("Created user ID: " + id);
    }

    @Test(priority = 3, dependsOnMethods = "createUser")
    void updateUser() {
        HashMap<String, String> updateData = new HashMap<>();
        updateData.put("name", "anuja");
        updateData.put("job", "engineer");

        given()
            .contentType(ContentType.JSON)
            .body(updateData)
        .when()
            .put("https://reqres.in/api/users/" + id)
        .then()
            .statusCode(200)
            .body("job", equalTo("engineer"))
            .log().all();
    }

    @Test(priority = 4, dependsOnMethods = "createUser")
    void deleteUser() {
        given()
        .when()
            .delete("https://reqres.in/api/users/" + id)
        .then()
            .statusCode(204)  // 204 No Content = successful delete
            .log().all();
    }
}
