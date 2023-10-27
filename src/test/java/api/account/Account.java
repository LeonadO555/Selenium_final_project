package api.account;

import api.ApiBase;
import com.github.javafaker.Faker;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.slf4j.LoggerFactory;
import schemas.RegisterModelDto;
import org.slf4j.Logger;

public class Account extends ApiBase {

    Faker faker = new Faker();

    private static final Logger logger = LoggerFactory.getLogger(Account.class);

    public Response registerNewAccount(RegisterModelDto user) {
        String endPoint = "/Account/v1/User";
        Response response = postRequest(endPoint, 201, user);
        logger.info("Registered new account: {}", user.getUserName());
        return response;
    }

    public String generateToken(RegisterModelDto user) {
        String endPoint = "/Account/v1/GenerateToken";
        Response response = postRequest(endPoint, 200, user);
        JsonPath jsonPath = response.jsonPath();
        return "Bearer " + jsonPath.getString("token");
    }

    public boolean authorizeAccount(RegisterModelDto user, String token) {
        String endPoint = "/Account/v1/Authorized";
        Response response = postRequest(endPoint, 200, user);
        response.then().assertThat().statusCode(200);
        return response.asString().equalsIgnoreCase("true");
    }


    public Response deleteAccount(RegisterModelDto user) {
        String endPoint = "/Account/v1/Authorized";
        return postRequest(endPoint, 404, user);
    }

    public RegisterModelDto createNewRandomAccount() {
        RegisterModelDto register = new RegisterModelDto();
        register.setUserName(faker.internet().uuid());
        register.setPassword("Abc123$@&");
        return register;
    }
}
