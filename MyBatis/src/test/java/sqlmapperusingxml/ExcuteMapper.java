package sqlmapperusingxml;

import getstarted.installandconfigure.MyBatisSqlSessionFactory;
import getstarted.installandconfigure.model.Student;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;
import org.testng.internal.PackageUtils;
import sqlmapperusingxml.service.CourseService;
import sqlmapperusingxml.service.StudentService;
import sqlmapperusingxml.service.TutorService;
import sqlmapperusingxml.service.UserPicService;

/**
 * Created by Mark on 2016/3/17.
 */
public class ExcuteMapper {

    @Test
    public void test(){
        StudentService service = new StudentService();
        Student student = service.findStudentById(2);
        System.out.print(student.getEmail());
    }

    @Test
    public void printOneToOneAssociate(){
        StudentService service = new StudentService();
        service.printOneToOneAssociate(2);
    }
    @Test
    public void printOneToManyAssociate(){
        TutorService service = new TutorService();
        service.findTutorById(2);
    }

    @Test
    public void searchCourses(){
        CourseService service = new CourseService();
        service.searchCourses();
    }

    @Test
    public void searchCoursesByTutors(){
        CourseService service = new CourseService();
        service.searchCoursesByTutors();
    }

    @Test
    public void insertBlobAndClob(){
        UserPicService service = new UserPicService();
        service.insertUserPic();
        service.getUserPic();
    }
}
