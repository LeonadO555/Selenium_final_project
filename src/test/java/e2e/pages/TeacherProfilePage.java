package e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import util.ScrollUtils;

public class TeacherProfilePage extends UserBasePage {
    public TeacherProfilePage(WebDriver driver) {

        super(driver);
    }
    @FindBy(xpath = "//*[@class='filter-option-inner-inner']")
    WebElement selectMyRoleDropDown;

    @FindBy(xpath = "//*[@id='bs-select-1-1']")
    WebElement studentDropDown;

    @FindBy(xpath = "//*[@placeholder='Full Name']")
    WebElement fullNameDialog;

    @FindBy(xpath = "//*[@placeholder='Email']")
    WebElement emailDialog;

    @FindBy(xpath = "//*[@id='sw-form-capture-About']")
    WebElement descriptionTextArea;

    @FindBy(xpath = "//*[@id='sw-form-password-input']")
    WebElement oldPasswordDialog;

    @FindBy(xpath = "//*[@id='sw-new-password-input']")
    WebElement newPasswordDialog;

    @FindBy(xpath = "//*[@id='sw-update-profile-btn']")
    WebElement updateProfileButton;

    @FindBy(xpath = " //*[@id='sw-change-password-btn']")
    WebElement changePasswordButton;
    public void waitForLoading() {
        getWait().forClickable(studentDropDown);
        getWait().forVisibility(oldPasswordDialog);
    }

    public void scrollToChangePasswordButton() {
        ScrollUtils.scrollToElement(driver, changePasswordButton);
        getWait().forVisibility(changePasswordButton);
    }

    public void clickSelectMyRoleDropDown() {
        selectMyRoleDropDown.click();
    }

    public void selectRoleToStudentDropDown() {
        studentDropDown.click();
    }
    public void selectDropdownText(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }
    public void clickOnFullNameDialog(String editedFullName) {
        fullNameDialog.click();
        fullNameDialog.clear();
        fullNameDialog.sendKeys(editedFullName);
    }

    public void clickOnEmailDialog(String editedEmail) {
        emailDialog.click();
        emailDialog.clear();
        emailDialog.sendKeys(editedEmail);
    }

    public void clickOnDescriptionTextArea(String editedDescription) {
        descriptionTextArea.click();
        descriptionTextArea.clear();
        descriptionTextArea.sendKeys(editedDescription);
    }

    public void clickOnOldPasswordDialog(String createPassword) {
        oldPasswordDialog.click();
        oldPasswordDialog.clear();
        oldPasswordDialog.sendKeys(createPassword);
    }

    public void clickOnNewPasswordDialog(String editedPassword) {
        newPasswordDialog.click();
        newPasswordDialog.clear();
        newPasswordDialog.sendKeys(editedPassword);
    }

    public void clickOnUpdateProfileButton() {
        updateProfileButton.click();
    }

    public void clickOnChangePasswordButton() {
        changePasswordButton.click();
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
}
