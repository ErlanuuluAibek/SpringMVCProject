package peaksoft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.dao.TeacherDao;
import peaksoft.entities.Teacher;
import peaksoft.service.TeacherService;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherDao teacherDao;
    @Autowired
    public TeacherServiceImpl(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Override
    public List<Teacher> getAllTeacher() {
        return teacherDao.getAllTeacher();
    }

    @Override
    public Teacher getTeacherById(Long teacherId) {
        return teacherDao.getTeacherById(teacherId);
    }

    @Override
    public void addTeacher(Long courseId, Teacher teacher) {
        teacherDao.addTeacher(courseId,teacher);
    }

    @Override
    public void updateTeacher(Long id, Teacher teacher,Long courseId) {
        teacherDao.updateTeacher(id,teacher,courseId);
    }

    @Override
    public void deleteTeacher(Teacher teacher) {
        teacherDao.deleteTeacher(teacher);
    }


}