package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entities.Course;
import peaksoft.entities.Student;
import peaksoft.entities.Teacher;
import peaksoft.service.CourseService;
import peaksoft.service.StudentService;
import peaksoft.service.TeacherService;

import java.util.List;

@Controller
@RequestMapping("/teachers")
public class TeacherController {
    private final TeacherService teacherService;
    private final CourseService courseService;
    private final StudentService studentService;
    @Autowired
    public TeacherController(TeacherService teacherService, CourseService courseService, StudentService studentService) {
        this.teacherService = teacherService;
        this.courseService = courseService;
        this.studentService = studentService;
    }

    @ModelAttribute("courseList")
    public List<Course> getCourseList(){
        return courseService.getAllCourses();
    }
    @GetMapping("/teachers")
    public String getAllTeachers(Model model){
        List<Teacher> teachers = teacherService.getAllTeacher();
        model.addAttribute("teachers",teachers);
        return "teacher/teachers";
    }
    @GetMapping("/addTeacher")
    public String addTeacher(Model model){
        model.addAttribute("teacher",new Teacher());
        return "teacher/saveTeacher";
    }
    @PostMapping("/saveTeacher")
    public String saveTeacher(@ModelAttribute("teacher")Teacher teacher){
        teacherService.addTeacher(teacher.getCourseId(), teacher);
        return "redirect:/teachers/teachers";
    }
    @GetMapping("/update/{id}")
    public String updateTeacher(@PathVariable("id")Long id, Model model){
        Teacher teacher = teacherService.getTeacherById(id);
        model.addAttribute("updateTeacher",teacher);
        return "teacher/updateTeacher";
    }
    @PatchMapping("/{id}")
    public String saveTeacherUpdate(@PathVariable("id")Long id,@ModelAttribute("teacher")Teacher teacher){
        teacherService.updateTeacher(id,teacher, teacher.getCourseId());
        return "redirect:/teachers/teachers";
    }
    @DeleteMapping("/delete")
    public String deleteTeacher(@RequestParam("id")Long id){
        Teacher teacher = teacherService.getTeacherById(id);
        teacherService.deleteTeacher(teacher);
        return "redirect:/teachers/teachers";
    }
    @GetMapping("/students/{teacherId}")
    public String getStudentsByCompany(@PathVariable("teacherId") Long teacherId,Model model){
        List<Student>studentList = studentService.getStudentsByTeacher(teacherId);
        model.addAttribute("studentList",studentList);
        model.addAttribute("count",studentList.size());
        return "teacher/getStudents";
    }
}
