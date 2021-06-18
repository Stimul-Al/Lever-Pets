package by.leverx.pets.exception;

import javax.persistence.EntityNotFoundException;

import static java.lang.String.format;

/**
 *
 * @author aliaksei.babashau
 */
public class PersonNotFoundException extends EntityNotFoundException {

    public PersonNotFoundException(Long id) {
        super(format("Person by ID:%s does not found.", id));
    }

    public PersonNotFoundException(String email) {
        super(format("Person by email:%s does not found.", email));
    }

    public PersonNotFoundException(String message, Long animalId) {
        super(message + animalId);
    }
}
