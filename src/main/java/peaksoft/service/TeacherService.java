package peaksoft.service;

import peaksoft.entities.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> getAllTeacher();
    Teacher getTeacherById(Long teacherId);
    void addTeacher(Long courseId,Teacher teacher);
    void updateTeacher(Long id,Teacher teacher);
    void deleteTeacher(Teacher teacher);

}
