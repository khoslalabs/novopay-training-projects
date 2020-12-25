package in.novopay.Training;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.*;

import java.util.Date;

public class PricingSetupDetailsTest {
	
	@Test
	public void test() {
		RestAssured.baseURI="https://asset-qa-platform.novopay.in/api-gateway/api/v1/";
		
		Date date = new Date();
		String timeMS= date.getTime()+"";
		
		/*rest- Assured Java Libr - 4 blocks --
		given - header , body of the request
		when - post / get 
		then - assertions 
		extract - collect the response */
		Response response =  
		given()
		.accept("application/json")
		.header("Authorization","fb4a26cf-ec1e-44dc-ad3f-7d1eb05ccb25")
		.body("{\r\n" + 
				"    \"headers\": {\r\n" + 
				"        \"tenant_code\": \"novopay\",\r\n" + 
				"        \"user_id\": \"5\",\r\n" + 
				"        \"client_code\": \"NOVOPAY\",\r\n" + 
				"        \"channel_code\": \"NOVOPAY\",\r\n" + 
				"        \"end_channel_code\": \"NOVOPAY\",\r\n" + 
				"        \"stan\": \""
				+ timeMS
				+ "\",\r\n" + 
				"        \"client_ip\": \"127.0.0.1\",\r\n" + 
				"        \"transmission_datetime\": \"1598511523440\",\r\n" + 
				"        \"operation_mode\": \"SELF\",\r\n" + 
				"        \"retry_count\": \"\",\r\n" + 
				"        \"run_mode\": \"REAL\",\r\n" + 
				"        \"actor_type\": \"CUSTOMER\",\r\n" + 
				"        \"user_handle_type\": \"MSISDN\",\r\n" + 
				"        \"user_handle_value\": \"9816923672\",\r\n" + 
				"        \"location\": \"44.968046;-94.420307\",\r\n" + 
				"        \"function_code\": \"DEFAULT\",\r\n" + 
				"        \"function_sub_code\": \"DEFAULT\"\r\n" + 
				"    },\r\n" + 
				"    \"request\": {\r\n" + 
				"        \"id\": \"92\"\r\n" + 
				"    }\r\n" + 
				"}")
		.when().post("getPriceSetupDetails")
		.then()
		.assertThat().statusCode(200).and()
		.body("response_status.code",equalTo("30144"))
		.extract().response();
		
		JsonPath js = new JsonPath(response.asString());
		//js.prettyPeek();
		String message = js.get("response_status.message");
		System.out.println(message);
		
	}
	

}
