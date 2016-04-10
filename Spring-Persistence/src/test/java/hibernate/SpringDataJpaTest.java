package hibernate;

import hibernate.config.SpringDataJpaContextConfig;
import hibernate.model.User;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import hibernate.repository.springdata.SpringDataJpaRepository;

import java.util.Iterator;
import java.util.List;


public class SpringDataJpaTest {
    @Test
    public void containerJpa(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringDataJpaContextConfig.class);
        SpringDataJpaRepository repository = (SpringDataJpaRepository)context.getBean("springDataJpaRepository");
        User user = new User();
        user.setAge(33);
        user.setFirstname("Tom");
        repository.save(user);

        user = repository.findOne(1);
        System.out.print(user.getFirstname());

        List<User> users = repository.findAll();

//        List<User> users = hibernate.repository.queryByCriteria();
        Iterator<User> it = users.iterator();
        while (it.hasNext()){
            User u = it.next();
            System.out.println("aaaa "+u.getFirstname());
        }

        users = repository.findByFirstname("cdm");

        users = repository.findByFirstnameOrLastname("fan","dongming");

        users = repository.findByIdGreaterThan(10);

        users = repository.findByFirstnameIgnoringCaseOrLastnameIgnoringCase("fAn","dongminG");

        users = repository.findAllGmailUsers();

        int count = repository.eliteSweep();

        System.out.print("dddddd");
    }
}
