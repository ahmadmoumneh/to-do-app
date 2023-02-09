/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package am.software.todo.app.controller;

import am.software.todo.app.dto.Category;
import am.software.todo.app.dto.ToDo;
import am.software.todo.app.service.ToDoService;
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
@RequestMapping("/api/todoapp")
public class TodoController {
    
    @Autowired 
    private ToDoService todoService;
    
    @GetMapping("/todos")
    public List<ToDo> getAllTodos() {
        return this.todoService.getAllTodos();
    }
    
    @PostMapping("/addtodo")
    @ResponseStatus(HttpStatus.CREATED)
    public ToDo addTodo(@RequestBody ToDo toDo) {
        return this.todoService.saveToDo(toDo);
    }
    
    @PutMapping("/edittodo")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ToDo editTodo(@RequestBody ToDo toDo) {
        return this.todoService.saveToDo(toDo);
    }
    
    @DeleteMapping("/deletetodo/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTodo(@PathVariable int id) {
        this.todoService.deleteToDoById(id);
    }
    
    @GetMapping("/todo/{id}")
    public ToDo getTodo(@PathVariable int id) throws Exception {       
        return this.todoService.getToDoById(id);
    }
    
    @GetMapping("/searchtodo/name")
    public List<ToDo> searchTodo(@RequestParam String query) throws Exception {       
        return this.todoService.findByNameContaining(query);
    }
    
    @GetMapping("/searchtodo/category/{id}")
    public List<ToDo> searchTodo(@PathVariable int id) throws Exception {       
        return this.todoService.findByCategoryId(id);
    }
    
    @GetMapping("/searchtodo/notdone")
    public List<ToDo> searchTodo() throws Exception {       
        return this.todoService.findByIsDoneFalse();
    }
}
