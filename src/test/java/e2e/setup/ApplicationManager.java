package e2e.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplicationManager {
    public static WebDriver webDriver;

    public static WebDriver getWebDriver() {
        if (webDriver == null) {
            webDriver = new ChromeDriver(DriverUtils.configurationChromeOptions());
        }
        return webDriver;
    }

    public static void closeWebDriver() {
        webDriver.close();
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }
}
