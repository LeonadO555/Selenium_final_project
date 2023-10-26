package api;

import io.restassured.response.Response;

public class UserApi extends ApiBase{

    public UserApi(String token) {
        super(token);
    }

    public Response getUser(String userId) {
        String endPoint = "/Account/v1/User/{UserId}";
        return getRequestWithParam(endPoint, 200, "UserId", userId);
    }

    public void deleteUser(String userId) {
        String endPoint = "/Account/v1/User/{UserId}";
        Response response = deleteRequest(endPoint, 204, "UserId", userId);
    }
}
