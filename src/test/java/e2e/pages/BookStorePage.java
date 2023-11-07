package e2e.pages;

import e2e.PageBase;
import e2e.setup.ApplicationManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class BookStorePage extends PageBase {
    @FindBy(xpath = "//*[@id='login']")
    private WebElement loginBtn;
    @FindBy(id = "userName")
    private WebElement userName;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(xpath = "//*[@id='see-book-Git Pocket Guide']")
    private WebElement book;
    @FindBy(css = ".text-right.fullButton .btn-primary")
    private WebElement addToCollectionBtn;

    private void waitFor() {
        ApplicationManager.getWebDriver().manage().timeouts().implicitlyWait(Duration.of(2, ChronoUnit.SECONDS));
    }

    public BookStorePage doLogin() {
        loginBtn.click();
        waitFor();
        userName.sendKeys("rio5");
        password.sendKeys("rio55W7iii#");
        loginBtn.click();
        return this;
    }

    public void selectAndAddBook() {
        book.click();
        waitFor();
        addToCollectionBtn.click();
    }
}
