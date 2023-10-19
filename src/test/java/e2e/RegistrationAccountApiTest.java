package e2e;

import api.account.Account;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationAccountApiTest {
    Account account;
    @Test
    public void registrationAccountApiTest() {
        account = new Account();
        JsonPath createdAccount = account.createAccount(201).jsonPath();
        String userId = createdAccount.getString("UserId");

        if (userId != null) {
            String expectedUserName = account.randomDataForCreateAccount().getUserName();
            JsonPath actualCreatedAccount = account.getAccount(200, userId).jsonPath();
            String actualUserName = actualCreatedAccount.getString("userName");
            Assert.assertEquals(actualUserName, expectedUserName);

            account.deleteAccount(200, userId);
            JsonPath actualDeletedContact = account.getAccount(500, userId).jsonPath();
            Assert.assertEquals(actualDeletedContact.getString("message"), "Error! This user doesn't exist in our DB");
        } else {
            System.out.println("UserId is null or not present in the response.");
        }
    }
}
