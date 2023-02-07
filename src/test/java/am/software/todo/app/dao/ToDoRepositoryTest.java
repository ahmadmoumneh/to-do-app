package am.software.todo.app.dao;

import am.software.todo.app.dto.Category;
import am.software.todo.app.dto.Person;
import am.software.todo.app.dto.ToDo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ToDoRepositoryTest {
    @Autowired
    ToDoRepository toDoDao;

    @Autowired
    CategoryRepository categoryDao;

    @Autowired
    PersonRepository userDao;

    @BeforeEach
    public void init() {
        toDoDao.deleteAll();
        categoryDao.deleteAll();
        userDao.deleteAll();

        Category category = Category.builder()
                .id(1)
                .name("Work")
                .build();

        categoryDao.save(category);

        Category category2 = Category.builder()
                .name("Chores")
                .build();

        categoryDao.save(category2);

        Person user = Person.builder()
                .username("Nickee Coco")
                .email("nickeecoco@whatever.ca")
                .password("password")
                .build();

        userDao.save(user);
    }

    @Test
    public void getAllTodos() {
        Category category = categoryDao.findByName("Chores");
        Person user = userDao.findByUsernameAndPassword("Nickee Coco", "password");

        ToDo toDo = ToDo.builder()
                .name("ToDo 1 Name")
                .description("ToDo 1 Description")
                .category(category)
                .user(user)
                .build();

        toDoDao.save(toDo);

        ToDo toDo2 = ToDo.builder()
                .name("ToDo 2 Name")
                .description("ToDo 2 Description")
                .category(category)
                .user(user)
                .build();

        toDoDao.save(toDo2);

        List<ToDo> toDos = toDoDao.findAll();
        assertTrue(toDos.size() == 2);
    }

    @Test
    public void getToDosByNameContaining() {
        Category category = categoryDao.findByName("Chores");
        Person user = userDao.findByUsernameAndPassword("Nickee Coco", "password");

        ToDo toDo = ToDo.builder()
                .name("ToDo 1 Name")
                .description("ToDo 1 Description")
                .category(category)
                .user(user)
                .build();

        toDoDao.save(toDo);

        ToDo toDo2 = ToDo.builder()
                .name("ToDo 2 Name")
                .description("ToDo 2 Description")
                .category(category)
                .user(user)
                .build();

        toDoDao.save(toDo2);

        List<ToDo> todos = toDoDao.findByNameContaining("todo");
        assertEquals("ToDo 1 Name", todos.get(0).getName());
        assertTrue(todos.size() == 2);

        List<ToDo> todos2 = toDoDao.findByNameContaining("2");
        assertEquals("ToDo 2 Name", todos2.get(0).getName());
        assertTrue(todos2.size() == 1);
    }

    @Test
    public void getToDosByCategory() {
        Category chores = categoryDao.findByName("Chores");
        Category work = categoryDao.findByName("Work");

        Person user = userDao.findByUsernameAndPassword("Nickee Coco", "password");

        ToDo toDo = ToDo.builder()
                .name("Chores ToDo")
                .description("Chores ToDo Description")
                .category(chores)
                .user(user)
                .build();

        toDoDao.save(toDo);

        ToDo toDo2 = ToDo.builder()
                .name("Work ToDo 1")
                .description("Work ToDo 1 Description")
                .category(work)
                .user(user)
                .build();

        toDoDao.save(toDo2);

        ToDo toDo3 = ToDo.builder()
                .name("Work ToDo 2")
                .description("Work ToDo 2 Description")
                .category(work)
                .user(user)
                .build();

        toDoDao.save(toDo3);

        List<ToDo> workToDos = toDoDao.findByCategory(work);
        List<ToDo> choresToDos = toDoDao.findByCategory(chores);

        assertEquals("Work ToDo 1", workToDos.get(0).getName());
        assertTrue(workToDos.size() == 2);

        assertEquals("Chores ToDo", choresToDos.get(0).getName());
        assertTrue(choresToDos.size() == 1);


    }

    @Test
    public void getNotDoneTodos() {
        Category chores = categoryDao.findByName("Chores");
        Category work = categoryDao.findByName("Work");

        Person user = userDao.findByUsernameAndPassword("Nickee Coco", "password");

        ToDo toDo = ToDo.builder()
                .name("Chores ToDo")
                .description("Chores ToDo Description")
                .category(chores)
                .user(user)
                .build();

        toDoDao.save(toDo);

        ToDo toDo2 = ToDo.builder()
                .name("Work ToDo 1")
                .description("Work ToDo 1 Description")
                .category(work)
                .user(user)
                .build();

        toDoDao.save(toDo2);

        ToDo toDo3 = ToDo.builder()
                .name("Work ToDo 2")
                .description("Work ToDo 2 Description")
                .category(work)
                .user(user)
                .build();

        toDoDao.save(toDo3);

        List<ToDo> todos = toDoDao.findByIsDoneFalse();
        assertEquals("Chores ToDo", todos.get(0).getName());
        assertTrue(todos.size() == 3);

        toDo2.setDone(true);

        toDoDao.save(toDo2);

        List<ToDo> todos2 = toDoDao.findByIsDoneFalse();
        System.out.println(todos2);
        assertTrue(todos2.size() == 2);
    }
}
