package pl.roslon.ultimate.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import pl.roslon.ultimate.Student;
import pl.roslon.ultimate.Teacher;
import pl.roslon.ultimate.repository.TeacherRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class TeacherService {

    private final Teacher teacher;
    private final TeacherRepository teacherRepository;

    public String save(Teacher teacher) {
        teacherRepository.save(teacher);
        return ("redirect:/saveTeacher");
    }

    public String editTeacher(@PathVariable("id") long id, Teacher teacher) {
        teacherRepository.save(teacher);
        return ("update-teacher");
    }

    public String deleteTeacher(@PathVariable("id") long id, Teacher teacher) {
        teacherRepository.delete(teacher);
        return "redirect:/index";
    }

    public String showTeachersList() {
        teacherRepository.findAll();
        return "index";
    }

    List<Student> addStudent(Student student) {
        teacher.getStudentList().add(student);
        return teacher.getStudentList();
    }

    List<Student> deleteStudent(Student student) {
        teacher.getStudentList().remove(student);
        return teacher.getStudentList();
    }

    List<Student> findStudentByNameAndSurname(String name, String surmane) {
        teacher.getStudentList().stream().filter(student -> student.getName().equals(name) && student.getSurname().equals(surmane)).toList();
        return teacher.getStudentList();
    }

    List<Student> findAllStudentsForOneTeacher(String teacherName) {
        teacher.getStudentList().forEach(System.out::println);
        return teacher.getStudentList();
    }

}
