package bootstrapmybatis.xmlconfig;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Mark on 2016/3/24.
 */
public class XmlConfigTest {
    @Test
    public void sqlSessionFactory() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory defaultSqlSessionFactory = new SqlSessionFactoryBuilder().
                build(inputStream);
        SqlSessionFactory cartSqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream,"shoppingcart");
        SqlSessionFactory reportSqlSessionFactory = new SqlSessionFactoryBuilder().
                build(inputStream,"reports");
    }
}
