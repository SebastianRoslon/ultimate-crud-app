package pl.roslon.ultimate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.roslon.ultimate.entity.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {




//   public Page<Student> findByStudentNameAsc();
//    Page<Student> findByStudent(Student student, Pageable pageReq);
}
