package e2e;

import api.Login;
import api.account.Account;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import schemas.RegisterModelDto;

public class RegistrationAccountApiTest {

    Login login;
    Account account = new Account();

    @Test
    public void registrationAccountApiTest() {
        RegisterModelDto newAccountData = account.createNewRandomAccount();
        JsonPath createdAccount = account.registerNewAccount(newAccountData).jsonPath();
        String userId = createdAccount.getString("userID");


        String token = account.generateToken(newAccountData);
        login = new Login(token);
        Assert.assertTrue(account.authorizeAccount(newAccountData, token));

        JsonPath expectedCreatedAccount = login.getAccount(userId).jsonPath();
        Assert.assertEquals(createdAccount.getString("username"), expectedCreatedAccount.getString("username"), "Usernames should match");

        login.deleteAccount(userId);
        Response response = account.deleteAccount(newAccountData);
        Assert.assertEquals(response.jsonPath().getString("message"), "User not found!", "User should be deleted");
    }
}
