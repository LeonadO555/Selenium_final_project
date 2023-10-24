package e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ScrollUtils;

import java.time.Duration;
import java.util.NoSuchElementException;

public class BookCardPage extends PageBase {
    public BookCardPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//span[contains(.,'Profile')]")
    WebElement profilePageButton;
    @FindBy(xpath = "//*[contains(text(), 'Book Store API')]")
    WebElement bookStoreApi;
    @FindBy(xpath = "//*[@title='Delete']")
    WebElement deleteButton;
    @FindBy(xpath = "//*[@id='closeSmallModal-ok']")
    WebElement deleteOkButton;
    public void waitForLoading() {
       getWait().forVisibility(profilePageButton);
    }
    public void scrollToLoginButton() {
        ScrollUtils.scrollToElement(driver, bookStoreApi);
        getWait().forVisibility(bookStoreApi);
    }

//    public void clickOnProfilePageButton() {
//        try {
//            scrollToLoginButton();
//            profilePageButton.click();
//        } catch (NoSuchElementException e) {
//            System.out.println("Element not found : " + e.getMessage());
//        }
//    }

    public void clickOnProfilePageButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement profilePageButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(.,'Profile')]")));
            profilePageButton.click();
        } catch (TimeoutException e) {
            System.out.println("Element not found: " + e.getMessage());
        }
    }

    public void clickDeleteButton() {
        try{
        deleteButton.click();
    }   catch (NoSuchElementException e) {
            System.out.println("Element not found : " + e.getMessage());
        }
    }
    public void clickOnDeleteOkButton() {
        deleteOkButton.click();
    }
}
