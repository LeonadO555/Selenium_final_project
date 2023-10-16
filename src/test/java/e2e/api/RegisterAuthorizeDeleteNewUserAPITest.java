package e2e.api;

import api.AuthorizationAPI;
import api.UserAPI;
import com.github.javafaker.Faker;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;
import schemas.UserDTO;

public class RegisterAuthorizeDeleteNewUserAPITest {

    UserAPI userAPI;

    AuthorizationAPI authorizationAPI = new AuthorizationAPI();

    @Test
    public void registerLoginDeleteNewUserViaApi() {
        // generate new token
        UserDTO newUserData = generateNewRandomUser();
        String token = authorizationAPI.generateToken(newUserData);
        userAPI = new UserAPI(token);

        //register new user
        JsonPath createdUser = userAPI.registerNewUser(newUserData).jsonPath();
        String userId = createdUser.getString("userId");
        //get data of new contact and compare
        JsonPath expectedCreatedUser = userAPI.getUser(userId).jsonPath();
        Assert.assertEquals(createdUser, expectedCreatedUser, createdUser + "is not equal to " + expectedCreatedUser);

        // login created user
        authorizationAPI.login(newUserData);
        Assert.assertTrue(authorizationAPI.isAuthorized(newUserData));

        // delete created user
        userAPI.deleteUser(userId);
        // verify user was deleted
        String responseMessage = userAPI.getUser(userId).jsonPath().getString("message");
        Assert.assertEquals(responseMessage, "User not found!");
    }

    private UserDTO generateNewRandomUser() {
        Faker faker = new Faker();
        UserDTO register = new UserDTO();
        register.setUserName(faker.internet().uuid());
        register.setPassword(faker.internet().uuid());
        return register;
    }
}
