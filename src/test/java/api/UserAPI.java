package api;

import io.restassured.response.Response;
import schemas.GetUserResultDTO;

public class UserAPI extends ApiBase {

    public UserAPI(String token) {
        super(token);
    }

    public GetUserResultDTO getUser(String userId) {
        String endPoint = "/Account/v1/User/{UserId}";
        return getRequestWithParam(endPoint, 200, "UserId", userId).as(GetUserResultDTO.class);
    }

    public Response deleteUser(String userId) {
        String endPoint = "/Account/v1/User/{UserId}";
        Response response = deleteRequest(endPoint, 204, "UserId", userId);
        return response;
    }
}
