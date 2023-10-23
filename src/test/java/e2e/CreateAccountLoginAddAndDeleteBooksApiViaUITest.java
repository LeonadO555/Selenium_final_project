package e2e;

import api.account.Account;
import e2e.pages.BookCardPage;
import e2e.pages.BookStorePage;
import e2e.pages.LoginPage;
import e2e.pages.ProfilePage;
import enums.AccountCredentials;
import io.restassured.path.json.JsonPath;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class CreateAccountLoginAddAndDeleteBooksApiViaUITest extends TestBase {
    Account account;
    LoginPage loginPage;
    ProfilePage profilePage;
    BookStorePage bookStorePage;
    BookCardPage bookCardPage;
    @Test
    public void createAccountLoginAddAndDeleteBooksApiViaUITest() {
        account = new Account();
        JsonPath createdAccount = account.createAccount(201).jsonPath();
        String userId = createdAccount.getString("UserId");

        if (userId != null) {
            String expectedUserName = account.randomDataForCreateAccount().getUserName();
            JsonPath actualCreatedAccount = account.getAccount(200, userId).jsonPath();
            String actualUserName = actualCreatedAccount.getString("userName");
            Assert.assertEquals(actualUserName, expectedUserName);

            account.deleteAccount(200, userId);
            JsonPath actualDeletedContact = account.getAccount(500, userId).jsonPath();
            Assert.assertEquals(actualDeletedContact.getString("message"), "Error! This user doesn't exist in our DB");
        } else {
            System.out.println("UserId is null or not present in the response.");
        }

        loginPage = new LoginPage(app.driver);
        loginPage.login(AccountCredentials.VALID_USERNAME, AccountCredentials.VALID_PASSWORD);
        loginPage.confirmSuccessfulLogin();

//        profilePage = new ProfilePage(app.driver);
//        profilePage.clickGoToBookStoreButton();

        bookStorePage = new BookStorePage(app.driver);
        bookStorePage = new BookStorePage(app.driver);
        bookStorePage.clickOnBooksCard();

        List<WebElement> books = bookStorePage.getBooks();
        if (!books.isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(books.size());
            WebElement randomBook = books.get(randomIndex);

            String title = bookCardPage.getTitle(randomBook);
            String author = bookCardPage.getAuthor(randomBook);

            bookCardPage.clickAddButton(randomBook);
            bookCardPage.clickOnProfilePageButton();
            Assert.assertTrue(bookStorePage.isBookInCollection(title, author));

            bookCardPage.clickDeleteButton();
            bookCardPage.clickOnDeleteOkButton();
            Assert.assertFalse(bookStorePage.isBookInCollection(title, author));
        } else {
            System.out.println("No books found on the page.");
        }
    }
}

