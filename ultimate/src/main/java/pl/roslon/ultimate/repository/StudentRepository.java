package pl.roslon.ultimate.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.roslon.ultimate.Student;


@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {




//   public Page<Student> findByStudentNameAsc();
//    Page<Student> findByStudent(Student student, Pageable pageReq);
}
