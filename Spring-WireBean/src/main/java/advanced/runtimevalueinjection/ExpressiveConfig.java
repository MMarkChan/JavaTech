package advanced.runtimevalueinjection;

import advanced.model.BlankDisc;
import advanced.model.CompactDisc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:application.properties")
public class ExpressiveConfig {
    @Autowired
    Environment env;

    @Bean
    public BlankDisc disc() {
        return new BlankDisc(
            env.getProperty("disc.title"),
            env.getProperty("disc.artist"));
    }

    @Bean
    public BlankDisc discWithDefaultValue() {
        return new BlankDisc(
                env.getProperty("disc.title1","Mark8 Albulm"),
                env.getProperty("disc.artist"));
    }

    @Bean
    public BlankDisc requiredProperty() {

        return new BlankDisc(
                env.getRequiredProperty("disc.title4"),
                env.getRequiredProperty("disc.artist4"));
    }

    @Bean
    public BlankDisc other() {
        //containsProperty()方法来判断一个属性是否存在
        boolean titleExists = env.containsProperty("disc.title");
        //getPropertyAsClass()把一个属性解析为类
        Class<CompactDisc> cdClass =
                env.getPropertyAsClass("disc.class", CompactDisc.class);
        return new BlankDisc(
                env.getRequiredProperty("disc.title4"),
                env.getRequiredProperty("disc.artist4"));
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
