/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package am.software.todo.app.controller;

import am.software.todo.app.service.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User addedUser = this.userService.saveUser(user);
        
        if (addedUser == null)
            return new ResponseEntity(null, HttpStatus.UNAUTHORIZED);
        
        return ResponseEntity.ok(addedUser);
    }
    
    @PutMapping("/edituser/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<User> editUser(User user) {
        boolean editedUser = this.userService.saveUser(user);
        
        if (!editedUser)
            return new ResponseEntity(null,HttpStatus.UNAUTHORIZED);
        
        return ResponseEntity.ok(user);
    }
    
    @DeleteMapping("/deleteuser/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable int id) {
        this.userService.deleteUserById(id);
    }
    
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id) {
        User user = this.userService.getUserById(id);
        
        Optional<ResponseEntity> response = 
                Optional.of(ResponseEntity.ok(user));
       
        return response.orElse(new ResponseEntity(null, HttpStatus.NOT_FOUND));
    }
}
