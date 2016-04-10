package sqlmapperusingxml.mappers;

import getstarted.installandconfigure.model.Course;

import java.util.List;
import java.util.Map;

public interface CourseMapper {
    List<Course> searchCourses(Map<String, Object> map);
    List<Course> searchCoursesByTutors(Map<String, Object> map);
}