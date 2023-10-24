package e2e;

import api.account.Account;
import api.account.ApiBase;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class UserApiTest {
    Account account;

    @Test
    public void userCanCreateAccountAndDeleteViaApiTest() {
        account = new Account();
        JsonPath createdAccount = account.createAccount(201).jsonPath();
        String UUID = createdAccount.getString("userID");
        JsonPath expectedCreateAccount = account.getAccount(200, UUID).jsonPath();

        List<String> listPaths = new ArrayList<>();
        listPaths.add("userName");
        listPaths.add("password");

        for (String path : listPaths) {
            String actual = createdAccount.getString(path);
            String expected = expectedCreateAccount.getString(path);


            account.getAccount(200, "UUID");

            JsonPath editedContact = account.getAccount(200, "UUID").jsonPath();
            LinkedHashMap<String, String> objectEditedData = new LinkedHashMap<>();
            objectEditedData.put(editedContact.getString("userName"), account.generateRandomDataForCreateAccount().getUserName());
            objectEditedData.put(editedContact.getString("password"), account.generateRandomDataForCreateAccount().getPassword();


            for (Map.Entry<String, String> object : objectEditedData.entrySet()) {
                String actualResult = object.getKey();
                String expectedResult = object.getValue();
               // Assert.assertEquals(actualResult, expectedResult, actualResult + "not equal" + expectedResult);
            }


            account.deleteAccount(200, UUID);
            JsonPath actualDeleteAccount = account.getAccount(500, "UUID").jsonPath();
            Assert.assertEquals(actualDeleteAccount, "UUID");


        }

    }
}
