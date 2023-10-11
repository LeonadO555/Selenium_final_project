package e2e;

import com.github.javafaker.Faker;
import e2e.pages.LoginPage;
import e2e.pages.RegistrationPage;
import org.testng.annotations.Test;
import java.io.IOException;


public class NoCreateUserAsStudentViaApiUiTest extends TestBase{

    Faker faker = new Faker();
    RegistrationPage registrationPage;
    LoginPage loginPage;

    @Test
    public void noCreateUserAsStudentViaApiUiTest() throws IOException {
        String createFullName = "*#@&%$";
        String createEmail = "123gmail.com";
        String createPassword = faker.internet().uuid();

        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.clickOnSignupButton();

        registrationPage = new RegistrationPage(app.driver);
        registrationPage.selectRoleToStudentDropDown();
        registrationPage.fillFullNameDialog(createFullName);
        registrationPage.fillEmailDialog(createEmail);
        registrationPage.fillPasswordDialog(createPassword);
        registrationPage.clickOnCheckbox();
        registrationPage.clickOnSubmitSignUpButton();
        registrationPage.waitForLoading();
        registrationPage.checkAlert();

    }
}
