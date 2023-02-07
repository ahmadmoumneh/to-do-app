/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package am.software.todo.app.service;

import am.software.todo.app.dao.CategoryRepository;
import am.software.todo.app.dto.Category;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author ahmad
 */
@Component
public class CategoryServiceImpl implements CategoryService {
    
    @Autowired CategoryRepository categoryDao;

    @Override
    public List<Category> getAllCategories() {
        return categoryDao.findAll();
    }

    @Override
    public Category getCategoryById(int id) throws Exception {
        return categoryDao.findById(id).get();
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryDao.save(category);
    }

    @Override
    public void deleteCategoryById(int id) {
        categoryDao.deleteById(id);
    }

    @Override
    public List<Category> findByNameContaining(String query) {
        return categoryDao.findByNameContaining(query);
    }

    @Override
    public List<Category> findByImageNameNotNull() {
        return categoryDao.findByImageNameNotNull();
    }

    @Override
    public void updateCategoryName(String newName, String oldName) {
        categoryDao.updateName(newName, oldName);
    }
}
