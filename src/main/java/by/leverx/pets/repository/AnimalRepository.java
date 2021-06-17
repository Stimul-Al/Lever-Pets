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

    @Query(value = "UPDATE animals a SET person_id = :ownerSecondAnimal WHERE a.id = :firstAnimal;" +
                    "UPDATE animals a SET person_id = :ownerFirstAnimal WHERE a.id = :secondAnimal; ", nativeQuery = true)
    void dealTwoAnimals(@Param("firstAnimal") Long firstAnimal,
                        @Param("ownerFirstAnimal") Long ownerFirstAnimal,
                        @Param("secondAnimal") Long secondAnimal,
                        @Param("ownerSecondAnimal") Long ownerSecondAnimal);
}
