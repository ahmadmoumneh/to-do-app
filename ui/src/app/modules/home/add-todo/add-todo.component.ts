import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Category } from 'src/app/classes/Category';
import { Todo } from 'src/app/classes/Todo';
import { User } from 'src/app/classes/User';
import { CategoryService } from 'src/app/services/category.service';
import { TodoService } from 'src/app/services/todo.service';

@Component({
  selector: 'app-add-todo',
  templateUrl: './add-todo.component.html',
  styleUrls: ['./add-todo.component.css']
})
export class AddTodoComponent implements OnInit{
  
  currentTodo: Todo;
  categories: Category[];
  @Output() todoAdded = new EventEmitter<any>();

  constructor(
    private todoService: TodoService,
    private categoryService: CategoryService
  ){}

  ngOnInit() {
    this.currentTodo = new Todo();

    this.currentTodo.user = new User();
    this.currentTodo.user.id = 1;
    this.currentTodo.user.username = 'matt';
    this.currentTodo.user.email = 'matt@gmail.com';
    this.currentTodo.user.password = '1234';
    this.currentTodo.user.avatar = 'avatar.jpg';

   

    this.categoryService.getAllCategories().subscribe(categories => {
      this.categories = categories;
      this.setCategory('Chores');
    });
  }

  setCategory(name: string) {
    this.currentTodo.category = this.categories.find(category => category.name === name);
  }

  addTodo() {
    this.todoService.addTodo(this.currentTodo).subscribe();
    this.todoAdded.emit();
  }
}
