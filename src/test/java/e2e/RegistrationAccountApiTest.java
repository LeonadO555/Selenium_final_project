package e2e;

import api.account.Account;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

public class RegistrationAccountApiTest {
Account account;

    @Test
    public void registrationAccountApiTest() {
        account = new Account();
        JsonPath createdAccount = account.createAccount(201).jsonPath();
        String userId = createdAccount.getString("UserId");

        if (userId != null) {
        } else {
            System.out.println("UserId is null or not present in the response.");
        }

        if (userId != null) {
            JsonPath expectedCreatedAccount = account.getAccount(200, userId).jsonPath();
            List<String> listPaths = new ArrayList<>();
            listPaths.add("firstName");
            listPaths.add("lastName");
            listPaths.add("userName");
            listPaths.add("password");

            for (String path : listPaths) {
                String actual = createdAccount.getString(path);
                String expected = expectedCreatedAccount.getString(path);
                Assert.assertEquals(actual, expected, "Actual parameter is not equal expected");
            }

            account.deleteAccount(200, userId);
            JsonPath actualDeletedContact = account.getAccount(500, userId).jsonPath();
            Assert.assertEquals(actualDeletedContact.getString("message"), "Error! This user doesn't exist in our DB");
        } else {
            System.out.println("UserId is null or not present in the response.");
        }
    }
}

