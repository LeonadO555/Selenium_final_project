package api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiBase {

    String token;
//    final String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6IlBldHIiLCJwYXNzd29yZCI6IlBldHIxMjNAIiwiaWF0IjoxNjk3MTM4MTM1fQ.S9rM8xusaZboulHyUqKX0kfoqbXiXqYeehJk8TuRwVo";
    public ApiBase(String token) {
        this.token = token;
    }
    final String BASE_URI = "https://demoqa.com/";

    RequestSpecification spec = new RequestSpecBuilder()
            .setBaseUri(BASE_URI)
            .setContentType(ContentType.JSON)
            .addHeader("Authorization", token)
            .build();

    public Response getRequest(String endPoint, Integer responseCode){
        Response response = RestAssured.given()
                .spec(spec)
                .when()
                .log().all()
                .get(endPoint)
                .then().log().all()
                .extract().response();
        response.then().assertThat().statusCode(responseCode);
        return response;
    }

    public Response getRequestWithParam(String endPoint, Integer responseCode,String paramName, int id){
        Response response = RestAssured.given()
                .spec(spec)
                .when()
                .pathParam(paramName, id)
                .log().all()
                .get(endPoint)
                .then().log().all()
                .extract().response();
        response.then().assertThat().statusCode(responseCode);
        return response;
    }

    public Response postRequest(String endPoint, Integer responseCode, Object body){
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

    public Response deleteRequest(String endPoint, Integer responseCode, int id){
        Response response = RestAssured.given()
                .spec(spec)
                .when()
                .pathParam("id", id)
                .log().all()
                .delete(endPoint)
                .then().log().all()
                .extract().response();
        response.then().assertThat().statusCode(responseCode);
        return response;
    }
}
