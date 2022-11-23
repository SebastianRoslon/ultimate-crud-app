package pl.roslon.ultimate.controller;

import org.springframework.web.bind.annotation.*;
import pl.roslon.ultimate.entity.Student;
import pl.roslon.ultimate.entity.Teacher;
import pl.roslon.ultimate.payload.StudentResponse;
import pl.roslon.ultimate.service.StudentService;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/all-student-paging")
    public StudentResponse getAllStudents(@RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
                                          @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
                                          @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy,
                                          @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir) {
        return studentService.getAllStudents(pageNo, pageSize, sortBy, sortDir);
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
        studentService.deleteStudent(id, student);
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String showStudentsList() {
        studentService.showStudentsList();
        return "index";
    }

    @PostMapping("/add-teacher")
    public String addTeacherToStudent(Teacher teacher) {
        studentService.addTeacherToStudentsList(teacher);
        return "index";
    }

    @GetMapping("/delete-teacher")
    public String deleteTeacherFromStudent(Teacher teacher) {
        studentService.deleteTeacherFromStudentsList(teacher);
        return "index";
    }

    @GetMapping("/find-teacher")
    public String findTeacherByNameAndSurname(String name, String surname) {
        studentService.findTeacherByNameAndSurname(name, surname);
        return "index";
    }

    @GetMapping("/find-all-teacher")
    public String findAllTeachersForOneStudent(Student student) {
        studentService.findAllTeachersForOneStudent(student);
        return "index";
    }
}
