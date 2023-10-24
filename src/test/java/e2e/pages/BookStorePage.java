package e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BookStorePage extends PageBase {
    public BookStorePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(text(), 'Git Pocket Guide')]")
    WebElement firstBook;

    public void waitForLoading() {
        getWait().forVisibility(firstBook);
    }

    public boolean isBookAdded(String bookTitle) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@ng-reflect-result, '" + bookTitle + "')]")));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
    public void clickOnBooksCard() {
        firstBook.click();
    }
}