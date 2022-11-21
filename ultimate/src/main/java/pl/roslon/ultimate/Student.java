package pl.roslon.ultimate;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Student {

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

    public Student(String name, String surname, int age, String email, String specialization) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.specialization = specialization;
    }

    List<Teacher> teacherList = new ArrayList<>();


    List<Teacher>addTeacher(Teacher teacher){
        teacherList.add(teacher);
        return teacherList;
    }

    List<Teacher>deleteTeacher(Teacher teacher){
        teacherList.remove(teacher);
        return teacherList;
    }

    List<Teacher>findByNameAndSurname(String name, String surmane){
        teacherList.stream().filter(teacher -> teacher.getName().equals(name) && teacher.getSurname().equals(surmane));
        return teacherList;
    }
}
