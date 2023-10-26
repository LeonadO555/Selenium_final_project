package e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import util.Scroll;

public class ProfilePage extends PageBase {
    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id ='searchBox']")
    WebElement searchInput;

    @FindBy(xpath = "//*[@class ='input-group-append']")
    WebElement searchButton;

    @FindBy(xpath = "//*[@class= 'text-right col-md-5 col-sm-12']//*[@id ='submit']")
    WebElement logOutButton;

    @FindBy(xpath = "//*[@class='rt-tr-group'][1]")
    WebElement firstTableRow;

    @FindBy(xpath = "//*[@id='see-book-Git Pocket Guide']")
    WebElement bookName;

    @FindBy(xpath = "//*[@class = 'rt-tr -odd']//*[@id='delete-record-undefined']")
    WebElement trashButton;

    @FindBy(xpath = "//*[@class='text-right button di']//*[@id ='submit']")
    WebElement deleteAllBooksButton;

    @FindBy(xpath = "//*[@role='dialog']")
    WebElement deleteAllBooksDialog;

    @FindBy(xpath = "//*[@id='closeSmallModal-ok']")
    WebElement okButtonInDeleteAllBooksDialog;

    @FindBy(xpath = "//*[@class= 'text-center button']//*[@id ='submit']")
    WebElement deleteAccountButton;

    @FindBy(xpath = "//*[@id ='gotoStore']")
    WebElement goToBookStoreButton;

    @FindBy(xpath = "//*[@class='profile-wrapper']")
    WebElement profileForm;

    @FindBy(xpath = "//*[text()='No rows found']")
    WebElement emptyProfileForm;


    public void waitForLoadingBookStoreButton() {
        getWait().forVisibility(goToBookStoreButton);
        getWait().forClickable(goToBookStoreButton);
    }

    public void scrollToBookStoreButton() {
        Scroll.scrollToElement(driver, goToBookStoreButton);
        getWait().forVisibility(goToBookStoreButton);
    }

    public void clickGoToBookStoreButton() {
        try {
            goToBookStoreButton.click();
        } catch (ElementClickInterceptedException e) {
            e.printStackTrace();
        }
    }

    public void waitForLoadingProfileForm() {
        getWait().forVisibility(profileForm);
        getWait().forClickable(profileForm);
    }

    public void clickBookName() {
        bookName.click();
    }

    public void checkThatBookAdded() {
        WebElement title = driver.findElement(By.id("see-book-Git Pocket Guide"));
        String actualTitle = title.getText();
        String expectedElementText = "Git Pocket Guide";
        Assert.assertEquals(actualTitle, expectedElementText, "Expected and Actual are not the same");
    }

    public void clickTrashButton() {
        trashButton.click();
    }

    public void checkThatBookDeleted() {
        getWait().forVisibility(emptyProfileForm);
    }
//
//
//    {
//        WebElement title = driver.findElement(By.id("see-book-Git Pocket Guide"));
//        String actualTitle = title.getText();
//        String expectedElementText = "Git Pocket Guide";
//        Assert.assertEquals(actualTitle, expectedElementText, "Expected and Actual are not the same");
//    }


    //*[text()="No rows found"]
//    id="see-book-“+nameBook+””
    public void confirmBookWasDeleted() {
        getWait().forInvisibility(bookName);
    }

    public void clickLogOutButton() {
        logOutButton.click();
    }

}
