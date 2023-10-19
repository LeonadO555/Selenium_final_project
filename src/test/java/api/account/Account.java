package api.account;

import api.ApiBase;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import schemas.RegisterModelDto;

public class Account extends ApiBase {
    Response response;
    RegisterModelDto dto;

    public RegisterModelDto randomDataForCreateAccount() {
        Faker faker = new Faker();
        dto = new RegisterModelDto();
        String userName = faker.internet().uuid();
        dto.setUserName(userName);
        dto.setPassword("Abc123$@");
        return dto;
    }

    public Response createAccount(Integer code) {
        String endPoint = "/Account/v1/User";
        response = postRequest(endPoint, code, randomDataForCreateAccount());
        response.as(RegisterModelDto.class);
        return response;
    }

    public Response deleteAccount(Integer code, String UserId) {
        String endPoint = "/Account/v1/User/{UUID}";
        response = deleteRequest(endPoint, code, "UUID", "UserId");
        return response;
    }

    public Response getAccount(Integer code, String UserId) {
        String endPoint = "/Account/v1/User/{UUID}";
        response = getRequestWithParam(endPoint, code, "UUID", "UserId");
        return response;
    }

}

