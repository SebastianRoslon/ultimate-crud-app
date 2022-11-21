package pl.roslon.ultimate.repository;

import org.springframework.data.repository.CrudRepository;
import pl.roslon.ultimate.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
