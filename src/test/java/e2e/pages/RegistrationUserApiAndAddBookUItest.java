package e2e.pages;

import api.account.Authorization;
import api.account.NewUser;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;
import schemas.RegisterModeDTO;

public class RegistrationUserApiAndAddBookUItest extends TestBase{
    Authorization authorization;
    NewUser newUser;
    LoginPage loginPage;
    BooksPage booksPage;
    BooksCollection booksCollection;
    ProfilePage profilePage;

    @Test
    public void registrationUserApiAndAddBookUITest(){
        newUser = new NewUser();
        RegisterModeDTO newUserData = newUser.generateNewRandomUser();//new user
        JsonPath createdUser = newUser.registerNewUser(newUserData).jsonPath();//registration
        String userId = createdUser.getString("userID");

        String token = newUser.generateToken(newUserData);
        authorization = new Authorization(token);//token
        Assert.assertTrue(newUser.isAuthorized(newUserData));

        String actualCreatedUser = authorization.getUser(userId).jsonPath().getString("username");
        String expectedCreatedUser = newUserData.getUserName();
        Assert.assertEquals(actualCreatedUser, expectedCreatedUser, actualCreatedUser + "is not equal to " + expectedCreatedUser);

        String newAccountUserName = newUserData.getUserName();
        String newAccountPassword = newUserData.getPassword();
        String bookTitle = "Git Pocket Guide";

        loginPage = new LoginPage(app.driver);
        loginPage.login(newAccountUserName, newAccountPassword);
        loginPage.confirmSuccessfulLogin();

        booksPage = new BooksPage(app.driver);
        app.driver.get("https://demoqa.com/books");
        booksPage.waitForLoading();
        booksPage.scrollToSecondBook();
        booksPage.waitForLoading();
        booksPage.waitForClickable();
        booksPage.clickOnSecondBook();

        booksCollection = new BooksCollection(app.driver);
        booksCollection.scrollToAddToCollectionButton();
        booksCollection.waitForLoading();
        booksCollection.waitForClickable();
        booksCollection.clickOnAddToCollectionButton();
        Assert.assertTrue(booksCollection.isBookAdded(bookTitle));


        profilePage = new ProfilePage(app.driver);
        app.driver.get("https://demoqa.com/profile");
        //TODO: here is a bug. Session expired after go to via url
        profilePage.waitForLoading();
        profilePage.clickDeleteButton();
        profilePage.waitForLoadingModalAlert();
        profilePage.clickOkButton();
        Assert.assertTrue(profilePage.isBookDeleted(bookTitle));
    }
}