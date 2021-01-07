package resources;

import java.util.Date;

import in.novopay.platform.apis.Headers.Headers;
import in.novopay.platform.apis.getCorporateDetails.GetCorporateDetailsPOJO;
import in.novopay.platform.apis.getCorporateDetails.Request;

public class Payload {

	public static GetCorporateDetailsPOJO payloadInput(String ID) {
		
		Date date = new Date();
		String timeStamp = date.getTime()+"";
		GetCorporateDetailsPOJO api = new GetCorporateDetailsPOJO();
		Headers headers = new Headers();
		Request request = new Request();
		
		api.setHeaders(headers);
		api.setRequest(request);
		
		headers.setTenant_code("novopay");
		headers.setUser_id("5");
		headers.setClient_code("NOVOPAY");
		headers.setChannel_code("NOVOPAY");
		headers.setEndChannelCode("NOVOPAY");
		headers.setStan(timeStamp);
		headers.setClient_ip("127.0.0.1");
		headers.setTransmission_datetime("1591867659729");
		headers.setOperation_mode("SELF");
		headers.setRetry_count("");
		headers.setRun_mode("REAL");
		headers.setActor_type("CUSTOMER");
		headers.setUserHandleType("MSISDN");
		headers.setUser_handle_value("9816923672");
		headers.setLocation("44.968046;-94.420307");
		headers.setFunction_code("DEFAULT");
		headers.setFunction_sub_code("DEFAULT");
		headers.setLocale("en-in");		
		request.setId(ID);
		
		return api;
	}

}
