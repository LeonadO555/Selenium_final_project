package e2e.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import util.Wait;

public class PageBase {
    public WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public Wait getWait() {
        return new Wait(driver);
    }

    public void click(WebElement element) {
        element.isDisplayed();
        element.click();
    }
}
