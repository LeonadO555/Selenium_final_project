package e2e.ui;

import e2e.TestBase;
import e2e.enums.UserCredentials;
import e2e.pages.*;
import org.testng.annotations.Test;

public class UITestForLoginUserAdd_DeleteBookLogoutUser extends TestBase {

    LoginPage loginPage;

    ProfilePage profilePage;

    BookStorePage bookStorePage;

    BookPage bookPage;

    AlertHandling alertHandling;

    @Test
    public void uITestForLoginUserAdd_DeleteBookLogoutUser() {
        loginPage = new LoginPage(app.driver);
        loginPage.login(UserCredentials.VALID_USERNAME, UserCredentials.VALID_PASSWORD);
        loginPage.confirmSuccessfulLogin();

        profilePage = new ProfilePage(app.driver);
        profilePage.waitForLoadingBookStoreButton();
        profilePage.scrollToBookStoreButton();
        profilePage.clickGoToBookStoreButton();

        bookStorePage = new BookStorePage(app.driver);
        bookStorePage.waitForLoadingBookStoreForm();
        bookStorePage.waitForBookLink();
        bookStorePage.clickFirstBookLink();

        bookPage = new BookPage(app.driver);
        bookPage.checkThatSelectedBookOpened();
        bookPage.waitForLoadingBookInfoForm();
        bookPage.scrollToProfileButton();
        bookPage.waitForLoadingProfileButton();
        bookPage.clickAddToYourCollectionButton();

        alertHandling = new AlertHandling(app.driver);
        alertHandling.waitForAlertPresence();
        alertHandling.simpleAlertHandling();

        bookPage.scrollToProfileButton();
        bookPage.waitForLoadingProfileButton();
        bookPage.clickProfileButton();

        profilePage.waitForLoadingProfileForm();
        profilePage.checkThatBookAdded();
        profilePage.clickTrashButton();
//        alertHandling.confirmationAlertHandling();
//        alertHandling.simpleAlertHandling();
//        profilePage.checkThatBookDeleted();
//        profilePage.clickLogOutButton();
//        loginPage.confirmLoginFormOpened();
    }
}
