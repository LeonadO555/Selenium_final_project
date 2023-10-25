package api.account;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiBase {

    public static final String BASE_URI = "https://demoqa.com/";
    private static final String API_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6ImRvbWlrIiwicGFzc3dvcmQiOiI1MDMyOTY3RGdmJCIsImlhdCI6MTY5ODI1MjI0Mn0.khTvKbmb0R-EVxffw7T04_RVyU-A6FG68jr0tqM1uqA";
    //final String Api_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6ImRvbWlrIiwicGFzc3dvcmQiOiI1MDMyOTY3RGdmJCIsImlhdCI6MTY5ODI1MjI0Mn0.khTvKbmb0R-EVxffw7T04_RVyU-A6FG68jr0tqM1uqA"
        ;
    RequestSpecification spec = new RequestSpecBuilder()
            .setBaseUri(BASE_URI)
            .setContentType(ContentType.JSON)
            .addHeader("Access-Token", API_KEY)
            .build();

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

    public Response getRequestWithParam(String endPoint, Integer responseCode, String paramName, String paramValue) {
        Response response = RestAssured.given()
                .spec(spec)
                .when()
                .pathParam(paramName, paramValue)
                .log().all()
                .get(endPoint)
                .then().log().all()
                .extract().response();
        response.then().assertThat().statusCode(responseCode);
        return response;
    }

    public Response postRequest(String endPoint, Integer responseCode, Object body) {
        Response response = RestAssured.given()
                .spec(spec)
                .body(body)
                .when()
                .log().all()
                .post(endPoint)
                .then().log().all()
                .extract().response();
        response.then().assertThat().statusCode(responseCode);
        return response;
    }

    public Response putRequest(String endPoint, Integer responseCode, Object body, String paramName, String paramValue) {
        Response response = RestAssured.given()
                .spec(spec)
                .body(body)
                .when()
                .pathParam(paramName, paramValue)
                .log().all()
                .put(endPoint)
                .then().log().all()
                .extract().response();
        response.then().assertThat().statusCode(responseCode);
        return response;
    }

    public Response deleteRequest(String endPoint, Integer responseCode, String paramName, String paramValue) {
        Response response = RestAssured.given()
                .spec(spec)
                .when()
                .pathParam(paramName, paramValue)
                .log().all()
                .delete(endPoint)
                .then().log().all()
                .extract().response();
        response.then().assertThat().statusCode(responseCode);
        return response;
    }

    public RequestSpecification getSpec() {
        return spec;
    }
}
