package pl.roslon.ultimate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.roslon.ultimate.Student;
import pl.roslon.ultimate.service.StudentService;

@org.springframework.stereotype.Controller
public class Controller {

    private final StudentService studentService;

    public Controller(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/addStudent")
    public String addStudent(Student student) {
        studentService.save(student);
        return ("redirect:/saveStudent");
    }

    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable("id") long id, Student student) {
        studentService.editStudent(id, student);
        return ("update-student");
    }

    @GetMapping("/delete/{id}")
    public String deleteStudnet(@PathVariable("id") long id, Student student) {
        studentService.deleteStudnet(id, student);
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String showStudentsList() {
        studentService.showStudentsList();
        return "index";
    }
}
