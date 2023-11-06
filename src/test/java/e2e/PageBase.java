package e2e;

import e2e.setup.ApplicationManager;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class PageBase {

    private final Logger logger = LogManager.getLogManager().getLogger(this.getClass().getName());

    public PageBase() {
        PageFactory.initElements(ApplicationManager.getWebDriver(), this);
    }

    public Logger log() {
        return logger;
    }

}
