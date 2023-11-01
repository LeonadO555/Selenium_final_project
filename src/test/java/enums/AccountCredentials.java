package enums;

import lombok.Getter;

@Getter
public enum AccountCredentials {
    VALID_USERNAME("inna"),
    VALID_PASSWORD("Pass567$"),
    INVALID_USERNAME("inna@gmail.com"),
    INVALID_PASSWORD("ghhgh");

    public final String value;

    AccountCredentials(String value) {
        this.value = value;
    }
}