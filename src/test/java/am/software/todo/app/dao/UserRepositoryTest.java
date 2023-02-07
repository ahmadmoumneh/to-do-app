/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package am.software.todo.app.dao;

import am.software.todo.app.dto.User;
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
class UserRepositoryTest {
    @Autowired
    UserRepository userDao;

    @BeforeEach
    public void setUp() {
        userDao.deleteAll();
        
        User user = User.builder()
                .username("Matt")
                .email("matt@gmail.com")
                .password("1234")
                .build();
        
        userDao.save(user);
        
        User user2 = User.builder()
                .username("Alice")
                .email("alice@hotmail.com")
                .password("abcd")
                .build();
        
        userDao.save(user2);
        
        User user3 = User.builder()
                .username("Mike")
                .email("mike@live.com")
                .password("password")
                .avatar("cool_avatar.jpg")
                .build();
        
        userDao.save(user3);
    }

    @Test
    public void getAllUsers() {
        List<User> categories = userDao.findAll();
        assertTrue(categories.size() == 3);
    }

    @Test
    public void getUserByUsernameAndPassword() {
        User user = userDao.findByUsernameAndPassword("Alice", "abcd");
        assertTrue(user.getUsername().equals("Alice"));
    }

    @Test
    public void getUsersAvatarNotNull() {
        List<User> users = userDao.findByAvatarNotNull();
        assertEquals("Mike", users.get(0).getUsername());
    }

    @Test
    public void updateUserAvatar() {
        userDao.updateAvatar("really_cool_avatar.jpg", "Matt");
        User user = userDao.findByUsernameAndPassword("Matt", "1234");
        assertTrue(user != null);
        assertEquals("really_cool_avatar.jpg", user.getAvatar());
    }
    
    @Test
    public void changeUserPassword() {
        userDao.changePassword("tyui", "Mike");
        User user = userDao.findByUsernameAndPassword("Mike", "tyui");
        assertTrue(user != null);
        assertEquals("tyui", user.getPassword());
    }
}