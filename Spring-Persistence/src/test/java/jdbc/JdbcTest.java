package jdbc;

import jdbc.config.BeanConfiguration;
import jdbc.repository.JdbcRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;


public class JdbcTest {
    @Test
    public void jdbc(){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(BeanConfiguration.class);
        JdbcRepository obj = (JdbcRepository)context.getBean("jdbcRepository");
        List<Map<String,Object>> list = obj.select();
        System.out.print(obj);
    }
}
