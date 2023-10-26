package api.account;

import api.ApiBase;
import com.github.javafaker.Faker;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import schemas.RegisterModeDTO;


public class NewUser extends ApiBase {

    Faker faker = new Faker();

    public Response registerNewUser(RegisterModeDTO user) {
        String endPoint = "/Account/v1/User";
        return postRequest(endPoint, 201, user);
    }

    public Response login(RegisterModeDTO user) {
        String endPoint = "/Account/v1/Login";
        return postRequest(endPoint, 200, user);
    }

    public String generateToken(RegisterModeDTO user) {
        String endPoint = "/Account/v1/GenerateToken";
        Response response = postRequest(endPoint, 200, user);

        JsonPath jsonPath = response.jsonPath();
        return "Bearer " + jsonPath.getString("token");
    }

    public boolean isAuthorized(RegisterModeDTO user) {
        String endPoint = "/Account/v1/Authorized";
        return postRequest(endPoint, 200, user).asString().equalsIgnoreCase("true");
    }

    public Response isDeleted(RegisterModeDTO user) {
        String endPoint = "/Account/v1/Authorized";
        return postRequest(endPoint, 404, user);
    }

    public RegisterModeDTO generateNewRandomUser() {
        RegisterModeDTO register = new RegisterModeDTO();
        register.setUserName(faker.internet().uuid());
        register.setPassword("registraTion123@");
        return register;
    }
}
