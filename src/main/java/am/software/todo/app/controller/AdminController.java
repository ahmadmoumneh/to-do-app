/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package am.software.todo.app.controller;

import am.software.todo.app.dto.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/api/todoapp/admin")
public class AdminController {
    @Autowired 
    private UserService userService;
    
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }
    
    @PostMapping("/adduser")
    @ResponseStatus(HttpStatus.CREATED)
    public User addUser(@RequestBody User user) {
        return this.userService.saveUser(user);
    }
    
    @PutMapping("/edituser")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User editUser(@RequestBody User user) {
        return this.userService.saveUser(user);
    }
    
    @DeleteMapping("/deleteuser/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable int id) {
        this.userService.deleteUserById(id);
    }
    
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable int id) {       
        return this.userService.getUserById(id);
    }
}
