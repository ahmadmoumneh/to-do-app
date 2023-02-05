/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package am.software.todo.app.dao;

import am.software.todo.app.dto.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryRepositoryTest {
    @Autowired
    CategoryRepository categoryDao;

    @BeforeEach
    public void setUp() {
        categoryDao.deleteAll();
        
        Category category = Category.builder()
                .name("Work")
                .build();
        
        categoryDao.save(category);
        
        Category category2 = Category.builder()
                .name("School")
                .build();
        
        categoryDao.save(category2);
        
        Category category3 = Category.builder()
                .name("Domestic")
                .imageName("domestic_avatar.jpg")
                .build();
        
        categoryDao.save(category3);
    }

    @Test
    public void getAllCategories() {
        List<Category> categories = categoryDao.findAll();
        assertTrue(categories.size() == 3);
    }

    @Test
    public void getCategoryByName() {
        Category category = categoryDao.findByName("Work");
        assertTrue(category.getName().equals("Work"));
    }
    @Test
    public void getCategoriesContaining() {
        List<Category> categories = categoryDao.findByNameContaining("oo");
        assertEquals("School", categories.get(0).getName());
    }

    @Test
    public void getCategoriesImageNotNull() {
        List<Category> categories = categoryDao.findByImageNameNotNull();
        assertEquals("Domestic", categories.get(0).getName());
    }

    @Test
    public void updateCategoryName() {
        categoryDao.updateName("Job", "Work");
        Category category = categoryDao.findByName("Job");
        assertTrue(category != null);
        assertEquals(category.getName(), "Job");
    }
}