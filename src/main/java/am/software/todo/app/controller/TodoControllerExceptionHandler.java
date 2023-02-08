package am.software.todo.app.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice
@RestController
class TodoControllerExceptionHandler {
    private static final String DATA_INTEGRITY_VIOLATION_MESSAGE = "Could not process your request. "
            + "Some required data is missing.";
    private static final String CONSTRAINT_MESSAGE = "Could not process your request. "
            + "A data constraint was not satisfied.";
    private static final String NOT_FOUND_MESSAGE = "Could not process your request. "
            + "The information was not found in our database.";


    @ExceptionHandler(DataIntegrityViolationException.class)
    public final ResponseEntity<Error> handleSqlException(
            DataIntegrityViolationException ex,
            WebRequest request) {

        Error err = new Error();
        err.setMessage(DATA_INTEGRITY_VIOLATION_MESSAGE);
        return new ResponseEntity<>(err, HttpStatus.UNPROCESSABLE_ENTITY);
    }
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public final ResponseEntity<Error> handleSqlException(
            SQLIntegrityConstraintViolationException ex,
            WebRequest request) {

        Error err = new Error();
        err.setMessage(CONSTRAINT_MESSAGE);
        return new ResponseEntity<>(err, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public final ResponseEntity<Error> handleOtherSqlException(
            EmptyResultDataAccessException ex,
            WebRequest request) {

        Error err = new Error();
        err.setMessage(NOT_FOUND_MESSAGE);
        return new ResponseEntity<>(err, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}