package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BooksPage extends PageBase{
    public BooksPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(text(), 'Git Pocket Guide')]")
    WebElement firstBook;

    @FindBy(xpath = "//a[contains(text(), 'Learning JavaScript Design Patterns')]")
    WebElement secondBook;

    public void waitForLoading() {
        getWait().forVisibility(firstBook);
    }

    public void clickOnSecondBook() {
        getWait().forVisibility(secondBook);
        secondBook.click();
    }
}
