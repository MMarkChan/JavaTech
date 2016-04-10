import listener.CustomSessionFactoryInterceptor;
import listener.SecuredLoadEntityListener;
import model.Person;
import naturalid.definition.PersonAddress;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl;
import org.hibernate.jpa.boot.internal.PersistenceUnitInfoDescriptor;
import org.junit.BeforeClass;
import org.junit.Test;
import propretaryjpabootstrap.PersistenceUnitInfoImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.*;

/**
 * Created by Mark on 2016/3/22.
 */
public class JpaBoostrapTest {
    private static EntityManagerFactory entityManagerFactory;
    @BeforeClass
    public static void proprietoryBoostrap(){
        // 持久单元名称
        String persistenceUnitName = "CRM";
        // 实体类
        List<String> entityClassNames = new ArrayList<>();
        entityClassNames.add("Person");
        entityClassNames.add("Address");
        Properties properties = new Properties(  );

        PersistenceUnitInfoImpl persistenceUnitInfo = new PersistenceUnitInfoImpl(
                persistenceUnitName,
                entityClassNames,
                properties
        );

        Map<String, Object> integrationSettings = new HashMap<>();
        integrationSettings.put(
                AvailableSettings.INTERCEPTOR,
                new CustomSessionFactoryInterceptor()
        );

        EntityManagerFactoryBuilderImpl entityManagerFactoryBuilder =
                new EntityManagerFactoryBuilderImpl(
                        new PersistenceUnitInfoDescriptor( persistenceUnitInfo ),
                        integrationSettings
                );

        entityManagerFactory = entityManagerFactoryBuilder.build();
    }

    @Test
    public void listener(){
//        SessionFactoryImplementor sessionFactory = entityManagerFactory.unwrap( SessionFactoryImplementor.class );
//        sessionFactory
//                .getServiceRegistry()
//                .getService( EventListenerRegistry.class )
//                .prependListeners( EventType.LOAD, new SecuredLoadEntityListener() );
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        Person customer = entityManager.find( Person.class, 1 );
    }

    @Test
    public void test(){
//        PersonAddress personAddress = entityManagerFactory.createEntityManager().find(
//                PersonAddress.class,
//                new PersonAddress( person, address )
//        );


    }

}
