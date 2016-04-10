package mapping;

import mapping.n2onefk.AddressN2OneFK;
import mapping.n2onefk.PersonN2OneFK;
import mapping.one2onefk.AddressOne2OneFK;
import mapping.one2onefk.PersonOne2OneFK;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Mark on 2016/3/21.
 */
public class One2OneFKMappingTest {
    private static SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;
    @BeforeClass
    public static void beforeClass(){

        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("config/one2onefk/hibernate.cfg.xml") // configures settings from hibernate.cfg.xml
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
        PersonOne2OneFK p1=new PersonOne2OneFK();

        p1.setAge(21);
        p1.setName("p1");

        AddressOne2OneFK add1=new AddressOne2OneFK();
        add1.setAddressdetail("郑州市经三路");

        p1.setAddressOne2OneFK(add1);

        session.save(add1);
        session.save(p1);
    }
}
