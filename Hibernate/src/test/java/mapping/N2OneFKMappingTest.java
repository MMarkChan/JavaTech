package mapping;

import interceptor.LoggingInterceptor;
import mapping.n2onefk.AddressN2OneFK;
import mapping.n2onefk.PersonN2OneFK;
import model.Person;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Restrictions;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Mark on 2016/3/21.
 */
public class N2OneFKMappingTest {
    private static SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;
    @BeforeClass
    public static void beforeClass(){

        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("config/n2onefk/hibernate.cfg.xml") // configures settings from hibernate.cfg.xml
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
    public void test() {

        PersonN2OneFK p1=new PersonN2OneFK();
        PersonN2OneFK p2=new PersonN2OneFK();

        p1.setAge(21);
        p1.setName("p1");

        p2.setAge(23);
        p2.setName("p2");

        AddressN2OneFK add=new AddressN2OneFK();
        add.setAddressdetail("郑州市经三路");

        p1.setAddressN2OneFK(add);
        p2.setAddressN2OneFK(add);

        session.save(add);
        session.save(p1);
        session.save(p2);
    }
}
