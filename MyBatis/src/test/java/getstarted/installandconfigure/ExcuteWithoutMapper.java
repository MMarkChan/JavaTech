package getstarted.installandconfigure;

import getstarted.installandconfigure.model.Student;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

/**
 * Created by Mark on 2016/3/17.
 */
public class ExcuteWithoutMapper {

    @Test
    public void test(){
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        Student student = sqlSession.selectOne(
                "getstarted.installandconfigure.mappers.StudentMapper.findStudentById",
                2);
        System.out.print(student.getEmail());
    }
}
