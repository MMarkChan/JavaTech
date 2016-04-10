import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.Test;
import paramtransfer.config.AspectContextConfig;
import paramtransfer.service.LoginService;

public class AspectTest {
    @Test
    public void test(){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AspectContextConfig.class);
        LoginService service = context.getBean("loginService",LoginService.class);
//        SecurityAspect aspect = context.getBean("securityAspect",SecurityAspect.class);
//        aspect.checkUsername();
        service.login("ChenDongming");
    }
}
