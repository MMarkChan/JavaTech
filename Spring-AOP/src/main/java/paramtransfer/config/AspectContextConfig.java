package paramtransfer.config;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import paramtransfer.aspect.SecurityAspect;
import paramtransfer.service.LoginService;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackageClasses = {SecurityAspect.class, LoginService.class})
public class AspectContextConfig {

}
