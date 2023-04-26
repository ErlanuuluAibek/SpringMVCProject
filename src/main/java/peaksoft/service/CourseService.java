package peaksoft.service;

import peaksoft.entities.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();
    Course getCourseById(Long courseId);
    void addCourse(Long id,Course course);
    void updateCourse(Long courseId,Course course);
    void deleteCourse(Course course);
}
