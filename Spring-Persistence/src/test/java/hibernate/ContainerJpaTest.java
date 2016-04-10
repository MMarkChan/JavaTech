package hibernate;

import hibernate.config.ContainerJpaContextConfig;
import hibernate.model.User;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import hibernate.repository.containerjpa.ContainerJpaRepository;

public class ContainerJpaTest {
    @Test
    public void containerJpa(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ContainerJpaContextConfig.class);
        ContainerJpaRepository repository = (ContainerJpaRepository)context.getBean("containerJpaRepository");
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
