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
import pl.roslon.ultimate.payload.StudentResponse;
import pl.roslon.ultimate.repository.StudentRepository;

import java.util.List;

@Service
//@NoArgsConstructor
@AllArgsConstructor
public class StudentService {
    private final Student student;
    private final StudentRepository studentRepository;

    public StudentResponse getAllStudents(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Student> all = studentRepository.findAll(pageable);
        List<Student> students = all.getContent();
        List<Student> content = students.stream().toList();

        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setContent(content);
        studentResponse.setPageSize(all.getSize());
        studentResponse.setPageNo(all.getNumber());
        studentResponse.setTotalElements(all.getTotalElements());
        studentResponse.setTotalPages(all.getTotalPages());
        studentResponse.setLast(all.isLast());
        return studentResponse;
    }


    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public Student editStudent(@PathVariable("id") long id, Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudnet(@PathVariable("id") long id, Student student) {
        studentRepository.delete(student);
    }


    public List<Student> showStudentsList() {
        return (List<Student>) studentRepository.findAll();
    }

    public List<Teacher> addTeacherToStudentsList(Teacher teacher) {
        student.getTeachersList().add(teacher);
        return student.getTeachersList();
    }

    public List<Teacher> deleteTeacherFromStudentsList(Teacher teacher) {
        student.getTeachersList().remove(teacher);
        return student.getTeachersList();
    }

    public List<Teacher> findTeacherByNameAndSurname(String name, String surmane) {
        student.getTeachersList().stream().filter(teacher -> teacher.getName().equals(name) && teacher.getSurname().equals(surmane)).toList();
        return student.getTeachersList();
    }

    public List<Teacher> findAllTeachersForOneStudent(Student student) {
        student.getTeachersList().forEach(System.out::println);
        return student.getTeachersList();
    }
}