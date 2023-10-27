package e2e;
//
//import api.account.Account;
//import e2e.pages.BookStorePage;
//import e2e.pages.LoginPage;
//import e2e.pages.ProfilePage;
//import org.testng.Assert;
//import org.testng.annotations.Test;


//public class WorkWithBooksApiViaUiTest extends TestBase {
//    Account account;
//    LoginPage loginPage;
//    ProfilePage profilePage;
//    BookStorePage bookStorePage;
//
//    @Test
//    public void workWithBooksApiViaUiTest() {
//        account = new Account();
//        JsonPath createdAccount = account.createAccount(201).jsonPath();
//        String userId = createdAccount.getString("UserId");
//
////        Assert.assertNotNull(userId, "UserId is null or not present in the response.");
//        JsonPath expectedCreatedContact = account.getAccount(200, userId).jsonPath();
//        List<String> listPaths = new ArrayList<>();
//        listPaths.add("userName");
//        listPaths.add("password");
//
//        for (String path : listPaths) {
//            String actual = createdAccount.getString(path);
//            String expected = expectedCreatedContact.getString(path);
//            Assert.assertEquals(actual, expected, "Actual parameter is not equal expected");
//        }
//        String expectedUserName = account.randomDataForCreateAccount().getUserName();
//        JsonPath actualCreatedAccount = account.getAccount(200, userId).jsonPath();
//        String actualUserName = actualCreatedAccount.getString("userName");
//        Assert.assertEquals(actualUserName, expectedUserName, "Usernames do not match.");


//        loginPage = new LoginPage(app.driver);
//        loginPage.loginWithRegistrationData();
//        loginPage.confirmSuccessfulLogin();
//
//        bookStorePage = new BookStorePage(app.driver);
//        bookStorePage.waitForLoading();
//        bookStorePage.clickOnBooksCard();
//        bookStorePage.waitForLoading();
//        Assert.assertTrue(bookStorePage.isBookAdded("Git Pocket Guide"));
//
//        profilePage = new ProfilePage(app.driver);
//        profilePage.clickGoToBookStoreButton();
//        profilePage.waitForLoading();
//        profilePage.clickDeleteButton();
//        Assert.assertTrue(profilePage.isBookDeleted("Git Pocket Guide"));
//    }
//}

