package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import util.Wait;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class PageBase {

    private final Logger logger = LogManager.getLogManager().getLogger(this.getClass().getName());

    public WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Wait getWait() {
        return new Wait(driver);
    }


    public Logger log() {
        return logger;
    }

    public void click(WebElement element) {
        element.isDisplayed();
        element.click();
    }

}