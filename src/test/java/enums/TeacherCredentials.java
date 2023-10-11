package enums;

import lombok.Getter;

@Getter
public enum TeacherCredentials {
    VALID_EMAIL("roxanne@example.com"),
    VALID_PASSWORD("123456"),
    INVALID_EMAIL("222gmail.com"),
    INVALID_PASSWORD("test222@gmail.com");

    public final String value;

    TeacherCredentials(String value) {
        this.value = value;
    }
}

