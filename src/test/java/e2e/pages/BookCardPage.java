package e2e.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ScrollUtils;
import java.time.Duration;

public class BookCardPage extends PageBase {
    public BookCardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[contains(text(), 'Add To Your Collection')]")
    WebElement addToYourCollectionButton;
    @FindBy(xpath = "//*[contains(text(), 'Profile')]")
    WebElement profileButton;

    public void scrollToAddYourCollectionButton() {
        ScrollUtils.scrollToElement(driver, addToYourCollectionButton);
        getWait().forVisibility(addToYourCollectionButton);
    }

    public void waitForLoading() {
        getWait().forVisibility(addToYourCollectionButton);
        getWait().forClickable(profileButton);
    }
    public void clickAddToYourCollectionButton(){
        addToYourCollectionButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (TimeoutException noAlertException) {
            }
    }

    public boolean isBookAdded(String bookTitle) {
        By bookLocator = By.xpath("//*[contains(@ng-reflect-result, '" + bookTitle + "')]");
        try {
            WebElement book = driver.findElement(bookLocator);
            return !book.isDisplayed();
        } catch (NoSuchElementException e) {
            return true;
        }
    }

    public void clickOnProfileButton(){
        profileButton.click();
    }
}
