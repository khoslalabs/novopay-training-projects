package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import in.novopay.platform.apis.Headers.Headers;
import in.novopay.platform.apis.test.login.login;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	static RequestSpecification reqSpec;
	public static RequestSpecification RequestSpecificationInput(String ID) throws IOException {
		
		if(reqSpec==null) {
		PrintStream log =  new PrintStream(new FileOutputStream("logging.txt"));
		reqSpec = new RequestSpecBuilder().
				setAccept("application/json").
				addHeader("Authorization",login.passToken()).
				//setBody(Payload.payloadInput(ID)).
				addFilter(RequestLoggingFilter.logRequestTo(log)).
				addFilter(ResponseLoggingFilter.logResponseTo(log)).			
				build().
				given();		
		}
		return reqSpec;
	}

	static Properties prop = new Properties();
	static Headers header = new Headers();
	
	public static String getGlobalValue(String key) throws FileNotFoundException,IOException {
		FileInputStream fis = new FileInputStream("./env.properties");
		prop.load(fis);
		return prop.getProperty(key);
	}
	
	public static String getValueUsingJsonPath(Response response,String key) {
		JsonPath js= new JsonPath(response.asString());		
		return js.get(key);
		
	}
}
