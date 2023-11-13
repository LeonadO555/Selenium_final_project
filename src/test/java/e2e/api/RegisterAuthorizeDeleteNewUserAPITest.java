package e2e.api;

import api.AuthorizationAPI;
import api.UserAPI;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import schemas.GetUserResultDTO;
import schemas.UserDTO;

public class RegisterAuthorizeDeleteNewUserAPITest {

    AuthorizationAPI authorizationAPI = new AuthorizationAPI();

    @Test
    public void registerLoginDeleteNewUserViaApi() {
        // generate new user
        UserDTO newUserData = authorizationAPI.generateNewRandomUser();

        //register new user
        JsonPath createdUser = authorizationAPI.registerNewUser(newUserData).jsonPath();
        String userId = createdUser.getString("userID");

        // generate token
        String token = authorizationAPI.generateToken(newUserData);
        UserAPI userAPI = new UserAPI(token);
        Assert.assertTrue(authorizationAPI.isAuthorized(newUserData));

        //get data of created user
        GetUserResultDTO expectedCreatedUser = userAPI.getUser(userId);
        Assert.assertEquals(
                createdUser.getString("username"),
                expectedCreatedUser.getUsername(),
                createdUser + "is not equal to " + expectedCreatedUser
        );

        // login created user
        authorizationAPI.login(newUserData);

        // delete created user
        userAPI.deleteUser(userId);

        // verify user was deleted. getUser cannot be used,
        // because after deletion the token has been expired
        Response response = authorizationAPI.isDeleted(newUserData);
        Assert.assertEquals(response.jsonPath().getString("message"), "User not found!");
    }
}
