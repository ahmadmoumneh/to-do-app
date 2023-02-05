/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package am.software.todo.app.service;

import am.software.todo.app.dto.Person;
import java.util.List;

/**
 *
 * @author ahmad
 */
public interface PersonService {
    List<Person> getAllUsers();
    
    Person getUserById(int id);
    
    Person saveUser(Person user);
    
    Person login(String username, String password);
    
    void deleteUserById(int id);
}
