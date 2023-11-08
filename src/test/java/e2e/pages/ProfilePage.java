package e2e.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;


public class ProfilePage extends PageBase{
    public ProfilePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//span[@data-toggle='tooltip' and contains(@title, 'Delete')]/ancestor::div[contains(@class, 'action-buttons')]")
    WebElement deleteBookButton;
    @FindBy(xpath = "//*[@class = 'modal-content']")
    WebElement modalAlert;
    @FindBy(xpath = "//*[@id = 'closeSmallModal-ok']")
    WebElement okButton;

    public void waitForLoading() {
        getWait().forVisibility(deleteBookButton);
    }
    public void waitForClickable(){
        getWait().forClickable(deleteBookButton);
    }

    public void waitForLoadingModalAlert() {
        getWait().forVisibility(modalAlert);
    }
    public void clickDeleteButton() {
        deleteBookButton.click();
    }
    public void clickOkButton(){
        okButton.click();
    }
    public boolean isBookDeleted(String bookTitle) {
        By bookLocator = By.xpath("//a[contains(text(), '" + bookTitle + "')]");
        return !driver.findElements(bookLocator).isEmpty();
    }
}
