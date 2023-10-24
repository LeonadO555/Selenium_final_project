package schemas;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class RegisterViewModelDto {
     @JsonProperty("userName")
     private String userName;
     @JsonProperty("password")
     private String password;

     public void setUserName(String userName) {this.userName = userName; }
     public void setPassword(String password) {this.password = password; }
    
}
