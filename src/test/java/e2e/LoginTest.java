package e2e;

import e2e.pages.LoginPage;
import enums.StudentCredentials;
import enums.TeacherCredentials;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    LoginPage loginPage;

    @Test
    public void userAsTeacherCanLoginWithValidData() {
        loginPage = new LoginPage(app.driver);
        loginPage.loginAsTeacher(TeacherCredentials.VALID_EMAIL, TeacherCredentials.VALID_PASSWORD);
        loginPage.confirmSuccessfulLogin();
    }

    @Test
    public void userAsStudentCanLoginWithValidData() {
        loginPage = new LoginPage(app.driver);
        loginPage.loginAsStudent(StudentCredentials.VALID_EMAIL, StudentCredentials.VALID_PASSWORD);
        loginPage.confirmSuccessfulLogin();
    }

    @Test
    public void userAsTeacherCanNotLoginWithInvalidEmail() {
        loginPage = new LoginPage(app.driver);
        loginPage.loginAsTeacher(TeacherCredentials.INVALID_EMAIL, TeacherCredentials.VALID_PASSWORD);
        loginPage.confirmUnsuccessfulLogin();
    }

    @Test
    public void userAsStudentCanNotLoginWithInvalidEmail() {
        loginPage = new LoginPage(app.driver);
        loginPage.loginAsStudent(StudentCredentials.INVALID_EMAIL, StudentCredentials.VALID_PASSWORD);
        loginPage.confirmUnsuccessfulLogin();
    }
    @Test
    public void userAsTeacherCanNotLoginWithInvalidPassword() {
        loginPage = new LoginPage(app.driver);
        loginPage.loginAsTeacher(TeacherCredentials.VALID_EMAIL, TeacherCredentials.INVALID_PASSWORD);
        loginPage.confirmUnsuccessfulLogin();
    }

    @Test
    public void userAsStudentCanNotLoginWithInvalidPassword() {
        loginPage = new LoginPage(app.driver);
        loginPage.loginAsStudent(StudentCredentials.VALID_EMAIL, StudentCredentials.INVALID_PASSWORD);
        loginPage.confirmUnsuccessfulLogin();
    }

    @Test
    public void userAsTeacherCanNotLoginWithInvalidData() {
        loginPage = new LoginPage(app.driver);
        loginPage.loginAsTeacher(TeacherCredentials.INVALID_EMAIL, TeacherCredentials.INVALID_PASSWORD);
        loginPage.confirmUnsuccessfulLogin();
    }

    @Test
    public void userAsStudentCanNotLoginWithInvalidData() {
        loginPage = new LoginPage(app.driver);
        loginPage.loginAsStudent(StudentCredentials.INVALID_EMAIL, StudentCredentials.INVALID_PASSWORD);
        loginPage.confirmUnsuccessfulLogin();
    }
}
