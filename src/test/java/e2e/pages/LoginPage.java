package e2e.pages;

import enums.AccountCredentials;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.ScrollUtils;

public class LoginPage extends PageBase {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@id='userForm']")
    WebElement userForm;
    @FindBy(xpath = "//*[@id='userName']")
    WebElement userNameInput;
    @FindBy(xpath = "//*[@id='password']")
    WebElement passwordInput;
    @FindBy(xpath = "//*[@id='login']")
    WebElement loginButton;

    public void waitForLoading() {
        getWait().forVisibility(userForm);
        getWait().forVisibility(userNameInput);
        getWait().forVisibility(passwordInput);
        getWait().forClickable(loginButton);
    }

    public void scrollToLoginButton() {
        ScrollUtils.scrollToElement(driver, loginButton);
        getWait().forVisibility(loginButton);
    }

    public void login(AccountCredentials userName, AccountCredentials password) {
        loginButton.click();
        scrollToLoginButton();
        userNameInput.sendKeys(userName.value);
        passwordInput.sendKeys(password.value);
        click(loginButton);
    }

    public void loginWithRegistrationData(String userName, String password){
        loginButton.click();
        scrollToLoginButton();
        userNameInput.sendKeys(userName);
        passwordInput.sendKeys(password);
        click(loginButton);
    }

    public void confirmSuccessfulLogin () {
            getWait().forInvisibility(userForm);
        }

    public void confirmUnsuccessfulLogin() {
        getWait().forVisibility(userForm);
    }
}