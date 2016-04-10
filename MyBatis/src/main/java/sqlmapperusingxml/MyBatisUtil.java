package sqlmapperusingxml;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {
    private static SqlSessionFactory sqlSessionFactory;
    public static SqlSessionFactory getSqlSessionFactory() {
        if(sqlSessionFactory==null) {
            synchronized (MyBatisUtil.class){
                if(sqlSessionFactory==null){
                    InputStream inputStream;
                    try {
                        inputStream = Resources.getResourceAsStream("sqlmapperusingxml-config.xml");
                        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
                    } catch (IOException e) {
                        throw new RuntimeException(e.getCause());
                    }
                }
            }
        }
        return sqlSessionFactory;
    }
    public static SqlSession getSqlSession() {
        return getSqlSessionFactory().openSession();
    }
}