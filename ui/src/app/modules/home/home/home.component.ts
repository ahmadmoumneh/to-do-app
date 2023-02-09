import { Component, OnInit } from '@angular/core';
import { Category } from 'src/app/classes/Category';
import { CategoryService } from 'src/app/services/category.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  categories: Category[];

  constructor(
    private categoryService: CategoryService
  ) {}

  ngOnInit() {
    this.updateTodos();
  }

  updateTodos() {
    this.categoryService.getAllCategories().subscribe(categories => {
      this.categories = categories;
    });
  }
}
