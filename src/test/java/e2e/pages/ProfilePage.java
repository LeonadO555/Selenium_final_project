package e2e.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import util.ScrollUtils;


public class ProfilePage extends PageBase {
    public ProfilePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[contains(text(), 'Add To Your Collection')]")
    WebElement addToYourCollectionButton;
    @FindBy(xpath = "//span[@data-toggle='tooltip' and contains(@title, 'Delete')]/ancestor::div[contains(@class, 'action-buttons')]")
    WebElement deleteButton;

    public void waitForLoading() {
        getWait().forVisibility(deleteButton);
        getWait().forClickable(deleteButton);
    }

    public void clickDeleteButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", deleteButton);
    }

    public boolean isBookDeleted(String bookTitle) {
        By bookLocator = By.xpath("//a[contains(text(), '" + bookTitle + "')]");
        return !driver.findElements(bookLocator).isEmpty();
        }
    }
