package RestAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class PostRequestExample {

	@Test
    public void testCreateUser() {
		Map<String, Object> request = new HashMap<>();
	    request.put("name", "Anuja");
	    request.put("job", "QA Engineer");

	    given()
	        .baseUri("https://reqres.in")
	        .contentType(ContentType.JSON)
	        .body(request)
	    .when()
	        .post("/api/users")
	    .then()
	        .statusCode(201)
	        .body("name", equalTo("Anuja"))
	        .body("job", equalTo("QA Engineer"))
	        .log().all();
    }
}
