package am.software.todo.app.dao;

import am.software.todo.app.dto.Category;
import am.software.todo.app.dto.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author: NickeeCoco
 */
@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Integer> {
    List<ToDo> findToDosContaining(String query);

    List<ToDo> findTodosByCategory(Category category);

    List<ToDo> findToDosByIsDoneFalse();
}
