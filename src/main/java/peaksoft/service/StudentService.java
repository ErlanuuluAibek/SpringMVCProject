package peaksoft.service;

import peaksoft.entities.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(Long studentId);
    void addStudent(Long id,Student student);
    void updateStudent(Long studentId,Student student,Long groupId);
    void deleteStudent(Student student);
    List<Student> getStudentsByCompany(Long id);
    List<Student> getStudentByName(String name);
    List<Student> getStudentsByTeacher(Long id);
}
