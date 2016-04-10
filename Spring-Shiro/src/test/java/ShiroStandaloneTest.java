import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.Test;
import spring.shiro.standalone.ShiroContextConfig;
import static org.testng.Assert.*;
import java.util.HashSet;
import java.util.Set;

public class ShiroStandaloneTest {
    @Test
    public void test(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ShiroContextConfig.class);
        SecurityManager sm = (SecurityManager)context.getBean("securityManager");
        SecurityUtils.setSecurityManager(sm);
        UsernamePasswordToken token = new UsernamePasswordToken("cdm","123");
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        assertTrue(subject.isAuthenticated());
    }
    @Test
    public void test2(){
        System.out.print(rotateString("PQWIVLQQ",8,5));
    }

    public static String rotateString(String A, int n, int p) {
        Set set = new HashSet();
        return A.substring(p+1)+A.substring(0,p+1);

    }
}
