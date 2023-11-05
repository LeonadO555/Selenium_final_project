package tests;

import api.Account;
import api.LoginPage;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import schemas.LoginViewModel;

public class RegistrationAuthorizationDeletionNewUser {
    LoginPage loginPage;

    Account authorizationAPI = new Account();

    @Test
    public void registerLoginDeleteNewUserViaApi() {

        LoginViewModel newUserData = authorizationAPI.generateNewRandomUser();


        JsonPath createdUser = authorizationAPI.registerNewUser(newUserData).jsonPath();
        String userId = createdUser.getString("userID");

        String token = authorizationAPI.generateToken(newUserData);
        loginPage = new LoginPage(token);
        Assert.assertTrue(authorizationAPI.isAuthorized(newUserData));

        loginPage.getUser(userId);

        JsonPath expectedCreatedUser = loginPage.getUser(userId).jsonPath();
        Assert.assertEquals(
                createdUser.getString("username"),
                expectedCreatedUser.getString("username"),
                createdUser + "is not equal to " + expectedCreatedUser
        );

        authorizationAPI.login(newUserData);

        loginPage.deleteUser(userId);

        Response response = authorizationAPI.isDeleted(newUserData);
        Assert.assertEquals(response.jsonPath().getString("message"), "User not found!");
    }
    }
