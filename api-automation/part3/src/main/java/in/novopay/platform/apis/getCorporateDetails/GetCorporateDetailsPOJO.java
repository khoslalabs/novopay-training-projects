package in.novopay.platform.apis.getCorporateDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import in.novopay.platform.apis.Headers.*;

public class GetCorporateDetailsPOJO {

    @SerializedName("headers")
    @Expose
    private Headers headers;
    @SerializedName("request")
    @Expose
    private Request request;

    public Headers getHeaders() {
        return headers;
    }

    public void setHeaders(Headers headers) {
        this.headers = headers;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

}
