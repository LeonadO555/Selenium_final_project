package e2e.ui;

import e2e.TestBase;
import e2e.enums.UserCredentials;
import e2e.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    LoginPage loginPage;

    @Test
    public void userCanLoginWithValidData() {
        loginPage = new LoginPage(app.driver);
        loginPage.login(UserCredentials.VALID_USERNAME, UserCredentials.VALID_PASSWORD);
        loginPage.confirmSuccessfulLogin();
    }

    @Test
    public void userCanNotLoginWithInvalidUserName() {
        loginPage = new LoginPage(app.driver);
        loginPage.login(UserCredentials.INVALID_USERNAME, UserCredentials.VALID_PASSWORD);
        loginPage.confirmUnSuccessfulLogin();
    }

    @Test
    public void userCanNotLoginWithInvalidPassword() {
        loginPage = new LoginPage(app.driver);
        loginPage.login(UserCredentials.VALID_USERNAME, UserCredentials.INVALID_PASSWORD);
        loginPage.confirmUnSuccessfulLogin();
    }

    @Test
    public void userCanNotLoginWithInvalidData() {
        loginPage = new LoginPage(app.driver);
        loginPage.login(UserCredentials.INVALID_USERNAME, UserCredentials.INVALID_PASSWORD);
        loginPage.confirmUnSuccessfulLogin();
    }
}
