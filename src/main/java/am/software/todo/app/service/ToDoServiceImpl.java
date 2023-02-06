package am.software.todo.app.service;

import am.software.todo.app.dao.ToDoRepository;
import am.software.todo.app.dto.Category;
import am.software.todo.app.dto.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoServiceImpl implements ToDoService {

    @Autowired
    ToDoRepository toDoRepository;

    @Override
    public List<ToDo> getAllTodos() {
        return toDoRepository.findAll();
    }

    @Override
    public ToDo getToDoById(int id) throws Exception {
        return toDoRepository.findById(id)
                .orElseThrow(() -> new Exception("Create a custom exception here."));
    }

    @Override
    public ToDo saveToDo(ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    @Override
    public void deleteToDoById(int id) {
        toDoRepository.deleteById(id);
    }

    @Override
    public List<ToDo> findByNameContaining(String query) {
        return toDoRepository.findByNameContaining(query);
    }

    @Override
    public List<ToDo> findByCategory(Category category) {
        return toDoRepository.findByCategory(category);
    }

    @Override
    public List<ToDo> findByIsDoneFalse() {
        return toDoRepository.findByIsDoneFalse();
    }
}
