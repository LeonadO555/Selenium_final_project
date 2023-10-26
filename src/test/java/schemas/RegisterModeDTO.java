package schemas;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegisterModeDTO {
    @JsonProperty("userID")
    private String UserId;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("userName")
    private String userName;

    @JsonProperty("password")
    private String password;

    public String getUserId() {
        return UserId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword(){
        return password;
    }

    public void setUserId(int UserId) {
       this.UserId = String.valueOf(UserId);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
}
