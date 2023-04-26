package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entities.Student;
import peaksoft.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String getMainPage(){
        return "student/studentMain";
    }
    @GetMapping("/students")
    public String getAllStudents(Model model){
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students",students);
        return "student/students";
    }
    @GetMapping("/addStudent")
    public String addStudent(Model model){
        model.addAttribute("student",new Student());
        return "student/saveStudent";
    }
    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student")Student student){
        studentService.addStudent(student);
        return "redirect:/students/students";
    }
    @GetMapping("/update/{id}")
    public String updateStudent(@PathVariable("id")Long id, Model model){
        Student student = studentService.getStudentById(id);
        model.addAttribute("studentUpdate",student);
        return "student/studentUpdate";
    }
    @PatchMapping("/{id}")
    public String saveStudentUpdate(@PathVariable("id")Long id,@ModelAttribute("student")Student student){
        studentService.updateStudent(id,student);
        return "redirect:/students";
    }
    @DeleteMapping("/delete")
    public String deleteStudent(@RequestParam("id")Long id){
        Student student = studentService.getStudentById(id);
        studentService.deleteStudent(student);
        return "redirect:/students";
    }
}
