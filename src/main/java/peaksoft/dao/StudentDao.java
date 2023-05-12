package peaksoft.dao;

import peaksoft.entities.Student;

import java.util.List;

public interface StudentDao {
    List<Student> getAllStudents();
    Student getStudentById(Long studentId);
    void addStudent(Long groupId,Student student);
    void updateStudent(Long studentId,Student student,Long groupId);
    void deleteStudent(Student student);
    List<Student> getStudentsByCompany(Long id);
    List<Student> getStudentByName(String name);
    List<Student> getStudentsByTeacher(Long id);
}
