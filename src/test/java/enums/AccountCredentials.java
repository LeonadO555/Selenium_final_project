package enums;

import lombok.Getter;

@Getter
public enum AccountCredentials {
    VALID_USERNAME("art"),
    VALID_PASSWORD("Abc123$@"),
    INVALID_USERNAME("123456@gmail.com"),
    INVALID_PASSWORD("123456");

    public final String value;

    AccountCredentials(String value) {
        this.value = value;
    }
}
