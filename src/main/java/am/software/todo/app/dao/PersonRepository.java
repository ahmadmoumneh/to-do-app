/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package am.software.todo.app.dao;

import am.software.todo.app.dto.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 *
 * @author ahmad
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{
    Person findByUsernameAndPassword(String username, String password);
}
