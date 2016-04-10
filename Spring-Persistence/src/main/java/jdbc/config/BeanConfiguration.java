package jdbc.config;

import jdbc.repository.JdbcRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

@Configuration
@ComponentScan(basePackageClasses = JdbcRepository.class)
public class BeanConfiguration {
    @Bean
    public SingleConnectionDataSource dataSource(){
        SingleConnectionDataSource scd = new SingleConnectionDataSource();
        scd.setDriverClassName("org.hsqldb.jdbc.JDBCDriver");
        scd.setUrl("jdbc:hsqldb:mem:global");
        scd.setUsername("sa");
        scd.setPassword("");
        return scd;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(SingleConnectionDataSource dataSource){
        JdbcTemplate jt = new JdbcTemplate(dataSource);
        return jt;
    }
}
