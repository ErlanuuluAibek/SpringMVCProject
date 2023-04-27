package peaksoft.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dao.CourseDao;
import peaksoft.entities.Company;
import peaksoft.entities.Course;
import peaksoft.entities.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
@Transactional
public class CourseDaoImpl implements CourseDao {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Course> getAllCourses() {
      List<Course> courses = entityManager.createQuery("from Course ",Course.class).getResultList();
      return courses;
    }

    @Override
    public Course getCourseById(Long courseId) {
        Course course = entityManager.find(Course.class,courseId);
        return course;
    }

    @Override
    public void addCourse(Long id,Course course) {
        Company company = entityManager.find(Company.class,id);
        course.setCompany(company);
        entityManager.persist(course);
    }

    @Override
    public void updateCourse(Long courseId, Course course) {
        Course course1 = getCourseById(courseId);
        course1.setCourseName(course.getCourseName());
        course1.setDurationMonth(course.getDurationMonth());
        entityManager.merge(course1);
    }

    @Override
    public void deleteCourse(Course course) {
        entityManager.remove(entityManager.contains(course)? course:entityManager.merge(course));
    }
}
