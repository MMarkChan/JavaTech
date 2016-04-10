package sqlmapperusingxml.mappers;

import getstarted.installandconfigure.model.Student;
import getstarted.installandconfigure.model.Tutor;

import java.util.List;

public interface StudentMapper {
    List<Student> findAllStudents();
    Student findStudentById(Integer id);
    int insertStudent(Student student);
    int updateStudent(Student student);
    int deleteStudent(int studId);
    Student findStudentWithAddress(int studId);
}