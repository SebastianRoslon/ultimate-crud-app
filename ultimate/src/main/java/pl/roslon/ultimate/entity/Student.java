package pl.roslon.ultimate.entity;

import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Entity(name = "students")
@Getter
@Component
@Data
public class Student {

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
    private String specialization;
    @ManyToMany
    @JoinTable(name = "students_teachers",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id"))
    private List<Teacher> teachersList = new ArrayList<>();

    public static class StudentNameComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }
}

