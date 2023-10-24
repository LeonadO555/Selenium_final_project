package e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class ProfilePage extends PageBase {
    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@title='Delete']")
    WebElement deleteButton;
    @FindBy(xpath = "//*[@id='closeSmallModal-ok']")
    WebElement deleteOkButton;

    public void waitForLoading() {
        getWait().forVisibility(deleteButton);
    }

//    @FindBy(xpath = "//*[@id='gotoStore']")
//    WebElement goToStoreButton;

    //    public void clickGoToBookStoreButton() {
//        try {
//            getWait().forVisibility(goToStoreButton);
//            goToStoreButton.click();
//        } catch (NoSuchElementException e) {
//            System.out.println("Element not found : " + e.getMessage());
//        }
//    }
//}
    public void clickGoToBookStoreButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement goToStoreButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='Delete']")));
            goToStoreButton.click();
        } catch (TimeoutException e) {
            System.out.println("Element not found: " + e.getMessage());
        }
    }
    public void clickDeleteButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='gotoStore']")));
            deleteButton.click();
        } catch (TimeoutException e) {
            System.out.println("Element not found: " + e.getMessage());
        }
    }
//    public void clickOnDeleteOkButton() {
//        deleteOkButton.click();
//    }
}