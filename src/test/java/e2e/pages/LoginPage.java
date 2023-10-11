package e2e.pages;

import enums.StudentCredentials;
import enums.TeacherCredentials;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class LoginPage extends PageBase {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@href='/sign-in']")
    WebElement signInForm;

    @FindBy(xpath = "//*[@name='email']")
    WebElement emailInput;

    @FindBy(xpath = "//*[@name='password']")
    WebElement passwordInput;

    @FindBy(xpath = "//*[@id='sw-sign-in-submit-btn']")
    WebElement signInButton;

    @FindBy(xpath = "//*[@id='sw-go-to-sign-up-btn']")
    WebElement signUpLink;

    @FindBy(xpath = "//*[@href='/forgot-password']")
    WebElement forgotPasswordLink;

    @FindBy(xpath = "//*[contains(@class, 'MuiBox-root css-jf8tht') and contains(text(), 'Sign up')]")
    WebElement signupButton;


    public void waitForLoading() {
        getWait().forVisibility(signInForm);
        getWait().forVisibility(emailInput);
        getWait().forVisibility(passwordInput);
        getWait().forClickable(signupButton);
    }

    public void loginAsTeacher(TeacherCredentials email, TeacherCredentials password) {
        try {
            getWait().forInvisibility(signInForm);
            emailInput.sendKeys(email.value);
            passwordInput.sendKeys(password.value);
            click(signInButton);
        } catch (Exception e) {

            System.out.println("An error occurred while logging in: " + e.getMessage());
        }
    }

    public void loginAsStudent(StudentCredentials email, StudentCredentials password) {
        try {
            getWait().forInvisibility(signInForm);
            emailInput.sendKeys(email.value);
            passwordInput.sendKeys(password.value);
            click(signInButton);
        } catch (Exception e) {

            System.out.println("An error occurred while logging in: " + e.getMessage());
        }
    }

    public void confirmSuccessfulLogin() {
        getWait().forInvisibility(signInForm);
    }

    public void confirmUnsuccessfulLogin() {
        getWait().forVisibility(signInForm);
    }

    public void clickOnSignupButton () {
        signupButton.click();
    }

    public void clickOnRegistrationLink() {
        click(signUpLink);
    }

    public void clickOnForgotPasswordLink() {
        click(forgotPasswordLink);
    }

    public void takeScreenshotLoginButton() throws IOException {
        takeAndCompareScreenshot("loginButton", signInButton);
    }
}
