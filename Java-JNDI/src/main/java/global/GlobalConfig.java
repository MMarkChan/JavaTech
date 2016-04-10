package global;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 1、在tomcat的conf文件夹下的context.xml配置文件中加入
 * <Resource name="jndi/global"
     auth="Container"
     type="javax.sql.DataSource"
     driverClassName="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/global"
     username="root"
     password=""
     maxActive="20"
     maxIdle="10"
     maxWait="10000"/>

 * 2、在项目的web.xml中加入资源引用
    <resource-ref>
        <description>JNDI DataSource</description>
        <res-ref-name>jndi/global</res-ref-name>
        <res-type>javax.sql.DataSource</res-type>
        <res-auth>Container</res-auth>
    </resource-ref>
    其中res-ref-name值要和context.xml的name值一致。

    3、JNDI测试代码如下：
 */
public class GlobalConfig {
    public boolean test() throws NamingException, SQLException {
        Context ctx = new InitialContext();
        DataSource ds = (DataSource) ctx.lookup("java:comp/env/jndi/global");
        Connection conn = ds.getConnection();
        return conn.isClosed();
    }
}

/**
 * 4、在jsp中调用加载jndi方式，不可以直接用main方法测试，必须通过启动容器从jsp中调用
     <%
         GlobalConfig global = new GlobalConfig();
         global.test();
     %>
 */
