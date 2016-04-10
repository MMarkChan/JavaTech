package paramtransfer.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect()
public class SecurityAspect {
    @Pointcut(value = "execution(* paramtransfer.service.*.*(String,..)) " +
            "&& args(username))", argNames = "username")
    public void trackLogin(String username){}

    @Before("trackLogin(username)")
    public void checkUsername(JoinPoint joinPoint, String username){
        System.out.println("SecurityAspect.checkUsername()："+username);
        System.out.println(joinPoint.toLongString());
    }
}
