package RestAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

/*
 given()-prerequest-content type,cookies,add auth,add para,header info
 
 when()-request-get,put,post,delete
 
 then()- validation- status code,extract respons,extract headers cookines ,response body
  
 */
public class HTTPRequest {
	String id;

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
    void CreateUser() {
        Map<String, Object> data = new HashMap<>();
        data.put("name", "anuja");
        data.put("job", "doctor");

        Response response = given()
            .contentType(ContentType.JSON)
            .body(data)
        .when()
            .post("https://reqres.in/api/users");

        response.then().statusCode(201).log().all();

        // Extract string ID
        id = response.jsonPath().getString("id");
        System.out.println("Created User ID: " + id);
    }

    @Test(priority = 3, dependsOnMethods = {"CreateUser"})
    void UpdateUser() {
        HashMap<String, String> data = new HashMap<>();
        data.put("name", "indra");
        data.put("job", "engineer");

        given()
            .contentType("application/json")
            .body(data)
        .when()
            .put("https://reqres.in/api/users/" + id)
        .then()
            .statusCode(200)
            .log().all();
    }

	/*
	 * @Test(priority=4) void DeleteUser() {
	 * 
	 * given()
	 * 
	 * .when() .delete("https://reqres.in/api/users/"+id)
	 * 
	 * .then() .statusCode(204) .log().all(); }
	 */

}
