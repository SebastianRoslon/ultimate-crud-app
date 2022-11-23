package pl.roslon.ultimate.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import pl.roslon.ultimate.entity.Student;
import pl.roslon.ultimate.entity.Teacher;
import pl.roslon.ultimate.payload.TeacherResponse;
import pl.roslon.ultimate.repository.TeacherRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class TeacherService {

    private final Teacher teacher;
    private final TeacherRepository teacherRepository;

    public TeacherResponse getAllTeachers(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Teacher> all = teacherRepository.findAll(pageable);
        List<Teacher> teachers = all.getContent();
        List<Teacher> content = teachers.stream().toList();

        TeacherResponse TeacherResponse = new TeacherResponse();
        TeacherResponse.setContent(content);
        TeacherResponse.setPageSize(all.getSize());
        TeacherResponse.setPageNo(all.getNumber());
        TeacherResponse.setTotalElements(all.getTotalElements());
        TeacherResponse.setTotalPages(all.getTotalPages());
        TeacherResponse.setLast(all.isLast());
        return TeacherResponse;
    }

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

    public List<Student> addStudent(Student student) {
        teacher.getStudentList().add(student);
        return teacher.getStudentList();
    }

    public List<Student> deleteStudent(Student student) {
        teacher.getStudentList().remove(student);
        return teacher.getStudentList();
    }

    public List<Student> findStudentByNameAndSurname(String name, String surmane) {
        teacher.getStudentList().stream().filter(student -> student.getName().equals(name) && student.getSurname().equals(surmane)).toList();
        return teacher.getStudentList();
    }

    public List<Student> findAllStudentsForOneTeacher(Teacher teacher) {
        teacher.getStudentList().forEach(System.out::println);
        return teacher.getStudentList();
    }

}
