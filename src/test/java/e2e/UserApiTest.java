package e2e;

import api.account.Account;
import org.testng.annotations.Test;

public class UserApiTest {
    Account account;
    @Test
    public void userApiTest(){
        account = new Account();
        account.createAccount(201);
    }
}
