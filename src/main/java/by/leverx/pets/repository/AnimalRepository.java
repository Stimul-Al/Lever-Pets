package by.leverx.pets.repository;

import by.leverx.pets.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author aliaksei.babashau
 */
public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
