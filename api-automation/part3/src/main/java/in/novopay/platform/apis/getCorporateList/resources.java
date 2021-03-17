package in.novopay.platform.apis.getCorporateList;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class resources {
	
	public static String getResourcesData() {
		String res = "/maps/api/place/nearbysearch/json";
		return res;
		
	}
	
	public static String getPayloadData(String Offset,String page_size,String sort_order,String field_name) {
		Date date = new Date();
		long timeMs= date.getTime();
		String timestamp = timeMs+"";
				
		String payload_getCorporateList = "{\r\n" + 
				"    \"headers\": {\r\n" + 
				"        \"tenant_code\": \"novopay\",\r\n" + 
				"        \"user_id\": \"5\",\r\n" + 
				"        \"client_code\": \"NOVOPAY\",\r\n" + 
				"        \"channel_code\": \"NOVOPAY\",\r\n" + 
				"        \"end_channel_code\": \"NOVOPAY\",\r\n" + 
				"        \"stan\": \""+timestamp+"\",\r\n" + 
				"        \"client_ip\": \"127.0.0.1\",\r\n" + 
				"        \"transmission_datetime\": \"1591598592545\",\r\n" + 
				"        \"operation_mode\": \"SELF\",\r\n" + 
				"        \"retry_count\": \"\",\r\n" + 
				"        \"run_mode\": \"REAL\",\r\n" + 
				"        \"actor_type\": \"CUSTOMER\",\r\n" + 
				"        \"user_handle_type\": \"MSISDN\",\r\n" + 
				"        \"user_handle_value\": \"9816923672\",\r\n" + 
				"        \"location\": \"44.968046;-94.420307\",\r\n" + 
				"        \"function_code\": \"DEFAULT\",\r\n" + 
				"        \"function_sub_code\": \"DEFAULT\",\r\n" + 
				"        \"locale\": \"en-in\"\r\n" + 
				"    },\r\n" + 
				"    \"request\": {\r\n" + 
				"        \"search_criteria\": {\r\n" + 
				"            \"code\": \"C\"\r\n" + 
				"        },\r\n" + 
				"        \"page_size\": \""+page_size+"\",\r\n" + 
				"        \"offset\": \""+Offset+"\",\r\n" + 
				"        \"sort_criteria\": {\r\n" + 
				"            \"order\": \""+sort_order+"\",\r\n" + 
				"            \"fields\": [\r\n" + 
				"                {\r\n" + 
				"                    \"field_name\": \""+field_name+"\"\r\n" + 
				"                }\r\n" + 
				"            ]\r\n" + 
				"        }\r\n" + 
				"    }\r\n" + 
				"}";
		
		return payload_getCorporateList;
		
	}
	
	public static String getPayloadData() {
		Date date = new Date();
		long timeMs= date.getTime();
		String timestamp = timeMs+"";
		String Offset = "10";
		String page_size = "10";
		String sort_order = "ASC";
		String field_name = "code";
				
		String payload_getCorporateList = "{\r\n" + 
				"    \"headers\": {\r\n" + 
				"        \"tenant_code\": \"novopay\",\r\n" + 
				"        \"user_id\": \"5\",\r\n" + 
				"        \"client_code\": \"NOVOPAY\",\r\n" + 
				"        \"channel_code\": \"NOVOPAY\",\r\n" + 
				"        \"end_channel_code\": \"NOVOPAY\",\r\n" + 
				"        \"stan\": \""+timestamp+"\",\r\n" + 
				"        \"client_ip\": \"127.0.0.1\",\r\n" + 
				"        \"transmission_datetime\": \"1591598592545\",\r\n" + 
				"        \"operation_mode\": \"SELF\",\r\n" + 
				"        \"retry_count\": \"\",\r\n" + 
				"        \"run_mode\": \"REAL\",\r\n" + 
				"        \"actor_type\": \"CUSTOMER\",\r\n" + 
				"        \"user_handle_type\": \"MSISDN\",\r\n" + 
				"        \"user_handle_value\": \"9816923672\",\r\n" + 
				"        \"location\": \"44.968046;-94.420307\",\r\n" + 
				"        \"function_code\": \"DEFAULT\",\r\n" + 
				"        \"function_sub_code\": \"DEFAULT\",\r\n" + 
				"        \"locale\": \"en-in\"\r\n" + 
				"    },\r\n" + 
				"    \"request\": {\r\n" + 
				"        \"search_criteria\": {\r\n" + 
				"            \"code\": \"C\"\r\n" + 
				"        },\r\n" + 
				"        \"page_size\": \""+page_size+"\",\r\n" + 
				"        \"offset\": \""+Offset+"\",\r\n" + 
				"        \"sort_criteria\": {\r\n" + 
				"            \"order\": \""+sort_order+"\",\r\n" + 
				"            \"fields\": [\r\n" + 
				"                {\r\n" + 
				"                    \"field_name\": \""+field_name+"\"\r\n" + 
				"                }\r\n" + 
				"            ]\r\n" + 
				"        }\r\n" + 
				"    }\r\n" + 
				"}";
		
		return payload_getCorporateList;
		
	}
	
	public static String getPayloadData(String ID) {
		Date date = new Date();
		long timeMs= date.getTime();
		String timestamp = timeMs+"";
		return "{\r\n" + 
				"    \"headers\": {\r\n" + 
				"        \"tenant_code\": \"novopay\",\r\n" + 
				"        \"user_id\": \"5\",\r\n" + 
				"        \"client_code\": \"NOVOPAY\",\r\n" + 
				"        \"channel_code\": \"NOVOPAY\",\r\n" + 
				"        \"end_channel_code\": \"NOVOPAY\",\r\n" + 
				"        \"stan\": \""+timestamp+"\",\r\n" + 
				"        \"client_ip\": \"127.0.0.1\",\r\n" + 
				"        \"transmission_datetime\": \"1591867659729\",\r\n" + 
				"        \"operation_mode\": \"SELF\",\r\n" + 
				"        \"retry_count\": \"\",\r\n" + 
				"        \"run_mode\": \"REAL\",\r\n" + 
				"        \"actor_type\": \"CUSTOMER\",\r\n" + 
				"        \"user_handle_type\": \"MSISDN\",\r\n" + 
				"        \"user_handle_value\": \"9816923672\",\r\n" + 
				"        \"location\": \"44.968046;-94.420307\",\r\n" + 
				"        \"function_code\": \"DEFAULT\",\r\n" + 
				"        \"function_sub_code\": \"DEFAULT\",\r\n" + 
				"        \"locale\": \"en-in\"\r\n" + 
				"    },\r\n" + 
				"    \"request\": {\r\n" + 
				"        \"id\": \""+ID+"\"\r\n" + 
				"    }\r\n" + 
				"}";
		
		
	}
		
	public static XmlPath rawToXML(Response r) {
		XmlPath x = new XmlPath(r.asString());
		return x;
		
	}
	
	public static JsonPath rawToJson(Response r) {
		JsonPath js=new JsonPath(r.asString());
		return js;
	}
	
	
			

	public static HashMap<String, Object> getCorporateList(String Offset,String page_size,String sort_order,String field_name){
		Date date = new Date();
		String timestamp = date.getTime()+"";
		HashMap<String, Object> http = new HashMap<>();
		HashMap<String, Object> header = new HashMap<>();
		HashMap<String, Object> request = new HashMap<>();
		HashMap<String, Object> reqCode = new HashMap<>();
		HashMap<String, Object> reqSort = new HashMap<>();
		HashMap<String, Object> fields	 = new HashMap<>();
		
		ArrayList<HashMap<String, Object>> arraylist= new ArrayList<HashMap<String, Object>>(); 
		
		header.put("tenant_code", "novopay");
		header.put("client_code", "NOVOPAY");
		header.put("channel_code", "NOVOPAY");
		header.put("end_channel_code", "NOVOPAY");
		header.put("stan", timestamp);
		header.put("client_ip", "127.0.0.1");
		header.put("transmission_datetime", "1591598592545");
		header.put("operation_mode", "SELF");
		header.put("retry_count", "");
		header.put("run_mode", "REAL");
		header.put("actor_type", "CUSTOMER");
		header.put("user_handle_type", "MSISDN");
		header.put("user_handle_value", "9816923672");
		header.put("location", "44.968046;-94.420307");
		header.put("locale", "en-in");
		header.put("user_id", "5");
		header.put("function_code", "DEFAULT");
		header.put("function_sub_code", "DEFAULT");
		request.put("search_criteria",reqCode);
		reqCode.put("code","C");
		request.put("page_size",page_size);
		request.put("offset",Offset);
		request.put("sort_criteria",reqSort);
		reqSort.put("order",sort_order);
		fields.put("field_name",field_name);
		
		//adding the filed_name to the arrayList
		arraylist.add(fields);
		//arrayList of field_names added to fields
		reqSort.put("fields",arraylist); //fields should have an array
				
		http.put("headers", header);
		http.put("request", request);
		
		return http;
	}

}
