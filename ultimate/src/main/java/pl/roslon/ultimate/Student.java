package pl.roslon.ultimate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Entity
@Data
@AllArgsConstructor
public class Student{

    @Id
    private long id;
    @Size(min = 10)
    private String name;
    private String surname;
    @Min(value = 18)
    private int age;
    @Email(message = "Email should be valid")
    private String email;
    private String specialization;
    private Teacher teacher;




    private List<Teacher> teacherList = new ArrayList<>();
    List<Teacher> addTeacher(Teacher teacher) {
        teacherList.add(teacher);
        return teacherList;
    }

    List<Teacher> deleteTeacher(Teacher teacher) {
        teacherList.remove(teacher);
        return teacherList;
    }

    List<Teacher> findTeacherByNameAndSurname(String name, String surmane) {
        teacherList.stream().filter(teacher -> teacher.getName().equals(name) && teacher.getSurname().equals(surmane)).toList();
        return teacherList;
    }

    List<Teacher> findAllTeachersForOneStudents(String name) {
        teacherList.stream().filter(student -> student.getName().equals(name));
        return teacherList;
    }


}

