import { EventEmitter } from "@angular/core";

import { Ingredient } from "../shared/ingredient.model";

export class ShoppingListService {
  onIngredientsChanged = new EventEmitter<Ingredient[]>();

  private ingredients: Ingredient[] = [
    new Ingredient('Eggs', 5),
    new Ingredient('Tomatoes', 3)
  ];

  getIngredients() {
    return this.ingredients.slice();
  }

  addIngredient(ingredient: Ingredient) {
    this.ingredients.push(ingredient);
    this.onIngredientsChanged.emit(this.ingredients.slice());
  }

  addIngredients(ingredients: Ingredient[]) {
    // for (let ingredient of ingredients) {
    //   this.addIngredient(ingredient);
    // }
    this.ingredients.push(...ingredients);
    this.onIngredientsChanged.emit(this.ingredients.slice());
  }
}