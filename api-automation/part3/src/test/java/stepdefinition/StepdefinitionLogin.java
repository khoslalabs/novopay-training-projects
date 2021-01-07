
package stepdefinition;
import org.junit.runner.RunWith;

//import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

import in.novopay.platform.apis.login.LoginRequest;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import resources.Responses;
import resources.Utils;

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

@RunWith(Cucumber.class)
public class StepdefinitionLogin extends Utils {

	static Properties prop = new Properties();
	static String token;
	Response res;
	JsonPath js;
	

		@Given("the url is present")
		public void the_url_is_present() throws FileNotFoundException, IOException {
			//not passing url, bcz its passed inside .post
		}

		@When("the request {string} {string} are passed into {string}")
		public void the_request_are_passed_into(String User, String UserName,String API) throws IOException {
			res =	given().body(LoginRequest.HeaderData(User)+ LoginRequest.requestData(UserName)).
					when().post(Utils.getGlobalValue(API));
				
			System.out.print("user id = "+User);
		}
		
		@Then("the session token extracted")
		public void the_session_token_extracted() {
			js = new JsonPath(res.asString());
			System.out.println(" user logged in with "+js.get("session_token"));
		}
		
		@Then("the status code should be {string}")
		public void the_status_code_should_be(String Status) {
		    assertEquals(js.get(Responses.code.getResponse()),Status);
		    System.out.println("Status code assertion passed");
		}
		
		@Then("login is successful {string}")
		public void login_is_successful(String response) {			
			System.out.println(js.get(Responses.valueOf(response).getResponse()));
		}


}
