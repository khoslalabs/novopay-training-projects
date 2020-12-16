
package in.novopay.platform.apis.Headers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Headers {

    @SerializedName("tenant_code")
    @Expose
    private String tenant_code;
    @SerializedName("user_id")
    @Expose
    private String user_id;
    @SerializedName("client_code")
    @Expose
    private String client_code;
    @SerializedName("channel_code")
    @Expose
    private String channel_code;
    @SerializedName("end_channel_code")
    @Expose
    private String end_channel_code;
    @SerializedName("stan")
    @Expose
    private String stan;
    @SerializedName("client_ip")
    @Expose
    private String client_ip;
    @SerializedName("transmission_datetime")
    @Expose
    private String transmission_datetime;
    @SerializedName("operation_mode")
    @Expose
    private String operation_mode;
    @SerializedName("retry_count")
    @Expose
    private String retry_count;

	@SerializedName("run_mode")
    @Expose
    private String run_mode;
    @SerializedName("actor_type")
    @Expose
    private String actor_type;
    @SerializedName("user_handle_type")
    @Expose
    private String user_handle_type;
    @SerializedName("user_handle_value")
    @Expose
    private String user_handle_value;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("function_code")
    @Expose
    private String function_code;
    @SerializedName("function_sub_code")
    @Expose
    private String function_sub_code;
    @SerializedName("locale")
    @Expose
    private String locale;

    
    
    
    public String getTenant_code() {
		return tenant_code;
	}
	public void setTenant_code(String tenant_code) {
		this.tenant_code = tenant_code;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getClient_code() {
		return client_code;
	}
	public void setClient_code(String client_code) {
		this.client_code = client_code;
	}
	public String getChannel_code() {
		return channel_code;
	}
	public void setChannel_code(String channel_code) {
		this.channel_code = channel_code;
	}
	public String getEnd_channel_code() {
		return end_channel_code;
	}
	public void setEnd_channel_code(String end_channel_code) {
		this.end_channel_code = end_channel_code;
	}
	public String getStan() {
		return stan;
	}
	public void setStan(String stan) {
		this.stan = stan;
	}
	public String getClient_ip() {
		return client_ip;
	}
	public void setClient_ip(String client_ip) {
		this.client_ip = client_ip;
	}
	public String getTransmission_datetime() {
		return transmission_datetime;
	}
	public void setTransmission_datetime(String transmission_datetime) {
		this.transmission_datetime = transmission_datetime;
	}
	public String getOperation_mode() {
		return operation_mode;
	}
	public void setOperation_mode(String operation_mode) {
		this.operation_mode = operation_mode;
	}
	public String getRetry_count() {
		return retry_count;
	}
	public void setRetry_count(String retry_count) {
		this.retry_count = retry_count;
	}
	public String getRun_mode() {
		return run_mode;
	}
	public void setRun_mode(String run_mode) {
		this.run_mode = run_mode;
	}
	public String getActor_type() {
		return actor_type;
	}
	public void setActor_type(String actor_type) {
		this.actor_type = actor_type;
	}
	public String getUser_handle_type() {
		return user_handle_type;
	}
	public void setUser_handle_type(String user_handle_type) {
		this.user_handle_type = user_handle_type;
	}
	public String getUser_handle_value() {
		return user_handle_value;
	}
	public void setUser_handle_value(String user_handle_value) {
		this.user_handle_value = user_handle_value;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getFunction_code() {
		return function_code;
	}
	public void setFunction_code(String function_code) {
		this.function_code = function_code;
	}
	public String getFunction_sub_code() {
		return function_sub_code;
	}
	public void setFunction_sub_code(String function_sub_code) {
		this.function_sub_code = function_sub_code;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public void setEndChannelCode(String string) {
		// TODO Auto-generated method stub
		
	}
	public void setUserHandleType(String string) {
		// TODO Auto-generated method stub
		
	}

}
