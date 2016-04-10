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

public class TutorService {

    public Tutor findTutorById(int tutorId){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        TutorMapper mapper = sqlSession.getMapper(TutorMapper.class);
        Tutor tutor = mapper.findTutorById(2);
        System.out.println(tutor);
        List<Course> courses = tutor.getCourses();
        for (Course course : courses)
        {
            System.out.println(course);
        }
        return tutor;
    }
}
