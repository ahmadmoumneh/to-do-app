package am.software.todo.app.service;

import am.software.todo.app.dto.Category;
import am.software.todo.app.dto.ToDo;

import java.util.List;

public interface ToDoService {
    List<ToDo> getAllTodos();

    ToDo getToDoById(int id) throws Exception;

    ToDo saveToDo(ToDo toDo);

    void deleteToDoById(int id);

    //@ToDo: correct method name?
    List<ToDo> findByNameContaining(String query);

    List<ToDo> findByCategoryId(int categoryId);

    List<ToDo> findByIsDoneFalse();
}
