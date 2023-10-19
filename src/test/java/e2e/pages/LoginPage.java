package e2e.pages;

import enums.AccountCredentials;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@placeholder='UserName']")
    WebElement userNameInput;

    @FindBy(xpath = "//*[@placeholder='Password']")
    WebElement passwordInput;

    @FindBy(xpath = "//*[@id='login']")
    WebElement loginButton;

    public void waitForLoading() {
//        getWait().forVisibility(loginForm);
        getWait().forVisibility(userNameInput);
        getWait().forVisibility(passwordInput);
        getWait().forClickable(loginButton);
    }
    public void login(AccountCredentials userName, AccountCredentials password) {
        userNameInput.sendKeys(userName.value);
        passwordInput.sendKeys(password.value);
        click(loginButton);


    }
}
