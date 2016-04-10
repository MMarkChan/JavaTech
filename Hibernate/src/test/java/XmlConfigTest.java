import interceptor.LoggingInterceptor;
import listener.SecuredLoadEntityListener;
import model.Person;
import org.hibernate.*;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManagerFactory;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Mark on 2016/3/21.
 */
public class XmlConfigTest {
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
    public void xmlconfig() {
        //Session session = sessionFactory.openSession();
        //session.beginTransaction();
//        Person u1 = session.load(Person.class, 1);
//        System.out.println(u1.getName());
//        session.getTransaction().commit();
//        Person person = new Person();
//        person.setName("Mark");
//        person.setAge(30);
//        Serializable id = session.save(person);
        //session.close();

        // get()与load()的区别：get()获取的是真实的实例，而load()获取的是一个代理引用
        Person person1 = session.get(Person.class,1); // 会马上发送SQL语句
        Person person2 = session.load(Person.class,1); // 只会获取一个Person的代理引用，只有这个引用在后面真的调用方法时才会发送SQL
        System.out.println(person1.getName()+" " +person1.getAge());
//
//        session2.beginTransaction();
//        Person u2 = session2.load(Person.class, 1);
//        System.out.println(u2.getName());
    }

    /**
     * get()和load()都会先查session缓存再查二级缓存，如果都找不到才查数据库
     * 在实体被第一次加载时，get()返回的是已经初始化数据的实体实例；load()返回的是未初始化的代理实体实例
     * 在往后的调用中get()可能返回的是通过load()缓存的代理实体实例，也可能是真实的实体实例
     */
    @Test
    public void getAndLoad(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Person person = session.get(Person.class,1);
        System.out.println(person.getName());
        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();
        session.beginTransaction();
        person = session.get(Person.class,1);
        System.out.println(person.getName());
        session.getTransaction().commit();
        session.close();

    }


    @Test
    public void listAndIterate(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        /**
         * 实际执行的是如下SQL语句：
         *  select
                 person0_.id as id1_1_,
                 person0_.age as age2_1_,
                 person0_.name as name3_1_
             from
                 Person person0_
         */
        //List<Person> list = session.createQuery("from Person ").list();
        //System.out.println(person.getName());
        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();
        session.beginTransaction();
        /**
         * 实际执行的是如下SQL语句：
         * select
                person0_.id as col_0_0_
            from
                Person person0_
         */
        Iterator<Person> iterator = session.createQuery("from Person ").iterate();
        while (iterator.hasNext()){
            /**
             * 如果一级缓存和二级缓存都没有此persion的缓存实例，则每次调用都会执行如下SQL：
             *   select
                     person0_.id as id1_1_0_,
                     person0_.age as age2_1_0_,
                     person0_.name as name3_1_0_
                 from
                    Person person0_
                 where
                    person0_.id=?
             */
            Person person = iterator.next();
            System.out.println(person.getName());
        }
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void query(){
        Session session = sessionFactory.openSession();
        List<Person> list = session.createQuery("from Person p where id like '%1%'").list();
        for (Person p:list){
            System.out.println(p.getName());
        }

        List<Person> list2 = session.createQuery("from Person p where name like ?")
                .setParameter(0,"%a%").list();
        for (Person p:list2){
            System.out.println(p.getName());
        }

        List<Person> list3 = session.createQuery("from Person p where name like :name")
                .setParameter("name","%a%").list();
        for (Person p:list3){
            System.out.println(p.getName());
        }

        List<Person> list4 = session.createQuery("from Person p where p.id in (:ids)")
                .setParameterList("ids",new Object[]{1,2,3,4,5}).list();
        for (Person p:list4){
            System.out.println(p.getName());
        }


        List<Person> list5 = session.createQuery("from Person p")
                .setFirstResult(2).setMaxResults(4).list();
        for (Person p:list5){
            System.out.println(p.getName());
        }


        List students =session.createQuery("select c.name, count(s) from Student s join s.classes c group by c.name order by c.name").list();

//        List students = session.createQuery("select s.id, s.name from Student s where date_format(s.createTime, '%Y-%m')=?").setParameter(0, "2008-02").list();
//                session.close();

        session.createQuery("update Student s set s.name=? where s.id < ?")
                .setParameter(0, "李四")
                .setParameter(1, 5)
                .executeUpdate();
    }

    @Test
    public void sqlQuery(){
        Session session = sessionFactory.openSession();
        List<Person> list = session.createSQLQuery("select * from person").addEntity(Person.class).list();
        for (Person p:list){
            System.out.println(p.getName());
        }

        List<Person> list2 = session
                .createSQLQuery("select {per.*} from person per")
                .addEntity("per",Person.class)
                .list();
        for (Person p:list2){
            System.out.println(p.getName());
        }
        session.close();
    }

    @Test
    public void criteriaTry(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Person> list = session.createCriteria(Person.class)
                .add(Restrictions.eq("name","Mark8")).list();
        for(Person p : list){
            System.out.println(p.getName());
        }
        session.getTransaction().commit();


    }

    /**
     * Hibernate的拦截器
     */
    @Test
    public void interceptor(){


        Session session = sessionFactory
                .withOptions()
                .interceptor(new LoggingInterceptor())
                .openSession();
        Person person = session.get(Person.class,1);
        person.setName("Mark.Chan");
        session.update(person);

        person = new Person();
        person.setName("Chendm");
        person.setAge(69);
        session.save(person);
        session.close();
    }


    @Test
    public void flushSetup(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        //在session.beginTransaction 前设置 FlushMode
        //session.setFlushMode(FlushMode.Always|AUTO|COMMIT|NEVER|MANUAL)
        session.setFlushMode(FlushMode.ALWAYS);
    }

    @Test
    public void  merge(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Person person = new Person();
        person.setAge(60);
        person.setName("小强");
        person.setId(1);

        Person person2 = (Person) session.merge(person);

        System.out.println("person==person2: "+(person==person2));

        Person person3 = session.get(Person.class,1);
        System.out.println(person3.getName()+"="+person3.getAge());

        session.getTransaction().commit();
        //session.close();
    }


    /**
     * 乐观所假定当前事务操纵数据资源时，
     * 不会有其他事务同时访问该数据资源，
     * 因此不作数据库层次上的锁定
     * 为了维护正确的数据，乐观锁使用应用程序上的版本控制
     * （由程序逻辑来实现的）来避免可能出现的并发问题
     *
     * 当Hibernate更新一个Product对象，会根据它的id和version属性到相应的数据库表中定位匹配的记录，
     * 如果存在这条匹配的记录，就更新记录，并且把version字段的值加1。若找不到匹配的记录，
     * 此时Hibernate会抛出StaleObjectStateException。
     */
    @Test
    public void versionControl(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Person person = new Person();
        person.setAge(60);
        person.setName("小强");
        person.setId(1);
        person.setVersion(10);

        /**
         * 当Hibernate更新一个Product对象，会根据它的id和version属性到相应的数据库表中定位匹配的记录，
         * 如果存在这条匹配的记录，就更新记录，并且把version字段的值加1。若找不到匹配的记录，
         * 此时Hibernate会抛出StaleObjectStateException。
         */
        session.update(person);
        //Person person2 = (Person) session.merge(person);

//        System.out.println("person==person2: "+(person==person2));
//
//        Person person3 = session.get(Person.class,1);
//        System.out.println(person3.getName()+"="+person3.getAge());

        session.getTransaction().commit();
        //session.close();
    }
}
