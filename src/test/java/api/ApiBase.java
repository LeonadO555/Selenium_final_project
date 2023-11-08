package api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiBase {

    public static final String BASE_URI = "https://demoqa.com/";
    private final RequestSpecification spec;

    public ApiBase() {
        this.spec = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setContentType(ContentType.JSON)
                .build();
    }

    public ApiBase(String token) {
        this.spec = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", token)
                .build();
    }

    public Response getRequestWithParam(String endPoint, int responseCode, String paramName, String paramValue) {
        Response response = RestAssured.given()
                .spec(spec)
                .pathParam(paramName, paramValue)
                .log().all()
                .get(endPoint)
                .then().log().all()
                .statusCode(responseCode)
                .extract().response();
        return response;
    }

    public Response postRequest(String endPoint, int responseCode, Object body) {
        Response response = RestAssured.given()
                .spec(spec)
                .body(body)
                .log().all()
                .post(endPoint)
                .then().log().all()
                .statusCode(responseCode)
                .extract().response();
        return response;
    }

    public Response deleteRequest(String endPoint, int responseCode, String paramName, String paramValue) {
        Response response = RestAssured.given()
                .spec(spec)
                .pathParam(paramName, paramValue)
                .log().all()
                .delete(endPoint)
                .then().log().all()
                .statusCode(responseCode)
                .extract().response();
        return response;
    }
}
