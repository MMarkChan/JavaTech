package getstarted.installandconfigure;

import getstarted.installandconfigure.model.Student;
import getstarted.installandconfigure.service.StudentService;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.Date;
import java.util.List;


/**
 *
 * @BeforeClass：针对所有测试，只执行一次，且必须为static void
 @Before：初始化方法
 @Test：测试方法，在这里可以测试期望异常和超时时间
 @After：释放资源
 @AfterClass：针对所有测试，只执行一次，且必须为static void
 @Ignore：忽略的测试方法

 一个单元测试用例执行顺序为：
 @BeforeClass –> @Before –> @Test –> @After –> @AfterClass
 每一个测试方法的调用顺序为：
 @Before –> @Test –> @After
 */
public class StudentServiceTest
{
    private static StudentService studentService;
    @BeforeClass
    public static void setup(){
        studentService = new StudentService();
    }
    @AfterClass
    public static void teardown(){
        studentService = null;
    }
    @Test
    public void testFindAllStudents() {
        List<Student> students = studentService.findAllStudents();
        assertNotNull(students);
        for (Student student : students) {
            System.out.println(student);
        }
    }
    @Test
    public void testFindStudentById() {
        Student student = studentService.findStudentById(1);
        assertNotNull(student);
        System.out.println(student);
    }
    @Test
    public void testCreateStudent() {
        Student student = new Student();
        int id = 3;
        student.setStudId(id);
        student.setName("student_"+id);
        student.setEmail("student_"+id+"gmail.com");
        student.setDob(new Date());
        studentService.createStudent(student);
        Student newStudent = studentService.findStudentById(id);
        assertNotNull(newStudent);
    }
}