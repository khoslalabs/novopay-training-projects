package resources;

public enum Responses {
	
	status("response_status.status"),
	code("response_status.code"),
	msg("response_status.message");
			
	private String response;
	Responses(String response) {
		this.response = response;
	}
	
	public String getResponse() {
		return response;
	}

}
