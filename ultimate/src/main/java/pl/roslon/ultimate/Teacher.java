package pl.roslon.ultimate;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue
    private long id;
    @Size(min = 10)
    private String name;
    private String surname;
    @Min(value = 18)
    private int age;
    @Email(message = "Email should be valid")
    private String email;
    private String subject;
    @ManyToMany(mappedBy = "teachersList")
    private List<Student> studentList = new ArrayList<>();
//    public List<Student> addStudent(Student student) {
//        List<Student> studentList = new ArrayList<>();
//        studentList.add(student);
//        return studentList;
//    }

}
