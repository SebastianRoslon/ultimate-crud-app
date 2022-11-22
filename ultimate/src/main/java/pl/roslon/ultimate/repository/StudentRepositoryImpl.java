package pl.roslon.ultimate.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.roslon.ultimate.Student;

import java.util.List;

@Repository
public interface StudentRepositoryImpl extends StudentRepository {

    @Override
     default List<Student> findByStudentNameAsc() {
        return entityManager.createQuery("SELECT s FROM Student s ORDER BY s.name", Student.class).getResultList();
    }

    @Query("SELECT s from Student s WHERE s.name=:name")
    Page<Student> findByStudent(@Param("name") String name, Pageable pageReq);

    @Override
    public default Page<Student> findByStudent(Student student, Pageable pageReq) {
        return findByStudent(student.getName(), pageReq);
    }




}
