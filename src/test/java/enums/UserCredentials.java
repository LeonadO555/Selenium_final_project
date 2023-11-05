package enums;

import lombok.Getter;

    @Getter
    public enum UserCredentials {
        VALID_USERNAME("irina81"),
        VALID_PASSWORD("I19811202a!"),
        INVALID_USERNAME("11111111"),
        INVALID_PASSWORD("22222222");

        public final String value;

        UserCredentials(String value) {
            this.value = value;
        }
    }

