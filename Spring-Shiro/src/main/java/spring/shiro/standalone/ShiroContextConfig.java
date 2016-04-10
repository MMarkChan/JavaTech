package spring.shiro.standalone;

import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroContextConfig {
    /**
     * Define the realm you want to use to connect to your back-end security datasource
     * @return
     */
    @Bean
    public Realm realm(){
        Realm realm = new IniRealm("classpath:shiro.ini");
        return realm;
    }

    /**
     *
     * @param realm
     * @return
     */
    @Bean
    public SecurityManager securityManager(Realm realm){
        //Single realm app.  If you have multiple realms, use the 'realms' property instead
        SecurityManager sm = new DefaultSecurityManager(realm);
        return sm;
    }

    @Bean
    public BeanPostProcessor postProcessor(){
        BeanPostProcessor bp = new LifecycleBeanPostProcessor();
        return bp;
    }

    /**
     * For simplest integration, so that all SecurityUtils.* methods work in all cases,
     make the securityManager bean a static singleton.  DO NOT do this in web
     applications - see the 'Web Applications' section below instead.
     * @return
     */
//    @Bean
//    public void invokingFactoryBean(SecurityManager securityManager){
//        MethodInvokingFactoryBean factory = new MethodInvokingFactoryBean();
//        factory.setStaticMethod("org.apache.shiro.SecurityUtils.setSecurityManager");
//        factory.setSingleton(true);
//        factory.setArguments(new SecurityManager[]{securityManager});
//    }
}
