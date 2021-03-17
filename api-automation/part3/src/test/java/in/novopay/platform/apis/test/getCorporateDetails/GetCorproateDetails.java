package in.novopay.platform.apis.test.getCorporateDetails;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import in.novopay.platform.apis.getCorporateList.resources;
import in.novopay.platform.apis.test.login.login;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

import io.restassured.response.Response;

import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.util.ArrayList;
//import java.util.Date;
import java.util.Iterator;

import resources.ExtractDataFromExcel;
import resources.Payload;
import resources.Responses;
import resources.Utils;

public class GetCorproateDetails extends Utils {

	private static String API="getCorporateDetails";

	@Test(dataProvider = "Excel",priority=1)
	public static void TestRegression(String ID) throws IOException {
				
		Response res = 
				given().					
					header("Authorization",login.passToken()).
					accept("application/json").
					contentType(ContentType.JSON).
			
					body(Payload.payloadInput(ID)). //passing data through POJO class
					
				when().
					//log().body().	
					post(Utils.getGlobalValue("QA_URL")+API).		
				then().
					assertThat().statusCode(200).and().contentType(ContentType.JSON)
					.and().header("Server", equalTo("nginx")).
					and().body(Responses.status.getResponse(), equalTo("SUCCESS")).			
				extract().
					response();
		
		//res.andReturn().prettyPeek();
		JsonPath js = new JsonPath(res.asString());

		String code = js.get("corporate_details.code");
		//System.out.println(js.get("corporate_details.size()"));
		System.out.println("code = "+code+" ; message = "+js.get(Responses.msg.getResponse()) );		
           
		}
	
	@Test(dataProvider = "NegativeData",priority=2)
	public static void TestRegressionNegative(String ID) throws IOException {
				
		Response res = 
				given().					
					header("Authorization",login.passToken()).
					accept("application/json").
					body(Payload.payloadInput(ID)).
					
				when().
					//log().body().	
					post(Utils.getGlobalValue("QA_URL")+API).		
				then().
					assertThat().statusCode(200).and().contentType(ContentType.JSON)
					.and().header("Server", equalTo("nginx")).
					and().body(Responses.status.getResponse(), equalTo("FAIL")).			
				extract().
					response();
		
		//res.andReturn().prettyPeek();
		JsonPath js = new JsonPath(res.asString());

		String code = js.get("corporate_details.code");
		//System.out.println(js.get("corporate_details.size()"));
		System.out.println("code = "+code+" ; message = "+js.get(Responses.msg.getResponse()) );		
           
		}
	
	
	
	@DataProvider(name="PositiveData")
	public Object[][] dataInput()  {
		return new Object[][] {{"202"}
		,{"174"},{"192"}
		};
	}
		

	@DataProvider(name="NegativeData")
		public Object[][] dataInput1()  {
			return new Object[][] {{"-5"}
			,{"0"},{"10000"}
			};	
	}
	
	@DataProvider(name="Excel")
	public Iterator<Object[]> dataInput2() throws IOException{
		ExtractDataFromExcel excel = new ExtractDataFromExcel();
		ArrayList<Object[]> data ;
		data = excel.ExtractData(API, "Positive");
		return data.iterator();
	}
}
