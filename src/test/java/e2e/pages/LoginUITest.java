package e2e.pages;

import enums.AccountCredentials;
import org.testng.annotations.Test;

public class LoginUITest extends TestBase {
    LoginPage loginPage;

    @Test
    public void userCanLogin() {
        String userName = "inna";
        String password = "Pass567$";
        loginPage = new LoginPage(app.driver);
        loginPage.login(userName, password);
        loginPage.confirmSuccessfulLogin();
    }

    @Test
    public void userCanNotLoginWithInvalidData(){
        String userName = "inna@gmail.com";
        String password = "ghhgh";
        loginPage = new LoginPage(app.driver);
        loginPage.login(userName, password);
        loginPage.confirmUnsuccessfulLogin();
    }
    @Test
    public void userCanNotLoginWithInvalidPassword(){
        String userName = "inna";
        String password = "1234566";
        loginPage = new LoginPage(app.driver);
        loginPage.login(userName,password);
        loginPage.confirmUnsuccessfulLogin();
    }
}