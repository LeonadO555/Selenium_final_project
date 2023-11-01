package e2e.pages;

        import org.openqa.selenium.OutputType;
        import org.openqa.selenium.TakesScreenshot;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.PageFactory;
        import org.openqa.selenium.support.ui.Select;
        import util.ScrollUtils;
        import util.Wait;

        import java.awt.*;
        import java.io.BufferedReader;
        import java.io.File;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.nio.file.Files;
        import java.nio.file.StandardCopyOption;

public class PageBase {
    public WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public Wait getWait() {
        return new Wait(driver);
    }

    public ScrollUtils getScroll() {
        return new ScrollUtils();
    }

    public void click(WebElement element) {
        element.isDisplayed();
        element.click();
    }

    public void selectDropdownText(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

}