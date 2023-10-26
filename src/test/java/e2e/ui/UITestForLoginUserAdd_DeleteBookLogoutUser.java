package e2e.ui;

import e2e.TestBase;
import e2e.enums.UserCredentials;
import e2e.pages.BookPage;
import e2e.pages.BookStorePage;
import e2e.pages.LoginPage;
import e2e.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UITestForLoginUserAdd_DeleteBookLogoutUser extends TestBase {

    LoginPage loginPage;

    ProfilePage profilePage;

    BookStorePage bookStorePage;

    BookPage bookPage;

    @Test
    public void uITestForLoginUserAdd_DeleteBookLogoutUser() {
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

//        bookPage.checkThatSelectedBookOpened();
        bookPage.waitForLoading();
//        bookPage.waitForLoadingBookInfoForm();
        bookPage.waitProfileButtonAfterScroll();
//        bookPage.scrollToProfileButton();
//        bookPage.waitForLoadingProfileButton();
        bookPage.clickAddToYourCollectionButton();

//        alertHandling = new AlertHandling(app.driver);
        bookPage.simpleAlertHandling();

        bookPage.waitForLoading();
        bookPage.waitProfileButtonAfterScroll();
//        bookPage.scrollToProfileButton();
//        bookPage.waitForLoadingProfileButton();
        bookPage.clickProfileButton();

        profilePage.waitForLoadingProfileForm();
//        profilePage.checkThatBookAdded();
        Assert.assertEquals(profilePage.getAddedBookTitle(), expectedBookTitle, "Expected and Actual are not same");

        profilePage.clickDeleteButtonRow();
        profilePage.waitForLoadingModalAlert();
        profilePage.modalAlertHandling();
        profilePage.simpleAlertHandling();
        profilePage.checkThatBookDeleted();
        profilePage.clickLogOutButton();
        loginPage.confirmLoginFormOpened();
    }
}
