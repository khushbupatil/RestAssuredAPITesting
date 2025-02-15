package apiTesting;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;


public class CookiesDemo {

	@Test(priority=1)
	void CookiesTesting() {
		given()
		.when()
			.get("https://www.google.com/")
		.then()
			.cookie("AEC","AVcja2dI8IOgISNvGCZNuYscGTKBDpMOEOlMtp2fslywRvYcJx9scgcI3D0")// this should fail as everytime cookie value will be diff
			.log().all();	
	}
	
	@Test(priority=2)
	void CookiesGetInfo() {
		Response res= given()
		.when()
			.get("https://www.google.com/");
		
		String str =res.getCookie("AEC");
		System.out.println("value of cookie AEC: " + str);
		Map<String,String> mp=res.getCookies();
		for(String k:mp.keySet()) {
			String values= mp.get(k);
			System.out.println(values);
		}
	}

}
