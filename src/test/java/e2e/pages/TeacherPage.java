package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TeacherPage extends PageBase {

    public TeacherPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(xpath = "//*[@id='home-header-logged-in-teachers']//*[@type='button']")
    WebElement myProfileButton;
    @FindBy(xpath = "//*[@class='text-center sw-dropdown']")
    WebElement myProfileDropDown;
    @FindBy(xpath = "//*[@class='filter-option-inner-inner']")
    WebElement selectMyRoleDropDown;

    public void waitForLoading() {
        getWait().forVisibility(myProfileButton);
        getWait().forClickable(myProfileDropDown);
        getWait().forVisibility(selectMyRoleDropDown);
    }

    public void clickOnMyProfileButton() {
        myProfileButton.click();
    }
    public void clickOnMyProfileDropDown() {
        myProfileDropDown.click();
    }
}
