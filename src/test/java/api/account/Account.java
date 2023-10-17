package api.account;

import api.ApiBase;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import schemas.RegisterViewModelDto;

public class Account extends ApiBase {
    Response response;
RegisterViewModelDto dto;
Faker faker = new Faker();
public RegisterViewModelDto generateRandomDataForCreateAccount(){
    dto = new RegisterViewModelDto();
    dto.setUserName(faker.internet().uuid());
    dto.setPassword("5032867Dgf$");
    return dto;
}
public Response createAccount (Integer code){
    String endPoint = "/Account/v1/User";
    response = postRequest(endPoint, code,generateRandomDataForCreateAccount());
    response.as(RegisterViewModelDto.class);
    return response;
}

}
