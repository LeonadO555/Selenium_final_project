package api;

import api.account.Authorization;
import api.account.NewUser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import schemas.RegisterModeDTO;


public class CreateDeleteNewUserApiTest {

    Authorization authorization;

    NewUser newUser = new NewUser();


    @Test

    public void createDeleteNewUserApiTest() {
        RegisterModeDTO newUserData = newUser.generateNewRandomUser();//new user
        JsonPath createdUser = newUser.registerNewUser(newUserData).jsonPath();//registration
        String userId = createdUser.getString("userID");

        String token = newUser.generateToken(newUserData);
        authorization = new Authorization(token);//token

        Assert.assertTrue(newUser.isAuthorized(newUserData));

        String actualCreatedUser = authorization.getUser(userId).jsonPath().getString("username");
        String expectedCreatedUser = newUserData.getUserName();
        Assert.assertEquals(actualCreatedUser, expectedCreatedUser, actualCreatedUser + "is not equal to " + expectedCreatedUser);

        authorization.deleteUser(userId);//delete created user
        Response response = newUser.isDeleted(newUserData);
        Assert.assertEquals(response.jsonPath().getString("message"), "User not found!");
    }
}