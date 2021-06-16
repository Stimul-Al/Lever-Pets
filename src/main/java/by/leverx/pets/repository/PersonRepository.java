package by.leverx.pets.repository;

import by.leverx.pets.entity.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 *
 * @author aliaksei.babashau
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query(value = "SELECT * FROM persons p WHERE p.email = :email", nativeQuery = true)
    Optional<Person> findByEmail(@Param("email") String email);
}
