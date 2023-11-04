package e2e.pages;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.Scroll;

public class ProfilePage extends PageBase {
    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@class= 'text-right col-md-5 col-sm-12']//*[@id ='submit']")
    WebElement logOutButton;

    @FindBy(xpath = "//*[@class = 'rt-tr -odd']//*[@id='delete-record-undefined']")
    WebElement trashButton;

    @FindBy(xpath = "//*[@id ='gotoStore']")
    WebElement goToBookStoreButton;

    @FindBy(xpath = "//*[@class='profile-wrapper']")
    WebElement profileForm;

    @FindBy(xpath = "//*[text()='No rows found']")
    WebElement emptyProfileForm;

    @FindBy(xpath = "//*[@class = 'modal-content']")
    WebElement modalAlert;

    @FindBy(xpath = "//*[@id = 'closeSmallModal-ok']")
    WebElement okButtonInAlert;

    @FindBy(id = "see-book-Git Pocket Guide")
    WebElement addedBookTitle;

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

    public String getAddedBookTitle() {
        return addedBookTitle.getText();
    }

    public void clickDeleteButtonRow() {
        trashButton.click();
    }

    public void waitForLoadingModalAlert() {
        getWait().forVisibility(modalAlert);
    }

    public void modalAlertHandling() {
        okButtonInAlert.click();
    }

    public void checkThatBookDeleted() {
        getWait().forVisibility(emptyProfileForm);
    }

    public void clickLogOutButton() {
        logOutButton.click();
    }

   /* These @FindBy and two methods are related to simpleAlertHandling(). Saved here as an example.
    @FindBy(xpath = "//*[@class='element-list collapse show']//li[@id='item-3']//*[@class='text']")
    WebElement profileButton;

    public void waitProfileButtonAfterScroll() {
        Scroll.scrollToElement(driver, profileButton);
        getWait().forVisibility(profileButton);
        getWait().forClickable(profileButton);
    }

    public void clickProfileButton() {
        profileButton.click();
    }
     */
}
