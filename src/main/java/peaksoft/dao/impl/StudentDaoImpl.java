package peaksoft.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dao.StudentDao;
import peaksoft.entities.Group;
import peaksoft.entities.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Student> getAllStudents() {
        List<Student> students = entityManager.createQuery("From Student ",Student.class).getResultList();
        return students;
    }

    @Override
    public Student getStudentById(Long studentId) {
        Student student = entityManager.find(Student.class,studentId);
        return student;
    }

    @Override
    public void addStudent(Long id,Student student) {
        Group group= entityManager.find(Group.class,id);
        student.setGroup(group);
        entityManager.persist(student);
    }

    @Override
    public void updateStudent(Long studentId, Student student) {
        Student student1 = entityManager.find(Student.class,studentId);
        student1.setFirstName(student.getFirstName());
        student1.setEmail(student.getEmail());
        student1.setStudyFormat(student.getStudyFormat());
        entityManager.merge(student1);

    }

    @Override
    public void deleteStudent(Student student) {
        entityManager.remove(entityManager.contains(student)? student:entityManager.merge(student));

    }
}
