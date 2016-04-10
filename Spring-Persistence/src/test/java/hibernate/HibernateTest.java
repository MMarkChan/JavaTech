package hibernate;

import hibernate.config.HibernateContextConfig;
import hibernate.model.User;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import hibernate.repository.hibernate.HibernateRepository;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Mark on 2016/3/5.
 */

public class HibernateTest {
    @Test
    public void hibernate(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateContextConfig.class);
        HibernateRepository repository = (HibernateRepository)context.getBean("hibernateRepository");
        User user = new User();
        user.setAge(33);
        user.setFirstname("Tom");
        repository.save(user);

        user = repository.get(1);
        System.out.println(user.getFirstname());

        repository.query();

        List<User> users = repository.queryByCriteria();
        Iterator<User> it = users.iterator();
        while (it.hasNext()){
            User u = it.next();
            System.out.println("aaaa "+u.getFirstname());
        }
    }
}
