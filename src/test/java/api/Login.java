package api;

import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Login extends ApiBase {

    public Login(String token) {
        super(token);
    }
    private static final Logger logger = LoggerFactory.getLogger(Login.class);
    public Response getAccount(String userId) {
        String endPoint = "/Account/v1/User/{UserId}";
        Response response = getRequestWithParam(endPoint, 200, "UserId", userId);
        logger.info("Retrieved account for user with ID: {}", userId);
        return response;
    }

    public Response deleteAccount(String userId) {
        String endPoint = "/Account/v1/User/{UserId}";
        Response response = deleteRequest(endPoint, 204, "UserId", userId);
        logger.info("Deleted account for user with ID: {}", userId);
        return response;
    }
}
