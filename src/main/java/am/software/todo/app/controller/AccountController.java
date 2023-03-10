/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package am.software.todo.app.controller;

import am.software.todo.app.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import am.software.todo.app.service.UserService;

/**
 *
 * @author ahmad
 */
@ControllerAdvice
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/todoapp/account")
public class AccountController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/login")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User login(@RequestParam String username, 
            @RequestParam String password) {
       
        return userService.login(username, password);
    }
}