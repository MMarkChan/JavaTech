package hibernate.config;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import hibernate.repository.containerjpa.ContainerJpaRepository;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackageClasses = ContainerJpaRepository.class)
public class ContainerJpaContextConfig {
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
    public DataSource dataSource(){
        EmbeddedDatabase ed = new EmbeddedDatabaseBuilder()
                .addScript("classpath:dbscripts/schema.sql")
                .addScript("classpath:dbscripts/data.sql")
                .build();
        return ed;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter){
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource);
        emf.setJpaVendorAdapter(jpaVendorAdapter);
        emf.setPackagesToScan("hibernate/model");
        Properties properties = new Properties();
        properties.put("hibernate.format_sql",true);
        emf.setJpaProperties(properties);
        return emf;
    }


//    @Bean
//    public JndiObjectFactoryBean entityManagerFactory() {}
//        JndiObjectFactoryBean jndiObjectFB = new JndiObjectFactoryBean();
//        jndiObjectFB.setJndiName("jdbc/SpittrDS");
//        return jndiObjectFB;
//    }



    @Bean
    public BeanPostProcessor persistenceExceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.MYSQL);
        adapter.setShowSql(true);
        adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
        adapter.setGenerateDdl(false);
        return adapter;
    }



}
