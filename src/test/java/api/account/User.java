package api.account;

import api.ApiBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class User extends ApiBase {
    Response response;
    public User (String token){
        super(token);
    }
    public Response getUser(Integer code, String id) {
        String endPoint = "/Account/v1/User/{UUID}/";
        response = getRequestWithParam(endPoint, code, "UUID", id);
        return response;
    }

    public Response deleteUser(Integer code, int id) {
        String endPoint = "/Account/v1/User/{UUID}";
        response = deleteRequest(endPoint, code, "UUID", id);
        return response;
    }
}
