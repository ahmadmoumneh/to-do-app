/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package am.software.todo.app.service;

import am.software.todo.app.dto.Category;
import java.util.List;

/**
 *
 * @author ahmad
 */
public interface CategoryService {
    List<Category> getAllCategories();

    Category getCategoryById(int id) throws Exception;

    Category saveCategory(Category category);

    void deleteCategoryById(int id);

    List<Category> findByNameContaining(String query);

    List<Category> findByImageNameNotNull();
    
    void updateCategoryName(String newName, String oldName);
}
