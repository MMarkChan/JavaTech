package naturalid.naturalidapi;

import naturalid.definition.*;
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


public class LoadByNaturalId {
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
    public void useNaturalAPI(){
        Company company = session.byNaturalId( Company.class )
                .using( "taxIdentifier","abc-123-xyz" )
                .load();
        PostalCarrier carrier = session.byNaturalId( PostalCarrier.class )
                .using( "postalCode",new PostalCode("5445454"))
                .load();

        Department department = new Department();
        Course course = session.byNaturalId( Course.class )
                .using( "department",department )
                .using( "code","101" )
                .load();
    }

    @Test
    public void useSimpleNaturalAPI(){
        Company company = session.bySimpleNaturalId( Company.class )
                .load( "abc-123-xyz" );

        PostalCarrier carrier = session.bySimpleNaturalId( PostalCarrier.class )
                .load( new PostalCode("77866544") );
    }

    @Test
    public void mutableNaturalId(){
        Person person = session.bySimpleNaturalId( Person.class ).load( "123-45-6789" );
        //person.setSsn( "987-65-4321" );
        //...
        // returns null!
        person = session.bySimpleNaturalId( Person.class )
                .setSynchronizationEnabled( false )
                .load( "987-65-4321" );
        // returns correctly!
        person = session.bySimpleNaturalId( Person.class )
                .setSynchronizationEnabled( true )
                .load( "987-65-4321" );
    }
}
