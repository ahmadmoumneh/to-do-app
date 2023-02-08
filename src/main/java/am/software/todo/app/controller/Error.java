package am.software.todo.app.controller;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Error {
    private LocalDateTime timestamp = LocalDateTime.now();
    private String message;
}
