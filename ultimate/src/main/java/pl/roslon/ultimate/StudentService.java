package pl.roslon.ultimate;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final Student student;

    public StudentService(Student student) {
        this.student = student;
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

    List<Teacher> findAllTeachersForOneStudents(String StudentName) {
        student.getTeachersList().forEach(System.out::println);
        return student.getTeachersList();
    }
}