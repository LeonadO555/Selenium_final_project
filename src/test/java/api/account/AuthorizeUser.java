package api.account;

import api.ApiBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import schemas.RegisterViewModel;


public class AuthorizeUser extends ApiBase {

    public String generateToken(RegisterViewModel user) {
        String endPoint = "/Account/v1/GenerateToken";
        Response response = postRequest(endPoint, 200, user);

        JsonPath jsonPath = response.jsonPath();
        return "Bearer " + jsonPath.getString("token");
    }

    public boolean userAuthorized(RegisterViewModel user) {
        String endPoint = "/Account/v1/Authorized";
        return postRequest(endPoint, 200, user).asString().equalsIgnoreCase("true");
    }

    public Response userDeleted(RegisterViewModel user) {
        String endPoint = "/Account/v1/Authorized";
        return postRequest(endPoint, 404, user);
    }
}

