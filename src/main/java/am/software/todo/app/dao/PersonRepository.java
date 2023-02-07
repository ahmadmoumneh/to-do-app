/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package am.software.todo.app.dao;

import am.software.todo.app.dto.Person;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


/**
 *
 * @author ahmad
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{
    Person findByUsernameAndPassword(String username, String password);
    
    List<Person> findByAvatarNotNull();
    
    @Modifying
    @Transactional
    @Query(
            value = "UPDATE person SET avatar = ?1 WHERE username = ?2",
            nativeQuery = true
    )    
    Integer updateAvatar(String newPersonAvatar, String username);
    
    @Modifying
    @Transactional
    @Query(
            value = "UPDATE person SET password = ?1 WHERE username = ?2",
            nativeQuery = true
    ) 
    Integer changePassword(String newPassword, String username);
}
