package by.leverx.pets.repository;

import by.leverx.pets.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author aliaksei.babashau
 */
public interface AnimalRepository extends JpaRepository<Animal, Long> {

    @Query(value = "UPDATE persons_animals p_a " +
                        "SET p_a.person_id = :ownerAnimal " +
                        "WHERE p_a.animal_id = :animal",
                    nativeQuery = true)
    void dealTwoAnimals(@Param("ownerAnimal") Long ownerAnimal,
                        @Param("animal") Long animal);

}
