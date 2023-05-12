package peaksoft.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dao.StudentDao;
import peaksoft.entities.Group;
import peaksoft.entities.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
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
    public void updateStudent(Long studentId, Student student,Long groupId) {
        Group group = entityManager.find(Group.class,groupId);
        Student student1 =getStudentById(studentId);
        student1.setFirstName(student.getFirstName());
        student1.setLastName(student.getLastName());
        student1.setEmail(student.getEmail());
        student1.setStudyFormat(student.getStudyFormat());
        List<Student> students = new ArrayList<>();
        students.add(student1);
        group.setStudents(students);
        student1.setGroup(group);
        entityManager.merge(student1);

    }

    @Override
    public void deleteStudent(Student student) {
        entityManager.remove(entityManager.contains(student)? student:entityManager.merge(student));

    }

    @Override
    public List<Student> getStudentsByCompany(Long id) {
        List<Student> students = entityManager.createQuery("select s from Student  s join s.group  g  join   " +
                        " g.courses c join c.company com where com.id=?1")
                .setParameter(1,id).getResultList();
        return students;
    }
    @Override
    public List<Student> getStudentByName(String name){
        List<Student> students = entityManager.createQuery("select s from Student " +
                "s where s.firstName=?1").setParameter(1,name).getResultList();
        return students;
    }

    @Override
    public List<Student> getStudentsByTeacher(Long id) {
        List<Student> students = entityManager.createQuery("select s from Student  s join s.group  g  join   " +
                        " g.courses c join c.teacher t where t.id=?1")
                .setParameter(1,id).getResultList();
        return students;
    }

}
