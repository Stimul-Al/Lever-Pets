package by.leverx.pets.exception.exception;

import javax.persistence.EntityNotFoundException;

import static java.lang.String.format;

/**
 *
 * @author aliaksei.babashau
 */
public class AnimalNotFoundException extends EntityNotFoundException {

    public AnimalNotFoundException(Long id) {
        super(format("Animal by ID:%s not found", id));
    }
}
