package api;


import api.account.Account;
import api.account.AuthorizeUser;
import api.account.User;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;
import schemas.RegisterViewModel;

import java.util.ArrayList;
import java.util.List;

public class AddNewUserApiTest {

    Account account;
    User user;
    AuthorizeUser authorizeUser;

    @Test
    public void addNewUserApiTest() {
        account = new Account();
        RegisterViewModel userData = account.randomDataForCreateUser();
        JsonPath createdUser = account.createUser(userData, 201).jsonPath();
        String userId = createdUser.getString("userID");


        // generate token
        authorizeUser = new AuthorizeUser();
        String token = authorizeUser.generateToken(userData);
        Assert.assertTrue(authorizeUser.userAuthorized(userData));

        //check user registered
        user = new User(token);
        JsonPath actualCreatedUser = user.getUser(200, userId).jsonPath();
        Assert.assertEquals(actualCreatedUser.getString("username"), userData.getUserName());
    }
}