package in.novopay.platform.apis.test.getCorporateList;
import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import in.novopay.platform.apis.test.login.*;
import in.novopay.platform.apis.getCorporateList.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import resources.ExtractDataFromExcel;
import resources.Responses;
import resources.Utils;

import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


public class GetCorproateList {

	private String API = "getCorporateList";
	
	@Test(dataProvider = "PositiveData",priority=1,invocationCount=2)
	public void TestRegression(String Offset,String page_size,String sort_order,String field_name) throws IOException {
		
	
		Response res = 
				given().
				header("Authorization",login.passToken()).
				accept("application/json").
				body(resources.getPayloadData(Offset,page_size,sort_order,field_name)).//passing data through Json
				//log().all().
										
				when().
					post(Utils.getGlobalValue("QA_URL")+API).
					
				then().
					assertThat().statusCode(200).and().contentType(ContentType.JSON)
					.and().header("Server", equalTo("nginx")).
					and().body(Responses.status.getResponse(), equalTo("SUCCESS")).
					and().body(Responses.code.getResponse(),equalTo("40046")).
					//log().all().
				
				extract().response();
		
		System.out.println("message = "+ Utils.getValueUsingJsonPath(res, Responses.msg.getResponse()));		
		}
	
	@DataProvider(name="PositiveData")
	public Object[][] dataInput()  {
		return new Object[][] {{"10", "10", "ASC", "code"}
		,{"0", "10", "DESC", "code"},{"10", "10", "ASC", "name"}
		};
		
	}

	@Test(dataProvider = "Excel",priority=2)
	public void TestRetest(String Offset,String page_size,String sort_order,String field_name) throws IOException {
		
		Response res = 
				given().
				
				header("Authorization",login.passToken()).
				accept("application/json").
				body(resources.getCorporateList(Offset, page_size, sort_order, field_name)). //passing data thru hashmap
				//log().body().
				when().
					post(Utils.getGlobalValue("QA_URL")+API).
					
				then().
					assertThat().statusCode(200).and().contentType(ContentType.JSON)
					.and().header("Server", equalTo("nginx")).
					and().body(Responses.status.getResponse(), equalTo("FAIL")).
					//and().body(Responses.code.getResponse(),equalTo("40046")).
				extract().response();

		System.out.println("message = "+ Utils.getValueUsingJsonPath(res, Responses.msg.getResponse()));			
		}


	
	@DataProvider(name="Excel")
	public Iterator<Object[]> dataInput2() throws IOException{
		ExtractDataFromExcel excel = new ExtractDataFromExcel();
		ArrayList<Object[]> data ;
		data = excel.extractDataGetCorporateList(API, "Positive");
		return data.iterator();
	}
}
