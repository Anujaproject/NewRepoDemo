package RestAssured;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.baseURI ;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetAndPostMethod {

	/*@Test
	public void GetM() {
		baseURI="https://reqres.in/api";	
		
		given()
		     .get("https://reqres.in/api/users?page=2")
		    
		.then()
		     .statusCode(200)
             .body("page", equalTo(2))
            .body("data.email",hasItem("tobias.funke@reqres.in"))
             .log().all();
	}*/
	
	@Test
	public void PostM() {
		    Map<String, Object> request = new HashMap<>();
		    request.put("name", "anuja");
		    request.put("job", "engineer");

		    baseURI = "https://reqres.in/api";

		    given()
		        .contentType(ContentType.JSON)
		        .accept(ContentType.JSON)
		        .body(request)
		    .when()
		        .post("/users")
		    .then()
		        .statusCode(201)
		        .log().all();
		
	}
}
