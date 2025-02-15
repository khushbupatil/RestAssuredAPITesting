package apiTesting;
import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

public class HTTPGetRequest {
	String id;
	
	@Test(priority=1)
	public void getUsers() {
		
		given()
		.when().get("https://api.restful-api.dev/objects/1")
		.then().statusCode(200).log().all();
	}
	
	@Test(priority=2)
	public void createUser() {
		
		HashMap<String, String> data = new HashMap<>();
		data.put("name", "Anshul");
		data.put("job", "Trainer");
		
		id = given().contentType("Application/json").body(data)
		.when().post("https://api.restful-api.dev/objects").jsonPath().get("id");
	
	}
	
	@Test(priority=3, dependsOnMethods = {"createUser"})
	public void updateUser() {
	
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("name", "kishor");
		data.put("job", "Teacher");
		
		given().contentType("Application/json").body(data)
		.when().put("https://api.restful-api.dev/objects/"+id).jsonPath().get("id");
	}
	
	@Test
	public void deleteUser() {
		given()
		.when().delete("https://api.restful-api.dev/objects/"+id)
		.then().statusCode(200);
	}
}
