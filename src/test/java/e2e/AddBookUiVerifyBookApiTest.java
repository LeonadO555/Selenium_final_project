package e2e;

import e2e.pages.BookStorePage;
import e2e.setup.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AddBookUiVerifyBookApiTest {
    @Test
    public void addBook() {
        ApplicationManager.getWebDriver().navigate().to("https://demoqa.com/books");
        new BookStorePage()
                .doLogin()
                .selectAndAddBook();

    }

    @Test
    public void getBook() {
        String userId = getLoginValue("userId");
        String token = getLoginValue("token");

        String bookName = given().log().all()
                .contentType("application/json")
                .header("Authorization", "Bearer " + token)
                .when().get("https://demoqa.com/Account/v1/User/" + userId).then().log().all()
                .extract().response().getBody().jsonPath().getString("books[0].title");

        Assert.assertEquals(bookName, "Git Pocket Guide");
    }

    private static String getLoginValue(String value) {
        String login = """
                {
                    "userName": "rio5", "password": "rio55W7iii#"}
                """;
        return given().log().all()
                .body(login)
                .contentType("application/json")
                .when().post("https://demoqa.com/Account/v1/Login").then().log().all()
                .extract().response().getBody().jsonPath().getString(value);
    }
}
