/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package am.software.todo.app.controller;

import am.software.todo.app.dto.Category;
import am.software.todo.app.service.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ahmad
 */
@ControllerAdvice
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/todoapp/category")
public class CategoryController {
    @Autowired 
    private CategoryService categoryService;
    
    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return this.categoryService.getAllCategories();
    }
    
    @PostMapping("/addCategory")
    @ResponseStatus(HttpStatus.CREATED)
    public Category addCategory(@RequestBody Category category) {
        return this.categoryService.saveCategory(category);
    }
    
    @PutMapping("/editcategory/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Category editCategory(Category category) {
        return this.categoryService.saveCategory(category);
    }
    
    @DeleteMapping("/deletecategory/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable int id) {
        this.categoryService.deleteCategoryById(id);
    }
    
    @GetMapping("/category/{id}")
    public Category getCategory(@PathVariable int id) throws Exception {       
        return this.categoryService.getCategoryById(id);
    }
    
    @GetMapping("/searchcategory/name")
    public List<Category> searchCategory(@RequestParam String query) throws Exception {       
        return this.categoryService.findByNameContaining(query);
    }
}
