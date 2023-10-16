package api.account;

import api.ApiBase;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import schemas.RegisterModelDto;

public class Account extends ApiBase {
    Response response;
    RegisterModelDto dto;

    public Account(String token) {
        super(token);
    }

    public RegisterModelDto randomDataForCreateAccount() {
        Faker faker = new Faker();
        dto = new RegisterModelDto();
        dto.setFirstName(faker.internet().uuid());
        dto.setLastName(faker.internet().uuid());
        dto.setUserName(faker.internet().uuid());
        dto.setPassword(faker.internet().uuid());
        return dto;
    }

    public Response createAccount(Integer code) {
        String endPoint = "/api/contact";
        response = postRequest(endPoint, code, randomDataForCreateAccount());
        response.as(RegisterModelDto.class);
        return response;
    }

    public Response deleteAccount(Integer code, int id) {
        String endPoint = "/api/contact/{id}";
        response = deleteRequest(endPoint, code, id);
        return response;
    }

    public Response getAccount(Integer code, Integer id) {
        String endPoint = "/api/contact/{id}";
        response = getRequestWithParam(endPoint, code, "id", id);
        return response;
    }

}

