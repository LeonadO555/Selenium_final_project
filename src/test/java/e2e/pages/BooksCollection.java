package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BooksCollection extends PageBase{
    public BooksCollection(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id = 'addNewRecordButton']")
    WebElement addToCollectionButton;


}
