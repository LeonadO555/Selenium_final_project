package e2e;

import api.account.Account;
//import e2e.pages.BookCardPage;
import e2e.pages.BookStorePage;
import e2e.pages.LoginPage;
import e2e.pages.ProfilePage;
import enums.AccountCredentials;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;


public class WorkWithBooksApiViaUiTest extends TestBase {
    Account account;
    LoginPage loginPage;
    ProfilePage profilePage;
    BookStorePage bookStorePage;
//    BookCardPage bookCardPage;

    @Test
    public void workWithBooksApiViaUiTest() {
        account = new Account();
        JsonPath createdAccount = account.createAccount(201).jsonPath();
        String userId = createdAccount.getString("UserId");

        if (userId != null) {
            String expectedUserName = account.randomDataForCreateAccount().getUserName();
            JsonPath actualCreatedAccount = account.getAccount(200, userId).jsonPath();
            String actualUserName = actualCreatedAccount.getString("userName");
            Assert.assertEquals(actualUserName, expectedUserName);

            account.deleteAccount(200, userId);
            JsonPath actualDeletedAccount = account.getAccount(500, userId).jsonPath();
            Assert.assertEquals(actualDeletedAccount.getString("message"), "Error! This user doesn't exist in our DB");
        } else {
            System.out.println("UserId is null or not present in the response.");
        }

        loginPage = new LoginPage(app.driver);
        loginPage.login(AccountCredentials.VALID_USERNAME, AccountCredentials.VALID_PASSWORD);
        loginPage.confirmSuccessfulLogin();

        bookStorePage = new BookStorePage(app.driver);
        bookStorePage.waitForLoading();
        bookStorePage.clickOnBooksCard();
        if (bookStorePage.isBookAdded("Git Pocket Guide")) {
            System.out.println("Book added");
        } else {
            System.out.println("Book not added");
        }

        profilePage = new ProfilePage(app.driver);
        profilePage.clickGoToBookStoreButton();
        profilePage.waitForLoading();
        profilePage.clickDeleteButton();
        Assert.assertTrue(profilePage.isBookDeleted("Git Pocket Guide"));
    }
}

