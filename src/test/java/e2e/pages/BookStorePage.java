package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookStorePage extends PageBase {
    public BookStorePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='see-book-Git Pocket Guide']")
    private WebElement book;
    @FindBy(css = ".text-right.fullButton .btn-primary")
    private WebElement addToCollectionBtn;
    @FindBy(css = "label#notLoggin-label > a:nth-of-type(1)")
    private WebElement loginSmallBtn;

    public void waitLBook() {
        getWait().forVisibility(book);
        getWait().forVisibility(addToCollectionBtn);
        getWait().forVisibility(loginSmallBtn);
    }

    public void selectAndAddBook() {
        book.click();
        addToCollectionBtn.click();
    }
}