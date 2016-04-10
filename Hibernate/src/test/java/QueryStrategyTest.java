import model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Mark on 2016/3/22.
 */
public class QueryStrategyTest {
    private static SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;
    @BeforeClass
    public static void beforeClass(){
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources( registry )
                .buildMetadata()
                .buildSessionFactory();
        } catch (Exception e) {
            // The registry would be destroyed by the SessionFactory,
            // but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy( registry );
        }
    }

    @Before
    public void init(){
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
    }
    @After
    public void destroy(){
        transaction.commit();
        session.close();
    }

    @Test
    public void testClassLevelStrategy() {
        Person person = session.load(Person.class, 1); // load()方法得到的是一个代理引用
        System.out.println(person.getClass());
        session.close(); // 关闭会话，后面继续调用代理引用时，就会抛出懒加载异常
        System.out.println(person.getId());
        System.out.println(person.getName());
        System.out.println(person.getAge());

    }



}
