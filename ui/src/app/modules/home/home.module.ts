import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from '../home/home/home.component';
import { TodoListComponent } from 'src/app/components/todo-list/todo-list.component';
import { AddTodoComponent } from './add-todo/add-todo.component';
import { FormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    HomeComponent,
    AddTodoComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    TodoListComponent
  ],
  exports: [
    HomeComponent
  ]
})
export class HomeModule { }
