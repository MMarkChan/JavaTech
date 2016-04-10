package sqlmapperusingxml.service;

import getstarted.installandconfigure.model.Course;
import getstarted.installandconfigure.model.Tutor;
import org.apache.ibatis.session.SqlSession;
import sqlmapperusingxml.MyBatisUtil;
import sqlmapperusingxml.mappers.CourseMapper;
import sqlmapperusingxml.mappers.TutorMapper;

import java.util.*;

public class CourseService {

    public void searchCourses(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        Map<String, Object> map = new HashMap<>();
        map.put("tutorId", 2);
        map.put("courseName", "%java%");
        map.put("startDate", new Date());
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
        List<Course> courses = mapper.searchCourses(map);
        for (Course course : courses) {
            System.out.println(course.getName());
        }
    }

    public void searchCoursesByTutors() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        Map<String, Object> map = new HashMap<String, Object>();
        List<Integer> tutorIds = new ArrayList<Integer>();
        tutorIds.add(1);
        tutorIds.add(2);
        tutorIds.add(3);
        map.put("tutorIds", tutorIds);
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
        List<Course> courses = mapper.searchCoursesByTutors(map);
        for (Course course : courses) {
            System.out.println(course.getName());
        }
    }
}
