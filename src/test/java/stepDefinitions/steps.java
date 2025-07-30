package stepDefinitions;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import Utils.RequestSpec;
import Utils.endPoints;
import groovyjarjarantlr4.v4.misc.Utils;
import io.cucumber.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class steps extends RequestSpec{
	RequestSpecification reqSpec;
	Response res1;
	@Given("Add Place Payload")
	public void add_place_payload() throws IOException {
		reqSpec=given().log().all().spec(spec()).body(Payload.payload1());
		System.out.println("    ");
	
	}
	
	@When("User hits")
	public void user_hits() {
		res1 = reqSpec.when().post(endPoints.AddPlaceAPI.getEndPoint()).
				then().extract().response();
	}
	
	@Then("status code is {int}")
	public void status_code_is(Integer int1) {
		Assert.assertEquals(200, res1.getStatusCode());
	}

}
