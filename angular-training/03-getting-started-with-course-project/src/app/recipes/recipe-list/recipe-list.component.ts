import { Component, OnInit } from '@angular/core';

import { Recipe } from '../recipe.model';

@Component({
  selector: 'app-recipe-list',
  templateUrl: './recipe-list.component.html',
  styleUrls: ['./recipe-list.component.scss']
})
export class RecipeListComponent implements OnInit {
  recipes: Recipe[] = [
    new Recipe('A Test Recipe', 'This is simply a test', 'https://images.pexels.com/photos/1410236/pexels-photo-1410236.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940'),
    new Recipe('A Test Recipe', 'This is simply a test', 'https://images.pexels.com/photos/1410236/pexels-photo-1410236.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940')
  ];

  constructor() { }

  ngOnInit(): void {
  }

}
