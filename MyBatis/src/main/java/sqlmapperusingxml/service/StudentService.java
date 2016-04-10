package sqlmapperusingxml.service;

import getstarted.installandconfigure.model.Course;
import getstarted.installandconfigure.model.Student;
import getstarted.installandconfigure.model.Tutor;
import org.apache.ibatis.session.SqlSession;
import sqlmapperusingxml.MyBatisUtil;
import sqlmapperusingxml.mappers.StudentMapper;
import sqlmapperusingxml.mappers.TutorMapper;

import java.util.HashMap;
import java.util.List;

public class StudentService {
    public Student findStudentByIdWithoutMapperInterface(Integer studId) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try {
            Student student = sqlSession.selectOne("sqlmapperusingxml.mappers.StudentMapper.findStudentById", studId);
            return student;
        } finally {
            sqlSession.close();
        }
    }

    public Student findStudentById(Integer studId) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();


        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            return studentMapper.findStudentById(studId);
        } finally {
            sqlSession.close();
        }
    }

    public int insertStudent(Student student){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        int count = mapper.insertStudent(student);
        return count;
    }

    public int updateStudentWithoutMapperInterface(Student student){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        int noOfRowsUpdated = sqlSession.update("sqlmapperusingxml.mappers.StudentMapper.updateStudent", student);
        return noOfRowsUpdated;
    }

    public int updateStudent(Student student){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        int noOfRowsUpdated = mapper.updateStudent(student);
        return noOfRowsUpdated;
    }

    public int deleteStudentWithoutMapperInterface(int studId){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        int noOfRowsDeleted = sqlSession.delete("sqlmapperusingxml.mappers.StudentMapper.deleteStudent", studId);
        return noOfRowsDeleted;
    }

    public int deleteStudent(int studId){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        int noOfRowsDeleted = mapper.deleteStudent(studId);
        return noOfRowsDeleted;
    }

    public Student findStudentWithoutMapperInterface(int studId){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        Student student = sqlSession.selectOne("sqlmapperusingxml.mappers.StudentMapper.findStudentById", studId);
        return student;
    }

    public Student findStudent(int studId){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.findStudentById(studId);
        return student;
    }

    public List<Student> findAllStudentWithoutMapperInterface(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        List<Student> students = sqlSession.selectList("sqlmapperusingxml.mappers.StudentMapper.findAllStudents");
        return students;
    }

    public List<Student> findAllStudent() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.findAllStudents();
        return students;
    }

    public void printOneStudent(int studId){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        HashMap<String,Object> studentMap = sqlSession.selectOne("sqlmapperusingxml.mappers.StudentMapper.findStudentById", studId);
        System.out.println("stud_id :"+studentMap.get("stud_id"));
        System.out.println("name :"+studentMap.get("name"));
        System.out.println("email :"+studentMap.get("email"));
        System.out.println("phone :"+studentMap.get("phone"));
    }

    public void printMultiStudent(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        List<HashMap<String,Object>> studentMapList =
                sqlSession.selectList("sqlmapperusingxml.mappers.StudentMapper.findAllStudents");
        for(HashMap<String,Object> studentMap : studentMapList){
            System.out.println("studId :"+studentMap.get("stud_id"));
            System.out.println("name :"+studentMap.get("name"));
            System.out.println("email :"+studentMap.get("email"));
            System.out.println("phone :"+studentMap.get("phone"));
        }
    }

    public void printOneToOneAssociate(int studId){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.findStudentWithAddress(studId);
        System.out.println(student);
        System.out.println(student.getAddress());
    }

}
