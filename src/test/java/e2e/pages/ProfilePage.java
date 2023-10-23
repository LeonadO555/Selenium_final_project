package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends PageBase {
    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='gotoStore']")
    WebElement goToStoreButton;

    public void clickGoToBookStoreButton() {
        getWait().forClickable(goToStoreButton);
        goToStoreButton.click();
    }
}
