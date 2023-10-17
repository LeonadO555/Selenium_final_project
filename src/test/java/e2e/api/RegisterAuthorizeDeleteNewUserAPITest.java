package e2e.api;

import api.AuthorizationAPI;
import api.UserAPI;
import com.github.javafaker.Faker;
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
        UserDTO newUserData = generateNewRandomUser();

        //register new user
        JsonPath createdUser = authorizationAPI.registerNewUser(newUserData).jsonPath();
        String userId = createdUser.getString("userID");

        // generate token
        String token = authorizationAPI.generateToken(newUserData);
        userAPI = new UserAPI(token);
        Assert.assertTrue(authorizationAPI.isAuthorized(newUserData));

        // login created user
        authorizationAPI.login(newUserData);

        //get data of created user
        JsonPath expectedCreatedUser = userAPI.getUser(userId).jsonPath();
        Assert.assertEquals(
                createdUser.getString("username"),
                expectedCreatedUser.getString("username"),
                createdUser + "is not equal to " + expectedCreatedUser
        );

        // delete created user
        userAPI.deleteUser(userId);

        // verify user was deleted
        Response response = authorizationAPI.isDeleted(newUserData);
        Assert.assertEquals(response.jsonPath().getString("message"), "User not found!");
    }

    private UserDTO generateNewRandomUser() {
        Faker faker = new Faker();
        UserDTO register = new UserDTO();
        register.setUserName(faker.internet().uuid());
        // due to the faker password generation bug https://github.com/faker-ruby/faker/issues/2512
        // it was decided to hard code it
        register.setPassword("NewTest567&");
        return register;
    }
}
