package api;

import com.github.javafaker.Faker;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import schemas.UserDto;

public class AuthorizationApi extends ApiBase {

    Faker faker = new Faker();

    public Response registerNewUser(UserDto user) {
        String endPoint = "/Account/v1/User";
        return postRequest(endPoint, 201, user);
    }

    public void login(UserDto user) {
        String endPoint = "/Account/v1/Login";
        postRequest(endPoint, 200, user);
    }

    public String generateToken(UserDto user) {
        String endPoint = "/Account/v1/GenerateToken";
        Response response = postRequest(endPoint, 200, user);

        JsonPath jsonPath = response.jsonPath();
        return "Bearer " + jsonPath.getString("token");
    }

    public boolean isAuthorized(UserDto user) {
        String endPoint = "/Account/v1/Authorized";
        return postRequest(endPoint, 200, user).asString().equalsIgnoreCase("true");
    }

    public Response isDeleted(UserDto user) {
        String endPoint = "/Account/v1/Authorized";
        return postRequest(endPoint, 404, user);
    }

    public UserDto generateNewRandomUser() {
        UserDto register = new UserDto();
        register.setUserName(faker.internet().uuid());
        // password hard coded due to the faker password generation bug https://github.com/faker-ruby/faker/issues/2512
        register.setPassword("NewTest567&");
        return register;
    }
}