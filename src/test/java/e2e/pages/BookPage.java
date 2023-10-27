package e2e.pages;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.Scroll;

public class BookPage extends PageBase {
    public BookPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@class='text-right fullButton']//*[@id='addNewRecordButton']")
    WebElement addToYourCollectionButton;

    @FindBy(xpath = "//*[@class='element-list collapse show']//li[@id='item-3']//*[@class='text']")
    WebElement profileButton;

    @FindBy(xpath = "//*[@class= 'books-wrapper']")
    WebElement bookInfoForm;

    @FindBy(xpath = "//*[@id='title-wrapper']//*[@id='userName-value']")
    WebElement bookTitle;

    public void waitForLoading() {
        getWait().forVisibility(bookInfoForm);
        getWait().forClickable(bookInfoForm);
    }

    public void waitProfileButtonAfterScroll() {
        Scroll.scrollToElement(driver, profileButton);
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

    public String getTitleBook() {
        return bookTitle.getText();
    }
}
