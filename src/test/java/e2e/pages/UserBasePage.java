package e2e.pages;

import enums.UserButtons;
import enums.UserTabs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class UserBasePage extends PageBase {
    public UserBasePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='search']")
    WebElement inlineFilter;

    @FindBy(xpath = "//*[@role='dialog']")
    WebElement dialog;

    public void openTab(UserTabs tab) {
        driver.findElement(By.xpath(tab.value)).click();
    }

    public void filterBy(String value) {
        inlineFilter.sendKeys(value);
    }

    public void clickOnButton(UserButtons button) {
        driver.findElement(By.xpath(button.value)).click();
    }
}
