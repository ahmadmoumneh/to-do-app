package am.software.todo.app.dao;

import am.software.todo.app.dto.Category;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDao extends JpaRepository<Category, Integer> {
    public Category findByName(String categoryName);
    public List<Category> findByNameContaining(String categoryName);
    public List<Category> findByImageNameNotNull();
    @Modifying
    @Transactional//ideally, this transactional annotation should be on the service layer
    @Query(
            value = "UPDATE category SET name = ?1 WHERE name = ?2",
            nativeQuery = true
    )
    public Integer updateName(String newCategoryName, String oldCategoryName);
}
