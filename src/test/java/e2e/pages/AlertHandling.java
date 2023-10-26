package e2e.pages;

import org.openqa.selenium.WebDriver;

public class AlertHandling extends PageBase {

    public AlertHandling(WebDriver driver) {
        super(driver);
    }

    public void simpleAlertHandling() {
        getWait().forAlertPresence(driver);
        driver.switchTo().alert().accept();
    }
}
