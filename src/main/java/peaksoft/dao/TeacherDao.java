package peaksoft.dao;

import peaksoft.entities.Student;
import peaksoft.entities.Teacher;

import java.util.List;

public interface TeacherDao {
    List<Teacher> getAllTeacher();
    Teacher getTeacherById(Long teacherId);
    void addTeacher(Long courseId,Teacher teacher);
    void updateTeacher(Long id,Teacher teacher,Long courseId);
    void deleteTeacher(Teacher teacher);


}
