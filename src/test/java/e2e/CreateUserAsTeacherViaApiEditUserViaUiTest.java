package e2e;

import api.teacher.Teacher;
import com.github.javafaker.Faker;
import e2e.pages.LoginPage;
import e2e.pages.RegistrationPage;
import e2e.pages.TeacherPage;
import e2e.pages.TeacherProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class CreateUserAsTeacherViaApiEditUserViaUiTest extends TestBase {
    Teacher teacher;
    RegistrationPage registrationPage;
    LoginPage loginPage;
    TeacherPage teacherPage;
    TeacherProfilePage teacherProfilePage;
    Faker faker = new Faker();

    @Test
    public void createUserAsTeacherViaApiEditUserViaUiTest() throws IOException {
        String createFullName = faker.internet().uuid();
        String createEmail = faker.internet().emailAddress();
        String createPassword = "13579I";

        String editedFullName = faker.internet().uuid();
        String editedEmail = faker.internet().emailAddress();
        String editedPassword = faker.internet().uuid();
        String editedDescription = faker.internet().uuid();

        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.clickOnSignupButton();

        registrationPage = new RegistrationPage(app.driver);
        registrationPage.waitForLoading();
        registrationPage.selectRoleToTeacherDropDown();
        registrationPage.fillFullNameDialog(createFullName);
        registrationPage.fillEmailDialog(createEmail);
        registrationPage.fillPasswordDialog(createPassword);
        registrationPage.clickOnCheckbox();
        registrationPage.scrollToSignupButton();
        registrationPage.clickOnSubmitSignUpButton();

        String enteredFullName = registrationPage.getFullName();
        String enteredEmail = registrationPage.getEmail();
        String enteredPassword = registrationPage.getPassword();
        Assert.assertEquals(enteredFullName, createFullName, "Full Name is incorrect");
        Assert.assertEquals(enteredEmail, createEmail, "Email is incorrect");
        Assert.assertEquals(enteredPassword, createPassword, "Email is incorrect");
        registrationPage.waitForLoading();

        teacherPage = new TeacherPage(app.driver);
        teacherPage.waitForLoading();
        teacherPage.clickOnMyProfileButton();
        teacherPage.clickOnMyProfileDropDown();

        teacherProfilePage = new TeacherProfilePage(app.driver);
        teacherProfilePage.waitForLoading();
        teacherProfilePage.clickSelectMyRoleDropDown();
        teacherProfilePage.selectRoleToStudentDropDown();
        teacherProfilePage.clickOnFullNameDialog(editedFullName);
        teacherProfilePage.clickOnEmailDialog(editedEmail);
        teacherProfilePage.clickOnDescriptionTextArea(editedDescription);
        teacherProfilePage.clickOnUpdateProfileButton();

        teacherProfilePage.scrollToChangePasswordButton();
        teacherProfilePage.clickOnOldPasswordDialog(createPassword);
        teacherProfilePage.clickOnNewPasswordDialog(editedPassword);
        teacherProfilePage.clickOnChangePasswordButton();

        String actualFullName = registrationPage.getFullName();
        String actualEmail = registrationPage.getEmail();
        String actualPassword = registrationPage.getPassword();
        Assert.assertEquals(actualFullName, editedFullName, "Full Name is incorrect");
        Assert.assertEquals(actualEmail, editedEmail, "Email is incorrect");
        Assert.assertEquals(actualPassword, editedPassword, "Email is incorrect");

    }
}
