package pl.roslon.ultimate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import pl.roslon.ultimate.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
