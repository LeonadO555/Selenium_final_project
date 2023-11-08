package api;

import com.github.javafaker.Faker;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import schemas.LoginViewModel;

public class Account extends ApiBase{
    Faker faker = new Faker();

    public Response registerNewUser(LoginViewModel user) {
        String endPoint = "/Account/v1/User";
        return postRequest(endPoint, 201, user);
    }

    public Response login(LoginViewModel user) {
        String endPoint = "/Account/v1/Login";
        return postRequest(endPoint, 200, user);
    }
    public String generateToken(LoginViewModel user) {
        String endPoint = "/Account/v1/GenerateToken";
        Response response = postRequest(endPoint, 200, user);

        JsonPath jsonPath = response.jsonPath();
        return "Bearer " + jsonPath.getString("token");
    }

    public boolean isAuthorized(LoginViewModel user) {
        String endPoint = "/Account/v1/Authorized";
        return postRequest(endPoint, 200, user).asString().equalsIgnoreCase("true");
    }
    public Response isDeleted(LoginViewModel user) {
        String endPoint = "/Account/v1/Authorized";
        return postRequest(endPoint, 404, user);
    }

    public LoginViewModel generateNewRandomUser() {
        LoginViewModel register = new LoginViewModel();
        register.setUserName(faker.internet().uuid());
        register.setPassword("I19811202a!");
        return register;
    }
}
