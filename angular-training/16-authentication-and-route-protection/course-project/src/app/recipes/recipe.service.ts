import { Injectable } from "@angular/core";
import { Subject } from "rxjs";             

import { Recipe } from "./recipe.model";
import { Ingredient } from "../shared/ingredient.model";
import { ShoppingListService } from "../shopping-list/shopping-list.service";

@Injectable()
export class RecipeService {
  recipesChanged = new Subject<Recipe[]>();

  // private recipes: Recipe[] = [
  //   new Recipe(
  //     'Big Fat Burger', 
  //     'What else you need to say?', 
  //     'https://pngfile.net/public/uploads/preview/chicken-berger-png-free-download-215661406829qhqo1rasn.png',
  //     [
  //       new Ingredient('Bun', 2),
  //       new Ingredient('Meat', 1)
  //     ]
  //   ),
  //   new Recipe(
  //     'Tasty Fries', 
  //     'Super-tasty fries with red sauce!', 
  //     'https://www.lordofthefries.co.nz/wp-content/uploads/2016/02/fries_classic_logo.png',
  //     [
  //       new Ingredient('Potato', 10),
  //       new Ingredient('Tomato', 5)
  //     ]
  //   )
  // ];

  private recipes: Recipe[] = [];

  constructor(private slService: ShoppingListService) {}

  setRecipes(recipes: Recipe[]) {
    this.recipes = recipes;
    this.recipesChanged.next(this.recipes.slice());
  }

  getRecipes() {
    return this.recipes.slice();
  }

  getRecipe(index: number) {
    return this.recipes[index];
  }

  addIngredientsToShoppingList(ingredients: Ingredient[]) {
    this.slService.addIngredients(ingredients);
  }

  addRecipe(recipe: Recipe) {
    this.recipes.push(recipe);
    this.recipesChanged.next(this.recipes.slice());
  }

  updateRecipe(index: number, newRecipe: Recipe) {
    this.recipes[index] = newRecipe;
    this.recipesChanged.next(this.recipes.slice());
  }

  deleteRecipe(index: number) {
    this.recipes.splice(index, 1);
    this.recipesChanged.next(this.recipes.slice());
  }
}