package e2e;

import api.LoginApi;
import api.account.Account;
import e2e.pages.BookCardPage;
import e2e.pages.BookStorePage;
import e2e.pages.LoginPage;
import e2e.pages.ProfilePage;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;
import schemas.RegisterModelDto;

public class WorkWithBooksApiViaUiTest extends TestBase {
    Account account;
    LoginApi loginApi;
    LoginPage loginPage;
    ProfilePage profilePage;
    BookCardPage bookCardPage;
    BookStorePage bookStorePage;

    @Test
    public void workWithBooksApiViaUiTest() {
        account = new Account();
        RegisterModelDto newAccountData = account.createNewRandomAccount();
        JsonPath createdAccount = account.registerNewAccount(newAccountData).jsonPath();
        String userId = createdAccount.getString("userID");

        String token = account.generateToken(newAccountData);
        loginApi = new LoginApi(token);
        Assert.assertTrue(account.authorizeAccount(newAccountData, token));

        JsonPath expectedCreatedAccount = loginApi.getAccount(userId).jsonPath();
        Assert.assertEquals(createdAccount.getString("username"), expectedCreatedAccount.getString("username"), "Usernames should match");

        String newAccountUserName = newAccountData.getUserName();
        String newAccountPassword = newAccountData.getPassword();
        String bookTitle = "Git Pocket Guide";

        loginPage = new LoginPage(app.driver);
        loginPage.loginWithRegistrationData(newAccountUserName, newAccountPassword);
        loginPage.confirmSuccessfulLogin();

        bookStorePage = new BookStorePage(app.driver);
        bookStorePage.waitForLoading();
        bookStorePage.scrollToThirdBook();
        bookStorePage.waitForLoading();
        bookStorePage.clickOnBooksCard();

        bookCardPage = new BookCardPage(app.driver);
        bookCardPage.scrollToAddYourCollectionButton();
        bookCardPage.waitForLoading();
        bookCardPage.clickAddToYourCollectionButton();
        Assert.assertTrue(bookCardPage.isBookAdded(bookTitle));
        bookCardPage.clickOnProfileButton();

        profilePage = new ProfilePage(app.driver);
        profilePage.waitForLoading();
        profilePage.clickDeleteButton();
        profilePage.waitForLoading();
        Assert.assertTrue(profilePage.isBookDeleted(bookTitle));
    }
}

