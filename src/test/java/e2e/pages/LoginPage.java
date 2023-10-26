package e2e.pages;

import e2e.enums.UserCredentials;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id = 'userForm']")
    WebElement loginForm;

    @FindBy(xpath = "//*[@id = 'userName']")
    WebElement userNameInput;

    @FindBy(xpath = "//*[@id = 'password']")
    WebElement passwordInput;

    @FindBy(xpath = "//*[@id = 'login']")
    WebElement loginButton;

    @FindBy(xpath = "//*[@id = 'newUser']")
    WebElement newUserButton;

    public void login(UserCredentials username, UserCredentials password) {
        userNameInput.sendKeys(username.value);
        passwordInput.sendKeys(password.value);
        click(loginButton);
    }

    public void confirmSuccessfulLogin() {
        getWait().forInvisibility(loginForm);
    }

    public void confirmUnSuccessfulLogin() {
        getWait().forVisibility(loginForm);
    }

    public void confirmLoginFormOpened() {
        getWait().forVisibility(loginForm);
    }

}
