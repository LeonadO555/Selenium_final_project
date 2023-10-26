
package e2e.apitest;

import api.AuthorizationApi;
import api.UserApi;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import schemas.UserDto;

public class UserCanAuthorizedApiTest {

    UserApi userApi;

    AuthorizationApi authorizationApi = new AuthorizationApi();

    @Test
    public void userCanAuthorizedApiTest() {
        // generate new user
        UserDto newUserData = authorizationApi.generateNewRandomUser();

        //register new user
        JsonPath createdUser = authorizationApi.registerNewUser(newUserData).jsonPath();
        String userId = createdUser.getString("userID");

        // generate token
        String token = authorizationApi.generateToken(newUserData);
        userApi = new UserApi(token);
        Assert.assertTrue(authorizationApi.isAuthorized(newUserData));

        //check user registered
        userApi.getUser(userId);

        //get data of created user
        JsonPath expectedCreatedUser = userApi.getUser(userId).jsonPath();
        Assert.assertEquals(
                createdUser.getString("username"),
                expectedCreatedUser.getString("username"),
                createdUser + "is not equal to " + expectedCreatedUser
        );

        // login created user
        authorizationApi.login(newUserData);

        // delete created user
        userApi.deleteUser(userId);

        // verify user was deleted
        Response response = authorizationApi.isDeleted(newUserData);
        Assert.assertEquals(response.jsonPath().getString("message"), "User not found!");
    }
}
