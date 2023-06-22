package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@Deleteplace")
	public void beforeScenario() throws IOException {

		stepDefinition m = new stepDefinition();
		if (stepDefinition.place_ID == null) {
			m.add_Place_Payload_with("Pavan", "French", "kothapeta");
			m.user_calls_with_Post_http_request("AddPlaceAPI", "POST");
			m.verify_place_ID_created_maps_to_using("Pavan", "getPlaceAPI");
		}
	}
}
