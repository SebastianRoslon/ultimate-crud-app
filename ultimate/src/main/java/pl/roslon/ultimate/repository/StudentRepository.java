package pl.roslon.ultimate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.roslon.ultimate.entity.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
