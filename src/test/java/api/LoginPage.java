package api;

import io.restassured.response.Response;

public class LoginPage extends ApiBase {

    public LoginPage(String token) {
        super(token);
    }

    public Response getUser(String userId) {
        String endPoint = "/Account/v1/User/{UserId}";
        Response response = getRequestWithParam(endPoint, 200, "UserId", userId);
        return response;
    }

    public Response deleteUser(String userId) {
        String endPoint = "/Account/v1/User/{UserId}";
        Response response = deleteRequest(endPoint, 204, "UserId", userId);
        return response;
    }
}