package pl.roslon.ultimate.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.roslon.ultimate.Student;
import pl.roslon.ultimate.repository.StudentRepository;
import pl.roslon.ultimate.repository.TeacherRepository;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    public Controller(StudentRepository studentRepository, TeacherRepository teacherRepository) {
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }


    @PostMapping("/addStudent")
    public String addStudent(Student student) {
        studentRepository.save(student);
        return ("redirect:/saveStudent");
    }

    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable("id") long id, Student student) {
        studentRepository.save(student);
        return ("update-student");
    }

    @GetMapping("/delete/{id}")
    public String deleteStudnet(@PathVariable("id") Student student) {
        studentRepository.delete(student);
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String showStudentsList() {
        studentRepository.findAll();
        return "index";
    }





}
