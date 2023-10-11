package api.teacher;

import api.ApiBase;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import schemas.TeacherDto;

public class Teacher extends ApiBase {
    Response response;
    TeacherDto dto;

    public TeacherDto randomDataForCreateUser() {
        Faker faker = new Faker();
        dto = new TeacherDto();
        dto.setFullName(faker.internet().uuid());
        dto.setEmail(faker.internet().emailAddress());
        dto.setPassword(faker.internet().uuid());
        return dto;
    }

    public TeacherDto dataForEditUser(int id) {
        dto = new TeacherDto();
        dto.setId(id);
        dto.setFullName("Irasp");
        dto.setEmail("123@gmail.com");
        dto.setPassword("123456");
        return dto;
    }

    public Response createUser(Integer code) {
        String endPoint = "/api/";
        response = postRequest(endPoint, code, randomDataForCreateUser());
        response.as(TeacherDto.class);
        return response;
    }

    public void editUser(Integer code, int id) {
        String endPoint = "/api/contact";
        putRequest(endPoint, code, dataForEditUser(id));
    }

    public Response deleteUser(Integer code, int id) {
        String endPoint = "/api/contact/{id}";
        response = deleteRequest(endPoint, code, id);
        return response;
    }

    public Response getUser(Integer code, Integer id) {
        String endPoint = "/api/contact/{id}";
        response = getRequestWithParam(endPoint, code, "id", id);
        return response;
    }

}
