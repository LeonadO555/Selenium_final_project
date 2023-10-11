package e2e.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ScrollUtils;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.List;
import java.io.IOException;


public class RegistrationPage extends TeacherProfilePage {

    public RegistrationPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(xpath = "//*[contains(text(), 'Select your role')]")
    WebElement roleDropDown;

    @FindBy(xpath = "//*[@class='dropdown-item' and @id='bs-select-1-0']")
    WebElement teacherDropDown;

    @FindBy(xpath = "//*[contains(text(), 'student') and @class='text']")
    WebElement studentDropDown;

    @FindBy(xpath = "//*[@placeholder='Full Name']")
    WebElement fullNameDialog;

    @FindBy(xpath = "//*[@placeholder='Email']")
    WebElement emailDialog;

    @FindBy(xpath = "//*[@placeholder='Password']")
    WebElement passwordDialog;

    @FindBy(xpath = "//*[@class='checkmark position-relative sw-checkbox']")
    WebElement privacyCheckbox;

    @FindBy(xpath = "//*[@id='sw-sign-up-submit-btn']")
    WebElement signupButton;

    public void waitForLoading() {
        getWait().forVisibility(roleDropDown);
        getWait().forClickable(studentDropDown);
        getWait().forVisibility(privacyCheckbox);
    }

    public void selectRoleToTeacherDropDown() {
        roleDropDown.click();
        teacherDropDown.click();
    }

    public void selectRoleToStudentDropDown() {
        roleDropDown.click();
        studentDropDown.click();
    }

    public void fillFullNameDialog(String createFullName) {
        fullNameDialog.click();
        fullNameDialog.clear();
        fullNameDialog.sendKeys(createFullName);
    }

    public void fillEmailDialog(String createEmail) {
        emailDialog.click();
        emailDialog.clear();
        emailDialog.sendKeys(createEmail);
    }

    public void fillPasswordDialog(String createPassword) {
        passwordDialog.click();
        passwordDialog.clear();
        passwordDialog.sendKeys(createPassword);
    }

    public void clickOnCheckbox() {
        privacyCheckbox.click();
    }

    public void scrollToSignupButton() {
        ScrollUtils.scrollToElement(driver, signupButton);
        getWait().forVisibility(signupButton);
    }

    public boolean clickOnSubmitSignUpButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sw-sign-up-submit-btn']")));
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getFullName() {
        WebElement fullNameElement = driver.findElement(By.xpath("//*[@id='sw-form-capture-full_name-input']"));
        return fullNameElement.getAttribute("value");
    }
    public String getEmail() {
        WebElement emailElement = driver.findElement(By.xpath("//*[@id='sw-form-capture-email-input']"));
        return emailElement.getAttribute("value");
    }

    public String getPassword() {
        WebElement passwordElement = driver.findElement(By.xpath("//*[@placeholder='Password']"));
        return passwordElement.getAttribute("value");
    }
    public boolean checkAlert() {
        try {
            WebDriverWait waitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            Alert alert = waitWait.until(ExpectedConditions.alertIsPresent());

            String alertText = alert.getText();
            System.out.println("Alert text: " + alertText);
            alert.accept();
        } catch (TimeoutException e) {
            System.out.println("Alert не найден.");
        }
        return false;
    }
}