package api;

import io.restassured.response.Response;
import schemas.LoginModel;

public class Login extends ApiBase{
    Response response;
    LoginModel model;

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
