package peaksoft.dao;

import peaksoft.entities.Company;
import peaksoft.entities.Course;

import java.util.List;

public interface CourseDao {
    List<Course> getAllCourses();
    Course getCourseById(Long courseId);
    void addCourse(Long companyId,Course course);
    void updateCourse(Long Id,Course course,Long companyId);
    void deleteCourse(Course course);
}
