package e2e.pages;

import org.openqa.selenium.*;

public class AlertHandling extends PageBase {

    public AlertHandling(WebDriver driver) {
        super(driver);
    }

    public void waitForAlertPresence() {
        getWait().forAlertPresence(driver);
    }

    public void simpleAlertHandling() {
//        driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
    }

    public void confirmationAlertHandling() {
        // This step will result in an alert on screen
        WebElement element = driver.findElement(By.id("confirmButton"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
        Alert confirmationAlert = driver.switchTo().alert();
        String alertText = confirmationAlert.getText();
        System.out.println("Alert text is " + alertText);
        confirmationAlert.accept();
    }
}
