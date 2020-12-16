package in.novopay.platform.apis.test.getCorporateList;
import static io.restassured.RestAssured.given;

import org.junit.runner.RunWith;

import in.novopay.platform.apis.test.login.*;
import in.novopay.platform.apis.getCorporateList.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.junit.Cucumber;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.Responses;
import resources.Utils;

import static org.testng.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

@RunWith(Cucumber.class)
public class StepDefinitionGetCorproateList {
	Response res;

		@Given("the test scenario with {string} {string} {string} {string} {string}")
		public void the_test_scenario_with(String Offset,String page_size,String sort_order,String field_name,String API) throws IOException  {

			res = 
					given().
					header("Authorization",login.passToken()).
					accept("application/json").
					body(resources.getPayloadData(Offset,page_size,sort_order,field_name)). 
				
					
					when().
						post(Utils.getGlobalValue("QA_URL")+API).
						
					then().
					
					extract().response();				
		}


		@Then("the message is verified {string}")
		public void the_message_is_verified(String msg) {			
			assertEquals(Utils.getValueUsingJsonPath(res, Responses.msg.getResponse()),msg);			
		}


		@Then("the message is not verified {string}")
		public void the_message_is_not_verified(String msg) {			
			assertNotEquals(Utils.getValueUsingJsonPath(res, Responses.msg.getResponse()),msg);			
		}
		
		@Given("enter the url {string}")
		public void enter_the_url(String url) throws IOException {
			RestAssured.baseURI=url;
			PrintStream log =  new PrintStream(new FileOutputStream("logging.txt"));
			RequestSpecification res = new RequestSpecBuilder().addFilter(RequestLoggingFilter.logRequestTo(log)).build();
			System.out.println("Logging In");
		}
	}

