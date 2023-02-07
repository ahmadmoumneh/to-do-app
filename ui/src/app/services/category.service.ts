import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Category } from '../classes/Category';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  private serverUrl: string;

  constructor(private http: HttpClient) { 
    this.serverUrl = 'http://localhost:8080/api/todoapp';
  }

  addCategory(category: Category): Observable<Category> {
    return this.http.post<Category>(this.serverUrl + '/addcategory', category);
  }

  getAllCategories(): Observable<Category[]> {
    return this.http.get<Category[]>(this.serverUrl + '/categories');
  }
}
