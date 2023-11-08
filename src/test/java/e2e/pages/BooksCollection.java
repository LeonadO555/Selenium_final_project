package e2e.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ScrollUtils;

import java.time.Duration;

public class BooksCollection extends PageBase{
    public BooksCollection(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id = 'addNewRecordButton']")
    WebElement addToCollectionButton;
    @FindBy(xpath = "//*[@class='element-list collapse show']//li[@id='item-3']//*[@class='text']")
    WebElement profileButton;
    public void scrollToAddToCollectionButton() {
        ScrollUtils.scrollToElement(driver, addToCollectionButton);
        getWait().forVisibility(addToCollectionButton);
    }

    public void waitForLoading() {
        getWait().forVisibility(addToCollectionButton);
        getWait().forClickable(profileButton);
    }

    public void waitForClickable(){
        getWait().forClickable(addToCollectionButton);
    }
    public void clickOnAddToCollectionButton() {
        WebElement addToCollectionButton = driver.findElement(By.id("addNewRecordButton"));
        Actions actions = new Actions(driver);
        actions.moveToElement(addToCollectionButton).click().build().perform();
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
    public void clickOnProfileButton() {
        try {
            profileButton.click();
        } catch (ElementClickInterceptedException e) {
            e.printStackTrace();
        }
    }
}


