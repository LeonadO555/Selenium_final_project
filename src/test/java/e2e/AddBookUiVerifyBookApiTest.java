package e2e;


import e2e.pages.BookStorePage;
import e2e.pages.LoginPage;
import org.testng.annotations.Test;


public class AddBookUiVerifyBookApiTest extends TestBase {
    LoginPage loginPage;

    BookStorePage bookStorePage;

    @Test
    public void addBookForExistingUser() {
        String username = "rio5";
        String password = "rio55W7iii#";
        loginPage = new LoginPage(app.driver);
        loginPage.waitLogin();
        loginPage.doLogin(username, password);


        bookStorePage = new BookStorePage(app.driver);
        bookStorePage.waitLBook();
        bookStorePage.selectAndAddBook();

    }
}
