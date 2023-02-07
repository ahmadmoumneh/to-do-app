/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package am.software.todo.app.dao;

import am.software.todo.app.dto.User;
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
public interface UserRepository extends JpaRepository<User, Integer>{
    User findByUsernameAndPassword(String username, String password);
    
    List<User> findByAvatarNotNull();
    
    @Modifying
    @Transactional
    @Query(
            value = "UPDATE user SET avatar = ?1 WHERE username = ?2",
            nativeQuery = true
    )    
    Integer updateAvatar(String newUserAvatar, String username);
    
    @Modifying
    @Transactional
    @Query(
            value = "UPDATE user SET password = ?1 WHERE username = ?2",
            nativeQuery = true
    ) 
    Integer changePassword(String newPassword, String username);
}
