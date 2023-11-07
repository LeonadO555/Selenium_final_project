package e2e.setup;

import org.openqa.selenium.chrome.ChromeOptions;

public class DriverUtils {

    public static ChromeOptions configurationChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");

        options.addArguments("start-maximized");
        options.addArguments("--remote-allow-origins=*");//
        return options;
    }
}
