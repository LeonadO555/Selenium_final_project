package e2e;

import api.account.Account;
import com.github.javafaker.Faker;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

public class RegistrationAccountApiTest {

Faker faker = new Faker();
Account account;

    @Test
    public void registrationAccountApiTest() {
        String createFirstName = faker.internet().uuid();
        String createLastName = faker.internet().uuid();
        String createUserName = faker.internet().uuid();
        String createPassword = faker.internet().uuid();

        account = new Account("");
        JsonPath createdAccount = account.createAccount(201).jsonPath();
        int userId = createdAccount.getInt("id");

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

            account.deleteAccount(200, userId);
            JsonPath actualDeletedContact = account.getAccount(500, userId).jsonPath();
            Assert.assertEquals(actualDeletedContact.getString("message"), "Error! This contact doesn't exist in our DB");
        }
    }
}
