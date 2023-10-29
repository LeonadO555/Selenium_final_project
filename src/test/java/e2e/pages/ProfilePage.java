package e2e.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ScrollUtils;

import java.time.Duration;

public class ProfilePage extends PageBase {
    public ProfilePage(WebDriver driver) {
        super(driver);
    }
//    @FindBy(xpath = "//a[contains(text(), 'Git Pocket Guide')]")
//    WebElement firstBook;
//    @FindBy(xpath = "//*[@id='see-book-Designing Evolvable Web APIs with ASP.NET']")
//    WebElement thirdBook;
    @FindBy(xpath = "//*[contains(text(), 'Add To Your Collection')]")
    WebElement addToYourCollectionButton;
//    @FindBy(xpath = "//*[contains(text(), 'Profile')]")
//    WebElement profileButton;
    @FindBy(xpath = "//span[@data-toggle='tooltip' and contains(@title, 'Delete')]/ancestor::div[contains(@class, 'action-buttons')]")
    WebElement deleteButton;
//    public void scrollToThirdBook() {
//        ScrollUtils.scrollToElement(driver, thirdBook);
//        getWait().forVisibility(thirdBook);
//    }
    public void scrollToAddYourCollectionButton() {
        ScrollUtils.scrollToElement(driver, addToYourCollectionButton);
        getWait().forVisibility(addToYourCollectionButton);
    }
    public void waitForLoading() {
        getWait().forVisibility(deleteButton);
        getWait().forClickable(deleteButton);
//        getWait().forVisibility(firstBook);
    }
//    public void clickOnBooksCard() {
//        firstBook.click();
//    }
//    public void clickAddToYourCollectionButton(){
//        addToYourCollectionButton.click();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        try {
//            wait.until(ExpectedConditions.alertIsPresent());
//            Alert alert = driver.switchTo().alert();
//            alert.accept();
//        } catch (TimeoutException noAlertException) {
//        }
//    }
//
//    public boolean isBookAdded(String bookTitle) {
//        By bookLocator = By.xpath("//*[contains(@ng-reflect-result, '" + bookTitle + "')]");
//        try {
//            WebElement book = driver.findElement(bookLocator);
//            return !book.isDisplayed();
//        } catch (NoSuchElementException e) {
//            return true;
//        }
//    }
//
//    public void clickOnProfileButton(){
//        profileButton.click();
//    }

    public void clickDeleteButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", deleteButton);
    }

    public boolean isBookDeleted(String bookTitle) {
        By bookLocator = By.xpath("//a[contains(text(), '" + bookTitle + "')]");
        return !driver.findElements(bookLocator).isEmpty();
        }
    }
