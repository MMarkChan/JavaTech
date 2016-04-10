package hibernate.config;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.PlaceholderConfigurerSupport;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import hibernate.repository.jpa.JpaRepository;

@Configuration
@ComponentScan(basePackageClasses = JpaRepository.class)
@EnableTransactionManagement

public class JpaContextConfig {
//    @Bean
//    public DriverManagerDataSource dataSource(){
//        DriverManagerDataSource ds = new DriverManagerDataSource();
//        ds.setDriverClassName("com.mysql.jdbc.Driver");
//        ds.setUrl("jdbc:mysql://localhost:3306/global");
//        ds.setUsername("root");
//        ds.setPassword("");
//        return ds;
//    }

    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactory(JpaVendorAdapter adapter){
        LocalEntityManagerFactoryBean emf = new LocalEntityManagerFactoryBean();
        emf.setPersistenceUnitName("jpaUnit");
        emf.setJpaVendorAdapter(adapter);
        return emf;
    }

    @Bean
    public BeanPostProcessor persistenceExceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        HibernateJpaVendorAdapter jva = new HibernateJpaVendorAdapter();
        return jva;
    }

    @Bean
    public JpaTransactionManager jpaTransactionManager(){
        JpaTransactionManager jtm = new JpaTransactionManager();
        jtm.setPersistenceUnitName("jpaUnit");
        return jtm;
    }


}


