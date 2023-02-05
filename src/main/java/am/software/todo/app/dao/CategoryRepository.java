/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package am.software.todo.app.dao;

import am.software.todo.app.dto.Category;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findByName(String categoryName);
    
    List<Category> findByNameContaining(String categoryName);
    
    List<Category> findByImageNameNotNull();
    
    @Modifying
    @Transactional
    @Query(
            value = "UPDATE category SET name = ?1 WHERE name = ?2",
            nativeQuery = true
    )
            
    Integer updateName(String newCategoryName, String oldCategoryName);
}
