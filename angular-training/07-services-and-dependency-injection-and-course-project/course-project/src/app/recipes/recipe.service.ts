import { EventEmitter } from "@angular/core";

import { Recipe } from "./recipe.model";

export class RecipeService {
  onRecipeSelected = new EventEmitter<Recipe>();

  private recipes: Recipe[] = [
    new Recipe('A Test Recipe', 'This is simply a test', 'https://images.pexels.com/photos/1410236/pexels-photo-1410236.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940'),
    new Recipe('Another Test Recipe', 'This is simply a test', 'https://images.pexels.com/photos/3026808/pexels-photo-3026808.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500')
  ];

  getRecipes() {
    return this.recipes.slice();
  }

  recipeSelected(recipe: Recipe) {
    this.onRecipeSelected.emit(recipe);
  }
}