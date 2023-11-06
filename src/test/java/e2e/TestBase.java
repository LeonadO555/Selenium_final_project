package e2e;

import e2e.setup.ApplicationManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;


public class TestBase {
    @BeforeTest
    public void setup() {
        ApplicationManager.getWebDriver();
    }

    @AfterTest
    public void teardown() throws IOException {
        e2e.setup.ApplicationManager.closeWebDriver();
    }
}