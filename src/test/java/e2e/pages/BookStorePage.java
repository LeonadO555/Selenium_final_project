package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookStorePage extends PageBase {

    public BookStorePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'Git Pocket Guide')]")
    WebElement firstBookLink;

    @FindBy(xpath = "//*[@class= 'col-12 mt-4 col-md-6']")
    WebElement bookStoreForm;

//    public void waitForLoadingBookStoreForm() {
//        getWait().forVisibility(bookStoreForm);
//        getWait().forClickable(bookStoreForm);
//    }

    public void waitForLoading() {
        getWait().forVisibility(bookStoreForm);
        getWait().forClickable(bookStoreForm);
    }

    public void waitForBookInTable() {
        getWait().forVisibility(firstBookLink);
        getWait().forClickable(firstBookLink);
    }

    public void clickFirstBookLink() {
        firstBookLink.click();
    }
}
