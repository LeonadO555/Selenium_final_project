package api;


import api.account.Account;
import api.account.AuthorizeUser;
import api.account.User;
import com.github.javafaker.Faker;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import schemas.RegisterViewModel;

public class AddNewUserApiTest {

    Account account;

    User user;
    AuthorizeUser authorizeUser;
    Faker faker = new Faker();

    @Test
    public void addNewUserApiTest() {
        String userName = faker.internet().uuid();
        account = new Account();
        RegisterViewModel userData = account.randomDataForUser(userName);
        JsonPath createdUser = account.createUser(userData, 201).jsonPath();
        String userId = createdUser.getString("userID");

        // token
        authorizeUser = new AuthorizeUser();
        String token = authorizeUser.generateToken(userData);
        Assert.assertTrue(authorizeUser.userAuthorized(userData));

        user = new User(token);
        JsonPath actualCreatedUser = user.getUser(200, userId).jsonPath();
        Assert.assertEquals(actualCreatedUser.getString("username"), userData.getUserName());

        // delete
        user.deleteUser(userId);
        // get error message
        Response response = authorizeUser.userDeleted(userData);
        Assert.assertEquals(response.jsonPath().getString("message"), "User not found!");
    }
}