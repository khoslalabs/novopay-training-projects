package in.novopay.platform.apis.test.login;

import org.testng.annotations.Test;

//import in.novopay.platform.apis.Headers.Headers;
import in.novopay.platform.apis.login.LoginRequest;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
//import java.util.Date;
import java.util.Properties;

public class login {

	static Properties prop = new Properties();
	static String token;
	
	public static void loadProperties() throws IOException,FileNotFoundException {
		FileInputStream fis = new FileInputStream("C:\\Users\\Sharmila\\eclipse-workspace\\RestAssuredAPI\\src\\files\\env.properties");
		prop.load(fis);
	}

	@Test
	public static void getToken() throws FileNotFoundException, IOException {	
		
		PrintStream log = new PrintStream(new FileOutputStream("./logging.txt"));
		
		loadProperties();
		RestAssured.baseURI="https://asset-qa-platform.novopay.in";
		Response res = 
			given().			
					body(LoginRequest.HeaderData("5")+ LoginRequest.requestData("Sharmila")).
					log().ifValidationFails().					
					//log().all().
				when().
					post(prop.getProperty("loginAPI")).
					//post("/api-gateway/api/novopay/v1/"+"login").
				then().
					assertThat().statusCode(200).and().
					body("response_status.message",equalTo("Login Successful")).and().
					header("Access-Control-Allow-Origin",equalTo("https://asset-qa-platform.novopay.in")).
					//log().status().
				extract().
					response();
		
		JsonPath js = new JsonPath(res.asString());
		token= js.get("session_token");
		//System.out.println("user id 5 logged in"+token);
		log.append(js.prettyPrint());
		
	}


	public static String passToken() throws IOException, IOException {
		getToken();
		return token;
	}
	

}
