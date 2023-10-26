package e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import util.Scroll;

public class BookPage extends PageBase {
    public BookPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@class='text-right fullButton']//*[@id='addNewRecordButton']")
    WebElement addToYourCollectionButton;

    @FindBy(xpath = "//*[@class='text-left fullButton']//*[@id='addNewRecordButton']")
    WebElement backToBookStoreButton;

    @FindBy(xpath = "//*[@id='title-wrapper']//*[@id='userName-value']")
    WebElement titleName;

    @FindBy(xpath = "")
    WebElement bookAddedPopUpDialog;

    @FindBy(xpath = "")
    WebElement okButtonOnBookAddedPopUpDialog;

    @FindBy(xpath = "//*[@class='element-list collapse show']//li[@id='item-3']//*[@class='text']")
    WebElement profileButton;

    @FindBy(xpath = "//*[@class= 'books-wrapper']")
    WebElement bookInfoForm;


    public void waitForLoadingBookInfoForm() {
        getWait().forVisibility(bookInfoForm);
        getWait().forClickable(bookInfoForm);
    }

    public void scrollToProfileButton() {
        Scroll.scrollToElement(driver, profileButton);
        getWait().forVisibility(profileButton);
        getWait().forClickable(profileButton);
    }

    public void waitForLoadingProfileButton() {
        getWait().forVisibility(profileButton);
        getWait().forClickable(profileButton);
    }


    public void clickAddToYourCollectionButton() {
        try {
            addToYourCollectionButton.click();
        } catch (ElementClickInterceptedException e) {
            e.printStackTrace();
        }
    }

    public void clickProfileButton() {
        profileButton.click();
    }

    public String checkThatSelectedBookOpened() {
        WebElement title = driver.findElement(By.xpath("//*[@id='title-wrapper']//*[@id='userName-value']"));
        String actualTitle = title.getText();
        String expectedElementText = "Git Pocket Guide";
        Assert.assertEquals(actualTitle, expectedElementText, "Expected and Actual are not same");
        return actualTitle;
    }
}
