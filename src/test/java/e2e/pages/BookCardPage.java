package e2e.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookCardPage {

    @FindBy(xpath = "//*[@id='addNewRecordButton']")
    WebElement addToYourCollection;
    @FindBy(xpath = "//*[@id='item-3']//*[contains(text(), 'Profile')]")
    WebElement profilePageButton;
    @FindBy(xpath = "//*[@id='delete-record-undefined']")
    WebElement deleteButton;
    @FindBy(xpath = "//*[@id='closeSmallModal-ok']")
    WebElement deleteOkButton;
    public String getTitle(WebElement randomBook) {
        return null;
    }

    public String getAuthor(WebElement randomBook) {
        return null;
    }

    public void clickAddButton(WebElement randomBook) {
        addToYourCollection.click();
    }

    public void clickOnProfilePageButton(){
        profilePageButton.click();
    }

    public void clickDeleteButton() {
        deleteButton.click();
    }
    public void clickOnDeleteOkButton() {
        deleteOkButton.click();
    }
}
