package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class stepDefinition extends Utils{
	
	ResponseSpecification res;
	RequestSpecification request;
	Response Res;
	public static String place_ID;
	
	TestDataBuild obj = new TestDataBuild();
	
	@Given("Add Place Payload with {string} {string} {string}")
	public void add_Place_Payload_with(String name, String language, String address) throws IOException {

		request = given().spec(requestSpecification()).body(obj.addPlacePayload(name, language, address));
		
	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_Post_http_request(String resource, String method) {
		
		
		//constructor will be called with value of resource which you passed
		APIResources resourceAPI = APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		
		res = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON)
				.build();
		if(method.equalsIgnoreCase("POST")) {
			Res = request.when().post(resourceAPI.getResource());
		}else if(method.equalsIgnoreCase("GET")) {
			Res = request.when().get(resourceAPI.getResource());
		}
		
//				.then().spec(res).extract().response();    // this will be covered in later part
	}
	

	
	@Then("the API call is success with status code {int}")
	public void the_API_call_is_success_with_status_code(Integer responsecode) {
		
		assertEquals(Res.getStatusCode(), 200);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String Key, String ExpectedValue) {
	    assertEquals(getJsonPath(Res, Key), ExpectedValue);
//	    System.out.println(js.get("place_id"));
		
//	    assertEquals(Res.getBody().jsonPath().getString("scope"), "APP");
	}
	
	@Then("verify place_ID created maps to {string} using {string}")
	public void verify_place_ID_created_maps_to_using(String ExpectedName, String resource) throws IOException {
		AddPlace ap = new AddPlace();
		
		place_ID = getJsonPath(Res, "place_id");
		request = given().spec(requestSpecification()).queryParam("place_id", place_ID);
		user_calls_with_Post_http_request(resource, "GET");
		String ActualName = getJsonPath(Res, "name");
		assertEquals(ActualName,ExpectedName);
		System.out.println("Actual Place_ID  :  "+place_ID);
		
	}
	
	@Given("Delete place payload")
	public void delete_place_payload() throws IOException {
		request = given().spec(requestSpecification()).body(obj.deletePlacePayload(place_ID));
		System.out.println(obj.deletePlacePayload(place_ID));
		System.out.println("Request   :  "+request);
	    System.out.println("Acquired Place ID is :  "+place_ID);
	}

}