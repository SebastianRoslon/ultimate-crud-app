package pl.roslon.ultimate.entity;

import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Getter
@Entity(name = "teachers")
@Component
@Data
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


    public static class TeacherNameComparator implements Comparator<Teacher> {
        @Override
        public int compare(Teacher o1, Teacher o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }
}
