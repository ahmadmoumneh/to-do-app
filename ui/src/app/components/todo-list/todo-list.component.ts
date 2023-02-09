import { CommonModule } from '@angular/common';
import { Component, Input, OnInit } from '@angular/core';
import { Category } from 'src/app/classes/Category';
import { Todo } from 'src/app/classes/Todo';
import { TodoService } from 'src/app/services/todo.service';

@Component({
  standalone: true,
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.css'],
  imports: [CommonModule]
})
export class TodoListComponent implements OnInit {

  todos: Todo[];
  @Input() category: Category;

  constructor(
    private todoService: TodoService
  ){}

  ngOnInit() {
    this.displayTodos();
  }

  displayTodos() {
    console.log('display todos')
    this.todoService.getTodosByCategory(this.category.id).subscribe(todos => {
      this.todos = todos;
    });
  }

  setDone(todo: Todo, done: boolean) {
    todo.done = done;
    this.todoService.editTodo(todo).subscribe();
  }
}
