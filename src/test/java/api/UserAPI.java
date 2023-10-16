package api;

import io.restassured.response.Response;
import schemas.UserDTO;

public class UserAPI extends ApiBase {

    public UserAPI(String token) {
        super(token);
    }

    public Response registerNewUser(UserDTO user) {
        String endPoint = "/Account/v1/User";
        Response response = postRequest(endPoint, 200, user);
        response.as(UserDTO.class);
        return response;
    }

    public Response getUser(String userId) {
        String endPoint = "/Account/v1/User/{UserId}";
        Response response = getRequestWithParam(endPoint, 200, "UserId", userId);
        return response;
    }

    public Response deleteUser(String userId) {
        String endPoint = "/Account/v1/User/{UserId}";
        Response response = deleteRequest(endPoint, 200, "UserId", userId);
        return response;
    }
}
