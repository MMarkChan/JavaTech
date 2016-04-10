package local;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 1、在tomcat的server.xml的<host>标签内，添加
 <Resource name="jndi/local_0"
     auth="Container"
     type="javax.sql.DataSource"
     driverClassName="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/local_0"
     username="root"
     password=""
     maxActive="20"
     maxIdle="10"
     maxWait="10000"/>

 * 2、在项目的web.xml中加入资源引用
    <resource-ref>
        <description>JNDI DataSource</description>
        <res-ref-name>jndi/local_0</res-ref-name>
        <res-type>javax.sql.DataSource</res-type>
        <res-auth>Container</res-auth>
    </resource-ref>
    其中res-ref-name值要和server.xml的name值一致。

    3、JNDI测试代码如下：
 */
public class LocalConfig0 {
    public boolean test() throws NamingException, SQLException {
        Context ctx = new InitialContext();
        DataSource ds = (DataSource) ctx.lookup("java:/jndi/local_0");
        Connection conn = ds.getConnection();
        return conn.getAutoCommit();
    }
}

/**
 * 4、在jsp中调用加载jndi方式，不可以直接用main方法测试，必须通过启动容器从jsp中调用
     <%
         LocalConfig config = new LocalConfig();
         config.test();
     %>
 */
