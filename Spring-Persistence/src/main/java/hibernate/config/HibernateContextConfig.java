package hibernate.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import hibernate.repository.hibernate.HibernateRepository;


import java.util.Properties;


@Configuration
@ComponentScan(basePackageClasses = HibernateRepository.class)
@EnableTransactionManagement
public class HibernateContextConfig {
    @Bean
    public DriverManagerDataSource dataSource(){
        DriverManagerDataSource dms = new DriverManagerDataSource();
        dms.setDriverClassName("com.mysql.jdbc.Driver");
        dms.setUrl("jdbc:mysql://localhost:3306/global");
        dms.setUsername("root");
        dms.setPassword("");

        return dms;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactoryBean(DriverManagerDataSource dataSource){
        LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();
        sfb.setDataSource(dataSource);
        sfb.setPackagesToScan("hibernate/model");
        Properties properties = new Properties();
        properties.put("dialect","org.hibernate.dialect.MySQLDialect");
        properties.put("hibernate.show_sql",true);
        properties.put("hibernate.format_sql",true);
        sfb.setHibernateProperties(properties);
        return sfb;
    }

    @Bean
    public HibernateTransactionManager hibernateTransactionManager(SessionFactory sessionFactory){
        HibernateTransactionManager htm = new HibernateTransactionManager();
        htm.setSessionFactory(sessionFactory);
        return htm;
    }

    @Bean
    public BeanPostProcessor persistenceTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

}
