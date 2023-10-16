package api;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import schemas.UserDTO;

public class AuthorizationAPI extends ApiBase {

    public Response login(UserDTO user) {
        String endPoint = "/Account/v1/Login";
        return postRequest(endPoint, 200, user);
    }

    public String generateToken(UserDTO user) {
        String endPoint = "/Account/v1/GenerateToken";
        Response response = postRequest(endPoint, 200, user);

        JsonPath jsonPath = response.jsonPath();
        return jsonPath.getString("token");
    }

    public boolean isAuthorized(UserDTO user) {
        String endPoint = "/Account/v1/Authorized";
        Response response = postRequest(endPoint, 200, user);

        return Boolean.parseBoolean(response.asString());
    }
}
