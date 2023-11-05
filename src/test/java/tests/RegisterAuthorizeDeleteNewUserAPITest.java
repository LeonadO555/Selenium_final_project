package tests;

import api.AuthorizationAPI;
import api.UserAPI;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import schemas.UserDTO;

public class RegisterAuthorizeDeleteNewUserAPITest {
    UserAPI userAPI;

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
        userAPI = new UserAPI(token);
        Assert.assertTrue(authorizationAPI.isAuthorized(newUserData));

        //check user registered
        userAPI.getUser(userId);

        //get data of created user
        JsonPath expectedCreatedUser = userAPI.getUser(userId).jsonPath();
        Assert.assertEquals(
                createdUser.getString("username"),
                expectedCreatedUser.getString("username"),
                createdUser + "is not equal to " + expectedCreatedUser
        );

        // login created user
        authorizationAPI.login(newUserData);

        // delete created user
        userAPI.deleteUser(userId);

        // verify user was deleted
        Response response = authorizationAPI.isDeleted(newUserData);
        Assert.assertEquals(response.jsonPath().getString("message"), "User not found!");
    }
}
