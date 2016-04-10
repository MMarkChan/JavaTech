package asynchronous;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener("This is only a jdkwebservice listener")
public class ListenerTest implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Listener contextInitialized(ServletContextEvent sce)");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Listener contextDestroyed(ServletContextEvent sce)");
    }
}
