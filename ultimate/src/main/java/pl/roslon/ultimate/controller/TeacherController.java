package pl.roslon.ultimate.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.roslon.ultimate.entity.Student;
import pl.roslon.ultimate.entity.Teacher;
import pl.roslon.ultimate.payload.TeacherResponse;
import pl.roslon.ultimate.service.TeacherService;

@RestController
@AllArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/all-teachers-paging")
    public TeacherResponse getAllTeachers(@RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
                                          @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
                                          @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy,
                                          @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir) {
        return teacherService.getAllTeachers(pageNo, pageSize, sortBy, sortDir);
    }

    @GetMapping("/all-teachers-sort")
    public String getAllStudentsSorted() {
        teacherService.teachersSort();
        return ("index");
    }

    @PostMapping("/addTeacher")
    public String addSTeacher(Teacher teacher) {
        teacherService.save(teacher);
        return ("redirect:/saveTeacher");
    }

    @GetMapping("/teacher/edit/{id}")
    public String editTeacher(@PathVariable("id") long id, Teacher teacher) {
        teacherService.editTeacher(id, teacher);
        return ("update-teacher");
    }

    @GetMapping("/teacher/delete/{id}")
    public String deleteTeacher(@PathVariable("id") long id, Teacher teacher) {
        teacherService.deleteTeacher(id, teacher);
        return "redirect:/index";
    }

    @GetMapping("/indexTeacher")
    public String showTeachersList() {
        teacherService.showTeachersList();
        return "index";
    }

    @GetMapping("/delete-student")
    public String deleteStudentFromTeacher(Student student) {
        teacherService.deleteStudent(student);
        return "index";
    }

    @GetMapping("/find-student")
    public String findStudentByNameAndSurname(String name, String surname) {
        teacherService.findStudentByNameAndSurname(name, surname);
        return "index";
    }

    @GetMapping("/find-all-students")
    public String findAllStudentsForOneTeacher(Teacher teacher) {
        teacherService.findAllStudentsForOneTeacher(teacher);
        return "index";
    }
}
