package e2e.ui;

import api.AuthorizationAPI;
import api.UserAPI;
import e2e.TestBase;
import e2e.enums.UserCredentials;
import e2e.pages.BookPage;
import e2e.pages.BookStorePage;
import e2e.pages.LoginPage;
import e2e.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import schemas.Book;
import schemas.GetUserResultDTO;
import schemas.UserDTO;

public class AddBookViaUICheckAddedBookViaAPITest extends TestBase {

    LoginPage loginPage;

    ProfilePage profilePage;

    BookStorePage bookStorePage;

    BookPage bookPage;

    AuthorizationAPI authorizationAPI = new AuthorizationAPI();

    UserAPI userAPI;

    @Test
    public void addBookViaUICheckAddedBookViaAPITest() throws InterruptedException {
        String expectedBookTitle = "Git Pocket Guide";

        loginPage = new LoginPage(app.driver);
        loginPage.login(UserCredentials.VALID_USERNAME, UserCredentials.VALID_PASSWORD);
        loginPage.confirmSuccessfulLogin();

        profilePage = new ProfilePage(app.driver);
        profilePage.waitForLoadingBookStoreButton();
        profilePage.scrollToBookStoreButton();
        profilePage.clickGoToBookStoreButton();

        bookStorePage = new BookStorePage(app.driver);
        bookStorePage.waitForLoading();
        bookStorePage.waitForBookInTable();
        bookStorePage.clickFirstBookLink();

        bookPage = new BookPage(app.driver);
        Assert.assertEquals(bookPage.getTitleBook(), expectedBookTitle, "Expected and Actual are not same");
        bookPage.waitForLoading();
        bookPage.waitProfileButtonAfterScroll();
        bookPage.clickAddToYourCollectionButton();
        profilePage.refreshPage();

        // login created user
        UserDTO existedUserCredentials = authorizationAPI.existedUserCredentials();
        String token = authorizationAPI.generateToken(existedUserCredentials);
        Assert.assertTrue(authorizationAPI.isAuthorized(existedUserCredentials));
        userAPI = new UserAPI(token);

        var loginUserResponse = authorizationAPI.loginExistedUser();
        GetUserResultDTO userData = userAPI.getUser(loginUserResponse.getUserId());
        Assert.assertTrue(checkUserHasExpectedBookByTitle(userData, expectedBookTitle));
    }

    private boolean checkUserHasExpectedBookByTitle(GetUserResultDTO userData, String expectedBookTitle) {
        for (Book book : userData.getBooks()) {
            if (expectedBookTitle.equals(book.getTitle())) {
                return true;
            }
        }
        return false;
    }
}
