package apiTesting;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class PathAndQueryParam {

	@Test
	void PathAndQuery() {
		given()
			.pathParam("Mypathparam", "search")
			.queryParam("q", "testing")
		
		.when()
			.get("https://www.google.com/{Mypathparam}")
		.then()
			.statusCode(200);
	}
}
