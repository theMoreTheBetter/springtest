package aa.Dao;

import aa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<Student, Long> {

    Student findByName(String name);

    Student findByNameAndAge(String name, Integer age);

    @Query("from Student u where u.name=:name")
    Student findUser(@Param("name") String name);

}
