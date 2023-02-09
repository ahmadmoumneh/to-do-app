import { Component, OnInit } from '@angular/core';
import { Category } from 'src/app/classes/Category';
import { Todo } from 'src/app/classes/Todo';
import { CategoryService } from 'src/app/services/category.service';
import { TodoService } from 'src/app/services/todo.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  todos: Todo[];
  categories: Category[];

  constructor(
    private todoService: TodoService,
    private categoryService: CategoryService
    ) {}

  ngOnInit() {
    this.todoService.getAllTodos().subscribe(todos => {
      this.todos = todos;
    });

    this.categoryService.getAllCategories().subscribe(categories => {
      this.categories = categories;
    });
  }

  setDone(todo: Todo, done: boolean) {
    todo.done = done;
    this.todoService.editTodo(todo).subscribe();
  }
}
