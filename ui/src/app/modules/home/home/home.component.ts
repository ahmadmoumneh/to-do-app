import { Component, OnInit } from '@angular/core';
import { Todo } from 'src/app/classes/Todo';
import { TodoService } from 'src/app/services/todo.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  todos: Todo[];

  constructor(private todoService: TodoService) {}

  ngOnInit() {
    this.todoService.getAllTodos().subscribe(todos => {
      this.todos = todos;
      console.log(todos);
    });
  }

  setDone(todo: Todo, done: boolean) {
    todo.done = done;
    this.todoService.editTodo(todo).subscribe();
  }
}
