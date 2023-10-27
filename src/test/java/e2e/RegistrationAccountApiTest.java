package e2e;

import api.LoginApi;
import api.account.Account;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import schemas.RegisterModelDto;

public class RegistrationAccountApiTest {

    LoginApi loginApi;
    Account account = new Account();

    @Test
    public void registrationAccountApiTest() {
        RegisterModelDto newUserData = account.createNewRandomAccount();
        JsonPath createdUser = account.registerNewAccount(newUserData).jsonPath();
        String userId = createdUser.getString("userID");


        String token = account.generateToken(newUserData);
        loginApi = new LoginApi(token);
        Assert.assertTrue(account.authorizeAccount(newUserData, token));

        JsonPath expectedCreatedUser = loginApi.getAccount(userId).jsonPath();
        Assert.assertEquals(createdUser.getString("username"), expectedCreatedUser.getString("username"), "Usernames should match");

        loginApi.deleteAccount(userId);
        Response response = account.deleteAccount(newUserData);
        Assert.assertEquals(response.jsonPath().getString("message"), "User not found!", "User should be deleted");
    }
}
