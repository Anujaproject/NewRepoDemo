package RestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GetRequestExample {
	@Test
    public void testGetRequest() {
        Response res = RestAssured.get("https://reqres.in/api/users?page=2");

        // Print full response
        System.out.println("Response: " + res.asPrettyString());

        // Validate status code
        assertEquals(res.getStatusCode(), 200);
    }
}
