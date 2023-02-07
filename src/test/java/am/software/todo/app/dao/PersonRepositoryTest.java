/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package am.software.todo.app.dao;

import am.software.todo.app.dto.Person;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author ahmad
 */
@SpringBootTest
class PersonRepositoryTest {
    @Autowired
    PersonRepository personDao;

    @BeforeEach
    public void setUp() {
        personDao.deleteAll();
        
        Person person = Person.builder()
                .username("Matt")
                .email("matt@gmail.com")
                .password("1234")
                .build();
        
        personDao.save(person);
        
        Person person2 = Person.builder()
                .username("Alice")
                .email("alice@hotmail.com")
                .password("abcd")
                .build();
        
        personDao.save(person2);
        
        Person person3 = Person.builder()
                .username("Mike")
                .email("mike@live.com")
                .password("password")
                .avatar("cool_avatar.jpg")
                .build();
        
        personDao.save(person3);
    }

    @Test
    public void getAllPersons() {
        List<Person> categories = personDao.findAll();
        assertTrue(categories.size() == 3);
    }

    @Test
    public void getPersonByUsernameAndPassword() {
        Person person = personDao.findByUsernameAndPassword("Alice", "abcd");
        assertTrue(person.getUsername().equals("Alice"));
    }

    @Test
    public void getPersonsAvatarNotNull() {
        List<Person> persons = personDao.findByAvatarNotNull();
        assertEquals("Mike", persons.get(0).getUsername());
    }

    @Test
    public void updatePersonAvatar() {
        personDao.updateAvatar("really_cool_avatar.jpg", "Matt");
        Person person = personDao.findByUsernameAndPassword("Matt", "1234");
        assertTrue(person != null);
        assertEquals("really_cool_avatar.jpg", person.getAvatar());
    }
    
    @Test
    public void changePersonPassword() {
        personDao.changePassword("tyui", "Mike");
        Person person = personDao.findByUsernameAndPassword("Mike", "tyui");
        assertTrue(person != null);
        assertEquals("tyui", person.getPassword());
    }
}