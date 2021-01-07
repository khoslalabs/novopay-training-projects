package in.novopay.platform.apis.login;

import java.util.Date;


public class LoginRequest {

	
	public static String HeaderData(String user_id) {
		Date date = new Date();
		String timeMS = date.getTime()+"";
		
		return "{\r\n" + 
				"    \"headers\": {\r\n" + 
				"        \"tenant_code\": \"novopay\",\r\n" + 
				"        \"user_id\": \""+user_id+"\",\r\n" + 
				"        \"client_code\": \"NOVOPAY\",\r\n" + 
				"        \"channel_code\": \"NOVOPAY\",\r\n" + 
				"        \"end_channel_code\": \"NOVOPAY\",\r\n" + 
				"        \"stan\": \""+ timeMS+ "\",\r\n" + 
				"        \"client_ip\": \"127.0.0.1\",\r\n" + 
				"        \"transmission_datetime\": \"1591763859549\",\r\n" + 
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
				"    },\r\n" ;
	}
	
	public static String requestData(String username) {
		return "\"request\": {\r\n" + 
				"        \"handle_type\": \"EMAIL\",\r\n" + 
				"        \"handle_value\": \""+username+"\",\r\n" + 
				"        \"auth_type\": \"PASSWORD\",\r\n" + 
				"        \"auth_value\": \"VUFOcFN3aEZ1Zzg1RFVkMGx5T2VHNFQ3NURNQ1JvYjAvQ3BSRlZSOHZhYmFYUUZZL3JqbjFNQkhxbjBjQldYOHMzZGladHh1ZmNtUkp5ZVRibWN3YXV4Um94eTJKUWVpeThiZ3kwZUo5VGcwMGkyRGtKbW1GMGd2OW9pZVAraGt2U0NVbWtqUUgrSnNYN3ExZVZMU01QeEEvME5kQm5JN2pVUnNUNXA2SjhOMjl4R3NzT2VlKzNSTGlUNEY5UGlsSDk0NWVEM1F0eE1ES3k4Q3RVelJQVUJHbkJScW8rTXpQR3d4SUQzMGhDZDZzS2N3TFFWa3RLa25wNG5tUGNkbytPZTk0RU1QL3I3ZlNPR21mZGI1UmE1S3FydmdPQ010NFhWblVOeEpsa2NGMHlPQThGRHo4VzhFNjkxbmYrbDcrc00wMXlFbCtNT2NKRDh0OTQyYg==\",\r\n" + 
				"        \"recaptcha_key\": \"03AGdBq25DA66P2ZSdsRxRC9JJeHrBx1-MJMN_m4EhDE_osnxRlwtdeZTAuma1bc9fNx6dQRQPoimfKoqsPr-oaLhWVt1t2qoYRJWEWJyj3CxJ49d1Du6_AMKEqTxYnTGSmFPV_jB3LcX4qBdVSmY-7ymUuw_JgZYghD67L-jtcyYGifzOlShlzj2xcmoWBAAEeW0UgQlVut_uTtc2cEkxNfO8Nm-X9Nzj-79QrdAGr0V6wRJCXUC1YXhMsxgK-7Oto4ruA8t7fsBt4JgwuaIp0cZ2csTcc_LKCBQBIXAvsLRdxfadWitBhbmRRfcUr3EBOo8AsySEOrCjVeKeMEZTpboQtw1FMzuCAePAsPHeMba6oxvMI323w1l6dOm27OezhLWewILQWv4N7MZI7pdnIfNKhVRl0FgUww\"\r\n" + 
				"    }\r\n" + 
				"}";
	}
}
