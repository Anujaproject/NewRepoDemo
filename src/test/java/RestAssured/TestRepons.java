package RestAssured;

import io.restassured.RestAssured;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TestRepons {
	@Test(priority = 1)
	void getUsers() {
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");

		System.out.println("Status Line: " + response.getStatusLine());
		System.out.println("Status Code: " + response.getStatusCode());
		System.out.println("Response Time: " + response.getTime());
		System.out.println("Body: " + response.getBody().asString());
	}

}
