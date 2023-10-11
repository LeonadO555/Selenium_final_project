package enums;

import lombok.Getter;

@Getter
public enum UserTabs {
    INFO("//*[@ng-reflect-_id='1']"),
    EMAILS("//*[@ng-reflect-_id='3']");

    public final String value;

    UserTabs(String value) {
        this.value = value;
    }
}