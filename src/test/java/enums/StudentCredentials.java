package enums;

import lombok.Getter;

@Getter
public enum StudentCredentials {
    VALID_EMAIL("malik@example.com"),
    VALID_PASSWORD("123456"),
    INVALID_EMAIL("111gmail.com"),
    INVALID_PASSWORD("test111@gmail.com");

    public final String value;

    StudentCredentials(String value) {
        this.value = value;
    }
}

