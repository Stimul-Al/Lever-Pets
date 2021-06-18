package by.leverx.pets.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 *
 * @author aliaksei.babashau
 */
@Slf4j
@ControllerAdvice
public class Handler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handle(EntityNotFoundException exception) {
        log.info(exception.getMessage());
        return new ResponseEntity<>(exception.getMessage(), NOT_FOUND);
    }

    @ExceptionHandler(PersonSameException.class)
    public ResponseEntity<Object> handle(PersonSameException exception) {
        log.info(exception.getMessage());
        return new ResponseEntity<>(exception.getMessage(), BAD_REQUEST);
    }

    @ExceptionHandler(AnimalSameException.class)
    public ResponseEntity<Object> handle(AnimalSameException exception) {
        log.info(exception.getMessage());
        return new ResponseEntity<>(exception.getMessage(), BAD_REQUEST);
    }
}
