package by.leverx.pets.repository;

import by.leverx.pets.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author aliaksei.babashau
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query(value = "SELECT * FROM persons p WHERE p.email = :email", nativeQuery = true)
    Optional<Person> findByEmail(@Param("email") String email);

    @Query(value = "SELECT * FROM persons p JOIN persons_animals p_a ON p.id = p_a.person_id \n" +
            "    JOIN animals a on a.id = p_a.animal_id " +
            "WHERE a.id = :animalId", nativeQuery = true)
    List<Person> findByAnimalId(@Param("animalId") Long animalId);
}
