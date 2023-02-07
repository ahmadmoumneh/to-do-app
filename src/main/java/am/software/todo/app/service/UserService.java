/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package am.software.todo.app.service;

import am.software.todo.app.dto.User;
import java.util.List;

/**
 *
 * @author ahmad
 */
public interface UserService {
    List<User> getAllUsers();
    
    User getUserById(int id);
    
    User saveUser(User user);
    
    User login(String username, String password);
    
    void deleteUserById(int id);
}
