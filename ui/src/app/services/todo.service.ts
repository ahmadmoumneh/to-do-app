import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Todo } from '../classes/Todo';
import { HttpClient } from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class TodoService {
  private serverUrl: string;

  constructor(private http: HttpClient) { 
    this.serverUrl = 'http://localhost:8080/api/todoapp';
  }

  addTodo(todo: Todo): Observable<Todo> {
    return this.http.post<Todo>(this.serverUrl + '/addtodo', todo);
  }

  editTodo(todo: Todo): Observable<Todo> {
    return this.http.put<Todo>(this.serverUrl + '/edittodo', todo);
  }

  getAllTodos(): Observable<Todo[]> {
    return this.http.get<Todo[]>(this.serverUrl + '/todos');
  }
}
