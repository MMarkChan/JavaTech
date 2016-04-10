package bootstrapmybatis.javaconfig;

import bootstrapmybatis.xmlconfig.typehandler.PhoneTypeHandler;
import getstarted.installandconfigure.mappers.StudentMapper;
import getstarted.installandconfigure.model.PhoneNumber;
import getstarted.installandconfigure.model.Student;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;

public class CreateSqlSessionFactory {
    public static SqlSessionFactory getSqlSessionFactory() {
        SqlSessionFactory sqlSessionFactory;
        try{
            DataSource dataSource = DataSourceFactory.getDataSource();
            TransactionFactory transactionFactory = new JdbcTransactionFactory();
            Environment environment = new Environment("development", transactionFactory, dataSource);
            Configuration configuration = new Configuration(environment);
            configuration.getTypeAliasRegistry().registerAlias("student", Student.class);
            configuration.getTypeHandlerRegistry().register(PhoneNumber.class,PhoneTypeHandler.class);
            configuration.addMapper(StudentMapper.class);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return sqlSessionFactory;
    }


}
