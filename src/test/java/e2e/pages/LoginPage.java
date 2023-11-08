package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='login']")
    private WebElement loginBtn;
    @FindBy(id = "userName")
    private WebElement userNameInput;
    @FindBy(id = "password")
    private WebElement passwordInput;


    public void waitLogin() {
        getWait().forVisibility(loginBtn);
        getWait().forVisibility(userNameInput);
        getWait().forVisibility(passwordInput);
    }

    public void doLogin(String username, String password) {
        loginBtn.click();
        userNameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }

}
