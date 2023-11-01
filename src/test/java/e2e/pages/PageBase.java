package e2e.pages;

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

    public void refreshPage() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(2000);
    }

/* This method handles simpleAlert in browser. But due to infrastructure problems of the site it does not work in this test. Saved here as example
    public void simpleAlertHandling() throws InterruptedException {
        getWait().forAlertPresence();
        for (int i = 0; i < 5; i++) {
            try {
                driver.switchTo().alert().accept();
                break;
            } catch (TimeoutException e) {
                Thread.sleep(2000);
            }
        }
    }
 */
}




