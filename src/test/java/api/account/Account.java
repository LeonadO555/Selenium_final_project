package api.account;

import api.ApiBase;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import schemas.RegisterViewModel;

public class Account extends ApiBase {
    Response response;
    RegisterViewModel model;
    Faker faker = new Faker();
    String userName = faker.internet().uuid();

    public RegisterViewModel randomDataForCreateUser() {
        model = new RegisterViewModel();
        model.setUserName(userName);
        model.setPassword("rio7W7iii#");
        return model;
    }

    public Response createUser(RegisterViewModel userBody, Integer code) {
        String endPoint = "/Account/v1/User/";
        response = postRequest(endPoint, code, userBody);
        return response;
    }
}

