package api.account;


import com.github.javafaker.Faker;
import io.restassured.response.Response;
import schemas.RegisterViewModelDto;

import java.util.UUID;

public class Account extends ApiBase {
    Response response;
    RegisterViewModelDto dto;
    Faker faker = new Faker();

    public RegisterViewModelDto generateRandomDataForCreateAccount() {
        dto = new RegisterViewModelDto();
        dto.setUserName(faker.internet().uuid());
        dto.setPassword("5032867Dgf$");
        return dto;
    }

    public Response createAccount(Integer code) {
        String endPoint = "/Account/v1/User";
        response = postRequest(endPoint, code, generateRandomDataForCreateAccount());
        //response.as(RegisterViewModelDto.class);
        return response;
    }
    public Response createAccount(Integer code) {
        String endPoint = "Account/v1/Authorized";
        response = postRequest(endPoint,code, generateRandomDataForCreateAccount(());
        response.as(RegisterViewModelDto.class);
        return response;

    }

    public Response deleteAccount(Integer code,  String UUID) {
        String endPoint = "/Account/v1/User/{UserId}";
        response = deleteRequest(endPoint, code, "UserId", UUID);
        return response;
    }

    public Response getAccount(Integer code, String UUID) {
        String endPoint = "/Account/v1/User/{UserID}";
        response = getRequestWithParam(endPoint, code, "UserID", UUID);
        return response;
    }

}
