package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Date;
import java.util.Properties;
import java.io.IOException;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {

	public static RequestSpecification req;

	public RequestSpecification requestSpecification() throws IOException {

		if (req == null) {
			String stamp = timeStamp();
//			PrintStream log = new PrintStream(new FileOutputStream("logger_" + stamp + "txt"));
			PrintStream log = new PrintStream(new FileOutputStream("logger.txt"));
			req = new RequestSpecBuilder().setBaseUri(GetGlobalValue("baseURI")).addQueryParam("key", "qaclick123")
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log)).setContentType(ContentType.JSON).build();

			return req;
		}
		return req;
	}

	public String timeStamp() {
		Date date = new Date(); // your date
		String dat = date.toString().substring(0, 16).replace(" ", "_").replace(":", "_");
		return dat;
	}

	public String GetGlobalValue(String url) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Programs_Download\\Rahul_shetty_RestAssuredAutomation\\APIFramework\\src\\test\\java\\resources\\global.properties");
		prop.load(fis);
		return prop.getProperty(url);
	}
	
	public String getJsonPath(Response response, String key) {
		String resp = response.asString();
	    JsonPath js = new JsonPath(resp);
	    return js.get(key).toString();
	}

}
