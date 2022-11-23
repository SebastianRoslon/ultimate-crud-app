package pl.roslon.ultimate.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.roslon.ultimate.Student;
import pl.roslon.ultimate.Teacher;
import pl.roslon.ultimate.repository.StudentRepository;

import java.util.List;

@Service
//@NoArgsConstructor
@AllArgsConstructor
public class StudentService {
    private final Student student;
    private final StudentRepository studentRepository;



    public String save(Student student) {
        studentRepository.save(student);
        return ("redirect:/saveStudent");
    }

    public String editStudent(@PathVariable("id") long id, Student student) {
        studentRepository.save(student);
        return ("update-student");
    }

    public String deleteStudnet(@PathVariable("id") long id, Student student) {
        studentRepository.delete(student);
        return "redirect:/index";
    }


    public String showStudentsList() {
        studentRepository.findAll();
        return "index";
    }

    List<Teacher> addTeacher(Teacher teacher) {
        student.getTeachersList().add(teacher);
        return student.getTeachersList();
    }

    List<Teacher> deleteTeacher(Teacher teacher) {
        student.getTeachersList().remove(teacher);
        return student.getTeachersList();
    }

    List<Teacher> findTeacherByNameAndSurname(String name, String surmane) {
        student.getTeachersList().stream().filter(teacher -> teacher.getName().equals(name) && teacher.getSurname().equals(surmane)).toList();
        return student.getTeachersList();
    }

    List<Teacher> findAllTeachersForOneStudent(String StudentName) {
        student.getTeachersList().forEach(System.out::println);
        return student.getTeachersList();
    }
}