package e2e;

import e2e.pages.LoginPage;
import enums.AccountCredentials;
import org.testng.annotations.Test;

public class LoginApiTest extends TestBase {
    LoginPage loginPage;
    @Test
    public void userCanLoginWithValidData() {
        loginPage = new LoginPage(app.driver);
        loginPage.login(AccountCredentials.VALID_USERNAME, AccountCredentials.VALID_PASSWORD);
        loginPage.confirmSuccessfulLogin();
    }

    @Test
    public void userCanNotLoginWithInvalidEmail() {
        loginPage = new LoginPage(app.driver);
        loginPage.login(AccountCredentials.INVALID_USERNAME, AccountCredentials.VALID_PASSWORD);
        loginPage.confirmUnsuccessfulLogin();
    }

    @Test
    public void userCanNotLoginWithInvalidPassword() {
        loginPage = new LoginPage(app.driver);
        loginPage.login(AccountCredentials.VALID_USERNAME, AccountCredentials.INVALID_PASSWORD);
        loginPage.confirmUnsuccessfulLogin();
    }

    @Test
    public void userCanNotLoginWithInvalidData() {
        loginPage = new LoginPage(app.driver);
        loginPage.login(AccountCredentials.INVALID_USERNAME, AccountCredentials.INVALID_PASSWORD);
        loginPage.confirmUnsuccessfulLogin();
    }
}
