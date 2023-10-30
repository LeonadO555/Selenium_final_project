package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.ScrollUtils;

public class BookStorePage extends PageBase {
    public BookStorePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(text(), 'Git Pocket Guide')]")
    WebElement firstBook;

    @FindBy(xpath = "//*[@id='see-book-Designing Evolvable Web APIs with ASP.NET']")
    WebElement thirdBook;

    public void waitForLoading() {
        getWait().forVisibility(firstBook);
        }

    public void scrollToThirdBook() {
        ScrollUtils.scrollToElement(driver, thirdBook);
        getWait().forVisibility(thirdBook);
    }

    public void clickOnBooksCard() {
        firstBook.click();
    }
}