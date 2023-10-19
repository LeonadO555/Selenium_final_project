package api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import schemas.LoginModel;

public class Login extends ApiBase{
    Response response;
    LoginModel model;
    RequestSpecification specWithoutToken = new RequestSpecBuilder()
            .setBaseUri(BASE_URI)
            .setContentType(ContentType.JSON)
            .build();

    public Login(String token) {
        super(token);
    }

    public Response getRequest(String endPoint, Integer responseCode){
        Response response = RestAssured.given()
                .spec(specWithoutToken)
                .when()
                .log().all()
                .get(endPoint)
                .then().log().all()
                .extract().response();
        response.then().assertThat().statusCode(responseCode);
        return response;
    }

    public LoginModel loginData(String username, String password){
        model = new LoginModel();
        model.setUserName(username);
        model.setPassword(password);
        return model;
    }

    public String login(String username, String password) {
        response = postRequest("Account/v1/User", 200, loginData(username, password));
        return response.jsonPath().getString("token");
    }
}
