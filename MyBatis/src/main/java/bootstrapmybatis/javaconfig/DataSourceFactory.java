package bootstrapmybatis.javaconfig;

import org.apache.ibatis.datasource.pooled.PooledDataSource;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataSourceFactory{
    public static DataSource getDataSource(){
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mybatisdemo";
        String username = "root";
        String password = "admin";
        PooledDataSource dataSource = new PooledDataSource(driver, url,username, password);
        return dataSource;
    }

    public static DataSource getJndiDataSource(){
        String jndiName = "java:comp/env/jdbc/MyBatisDemoDS";
        try {
            InitialContext ctx = new InitialContext();
            DataSource dataSource = (DataSource) ctx.lookup(jndiName);
            return dataSource;
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }

        
    }
}