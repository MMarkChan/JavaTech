package hibernate.repository.hibernate;

import hibernate.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Iterator;
import java.util.List;

@Repository
@Transactional
public class HibernateRepository {
    /**
     * 当在Java配置中做了如下配置时
     * @Bean
    public LocalSessionFactoryBean sessionFactoryBean(DriverManagerDataSource dataSource){
        LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();
        sfb.setDataSource(dataSource);
        sfb.setPackagesToScan("hibernate.model");
        Properties properties = new Properties();
        properties.put("dialect","org.hibernate.dialect.MySQLDialect");
        sfb.setHibernateProperties(properties);
        return sfb;
    }

     Spring遇到需要注入Hibernate的SessionFactory类型的依赖时，会使用自已的LocalSessionFactoryBean生成一个
     Hibernate的SessionFactoryBean类型的实例并注入
     */
    @Inject
    private SessionFactory sessionFactory;
    private Session currentSession(){
        return sessionFactory.getCurrentSession();
    }

    public void save(User user){
        currentSession().save(user);
    }

    public User get(int id){
        return currentSession().get(User.class,id);
    }

    public void query(){
        Query query = currentSession().createQuery("from User");

        List list = query.list();
        Iterator<User> it = list.iterator();
        while (it.hasNext()){
            User user = it.next();
            System.out.println(user.getFirstname());
        }
    }

    public List<User> queryByCriteria(){
        return currentSession().createCriteria(User.class)
                .add(Restrictions.eq("name","cdm")).list();
    }

}
