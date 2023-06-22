package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {

	public AddPlace addPlacePayload(String name, String language, String address) {
		AddPlace p = new AddPlace();
		Location locat = new Location();
		
		locat.setLat(-38.383494);
		locat.setLng(33.427362);
		
		p.setLocation(locat);
		p.setAccuracy(50);
		p.setName(name);
		p.setPhone_number("(+91) 983 893 3937");
		p.setAddress(address);
		p.setWebsite("http://google.com");
		p.setLanguage(language);
		
		List <String> li = new ArrayList<String>();
		li.add("shoe park");
		li.add("shop");
		p.setTypes(li);
		return p;
	}
	public String deletePlacePayload(String place_Id) {
		return "{\r\n"
				+ "    \"place_id\":\""+place_Id+"\"\r\n"
				+ "}";
	}
}
