package e2e.enums;

import lombok.Getter;

@Getter
public enum UserCredentials {
    VALID_USERNAME("hvoronkova"),
    VALID_PASSWORD("Newtest567!"),
    INVALID_USERNAME("tester123"),
    INVALID_PASSWORD("12345678");

    public final String value;

    UserCredentials(String value) {
        this.value = value;
    }
}
