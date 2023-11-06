package e2e.setup;

import org.openqa.selenium.chrome.ChromeOptions;

public class DriverUtils {

    public static ChromeOptions configurationChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\helen\\IdeaProjects\\Selenium_final_project\\src\\test\\java\\resources\\chromedriver.exe");

        options.addArguments("start-maximized");
        options.addArguments("--remote-allow-origins=*");
        return options;
    }
}
