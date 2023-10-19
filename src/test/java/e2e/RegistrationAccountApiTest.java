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
            JsonPath expectedCreatedAccount = account.getAccount(200, userId).jsonPath();

            String[] attributes = {"firstName", "lastName", "userName", "password"};

            for (String attribute : attributes) {
                String actualValue = createdAccount.getString(attribute);
                String expectedValue = expectedCreatedAccount.getString(attribute);
                Assert.assertEquals(actualValue, expectedValue, attribute + " is not equal expected");
            }

            account.deleteAccount(200, userId);
            JsonPath actualDeletedContact = account.getAccount(500, userId).jsonPath();
            Assert.assertEquals(actualDeletedContact.getString("message"), "Error! This user doesn't exist in our DB");
        } else {
            System.out.println("UserId is null or not present in the response.");
        }
    }
}
