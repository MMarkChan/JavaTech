package hibernate;

import hibernate.config.JpaContextConfig;
import hibernate.model.User;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import hibernate.repository.jpa.JpaRepository;

/**
 * Created by Mark on 2016/3/5.
 */

public class JpaTest {
    @Test
    public void jpa(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JpaContextConfig.class);
        JpaRepository repository = (JpaRepository)context.getBean("jpaRepository");
        User user = new User();
        user.setAge(33);
        user.setFirstname("Tom");
        repository.save(user);

        user = repository.get(1);
        System.out.print(user.getFirstname());

        repository.query();

//        List<User> users = hibernate.repository.queryByCriteria();
//        Iterator<User> it = users.iterator();
//        while (it.hasNext()){
//            User u = it.next();
//            System.out.println("aaaa "+u.getName());
//        }
    }
}
