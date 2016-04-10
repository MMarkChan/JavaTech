package advanced.beanscope;

import advanced.model.BlankDisc;
import advanced.model.CompactDisc;
import advanced.model.Notepad;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

/**
 * Created by Mark on 2016/3/25.
 */
public class BeanScopeConfig {
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Notepad notepad() {
        return new Notepad();
    }

    @Bean
    public CompactDisc sgtPeppers() {
        return new BlankDisc(
                "Sgt. Pepper's Lonely Hearts Club Band",
                "The Beatles");
    }
}
