package pl.roslon.ultimate;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Getter
@Entity
public class Teacher {

    @Id
    private long id;
    @Size(min = 10)
    private String name;
    private String surname;
    @Min(value = 18)
    private int age;
    @Email(message = "Email should be valid")
    private String email;
    private String subject;

    public Teacher(String name, String surname, int age, String email, String subject) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.subject = subject;
    }

    List<Student> studentList = new ArrayList<>();

    public List<Student> addStudent(Student student) {
        studentList.add(student);
        return studentList;
    }

}
