package e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.ScrollUtils;

public class BooksPage extends PageBase{
    WebDriver webDriver;
    public BooksPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(text(), 'Git Pocket Guide')]")
    WebElement firstBook;

    @FindBy(xpath = "//a[contains(text(), 'Learning JavaScript Design Patterns')]")
    WebElement secondBook;

    public void waitForLoading() {
        getWait().forVisibility(firstBook);
        getWait().forVisibility(secondBook);
    }
    public void scrollToSecondBook() {
        ScrollUtils.scrollToElement(driver, secondBook);
        getWait().forVisibility(secondBook);
    }
    public void waitForClickable(){
        getWait().forClickable(secondBook);
    }
    public void clickOnSecondBook() {
        WebElement ele = driver.findElement(By.xpath("//a[contains(text(), 'Learning JavaScript Design Patterns')]"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", ele);
        }
    }





