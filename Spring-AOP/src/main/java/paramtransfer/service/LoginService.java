package paramtransfer.service;

import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginService {
    public void login(String username){
        System.out.println("LoginService.login()");
    }
}
