package api.account;

import e2e.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginBasePage extends PageBase {
    public LoginBasePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@id='userName']")
    WebElement UserName;
    @FindBy(xpath = "//*[@id='password']")
    WebElement Password;
    @FindBy(xpath = "//*[@id='login']")
    WebElement Login;
    @FindBy(xpath = "//*[@id='newUser']")
    WebElement NewUser;
    @FindBy(xpath = "//div[@class='text-right col-md-5 col-sm-12']//button[@id='submit']")
    WebElement LogOut;
    @FindBy(xpath = "//button[@id='gotoStore']")
    WebElement GotoStore;
    @FindBy(xpath = "//a[normalize-space()='Git Pocket Guide']")
    WebElement GitPocketGuide;
    @FindBy(xpath = "//div[@class='text-right fullButton']//button[@id='addNewRecordButton']")
    WebElement AddNewRecordButton;


}
