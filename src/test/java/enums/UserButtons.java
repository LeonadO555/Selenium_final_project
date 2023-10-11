package enums;

import lombok.Getter;

@Getter
public enum UserButtons {
    EDIT("//*[@id='btn-edit-contact']"),
    ADD_PHONE_NUMBER("//*[@id='btn-add-phone']"),
    ADD_EMAIL("//*[@id='btn-add-phone']"),
    ADD_ADDRESS("//*[@id='btn-add-phone']");
    public final String value;

    UserButtons(String value) {
        this.value = value;
    }
}