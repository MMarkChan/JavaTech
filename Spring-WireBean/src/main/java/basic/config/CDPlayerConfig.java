package basic.config;

import basic.autowire.MediaPlayer;
import basic.componentscan.CompactDisc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * 使用@ComponentScan开启Spring的组件扫描功能
 * @ComponentScan默认扫描与当前配置类所处的包，它的XML配置方式的等价物如下：
 *
 *      <?xml version="1.0" encoding="UTF-8"?>
 *     <beans xmlns="http://www.springframework.org/schema/beans"
 *          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
 *          xmlns:context="http://www.springframework.org/schema/context"
 *          xsi:schemaLocation="http://www.springframework.org/schema/beans
 *          http://www.springframework.org/schema/beans/spring-beans.xsd
 *          http://www.springframework.org/schema/context
 *          http://www.springframework.org/schema/context/spring-context.xsd">
 *          <context:component-scan base-package="basic.componentscan" />
 *          <context:component-scan base-package="basic.autowire" />
 *     </beans>
 *
 *     <context:basic.componentscan>的属性和子元素与@ComponentScan的属性有对应关系。
 *
 *     任何在autowire包或子包下的类都会被扫描。
 */
@Configuration
@ComponentScan(basePackageClasses = {CompactDisc.class, MediaPlayer.class})
public class CDPlayerConfig {
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }


}