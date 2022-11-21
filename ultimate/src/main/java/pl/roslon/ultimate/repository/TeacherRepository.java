package pl.roslon.ultimate.repository;

import org.springframework.data.repository.CrudRepository;
import pl.roslon.ultimate.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {
}
