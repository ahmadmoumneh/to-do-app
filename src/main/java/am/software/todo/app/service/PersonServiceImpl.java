/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package am.software.todo.app.service;

import am.software.todo.app.dto.Person;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import am.software.todo.app.dao.PersonRepository;
import org.springframework.stereotype.Component;

/**
 *
 * @author ahmad
 */
@Component
public class PersonServiceImpl implements PersonService {
    
    @Autowired PersonRepository personRepository;

    @Override
    public List<Person> getAllUsers() {
        return personRepository.findAll();
    }

    @Override
    public Person getUserById(int id) {
        return personRepository.findById(id).get();
    }

    @Override
    public Person saveUser(Person user) {
        return personRepository.save(user);
    }

    @Override
    public void deleteUserById(int id) {
        personRepository.deleteById(id);
    }
    
    @Override
    public Person login(String username, String password) {
        return personRepository.findByUsernameAndPassword(username, password);
    }
}
