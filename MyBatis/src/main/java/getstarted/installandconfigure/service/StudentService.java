package getstarted.installandconfigure.service;

import getstarted.installandconfigure.MyBatisSqlSessionFactory;
import getstarted.installandconfigure.mappers.StudentMapper;
import getstarted.installandconfigure.model.Student;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.LoggerFactory;

import java.util.List;

public class StudentService {
    private org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

    public List<Student> findAllStudents() {
        SqlSession sqlSession =  MyBatisSqlSessionFactory.openSession();
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            return studentMapper.findAllStudents();
        } finally {
            //If sqlSession is not closed
            //then database Connection associated this sqlSession will not be  returned to pool
            //and application may run out of connections.
            sqlSession.close();
        }
    }

    public Student findStudentById(Integer studId) {
        logger.debug("Select Student By ID :{}", studId);
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            return studentMapper.findStudentById(studId);
        } finally {
            sqlSession.close();
        }
    }

    public void createStudent(Student student) {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            studentMapper.insertStudent(student);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }


}