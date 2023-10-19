package schemas;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)

public class LoginModel {

    @JsonProperty("UserId")
    private String UserId;
    @JsonProperty("userName")
    private String userName;

    @JsonProperty("password")
    private String password;

    public String getUserId() {
        return UserId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {

        this.userName = password;
    }
}
