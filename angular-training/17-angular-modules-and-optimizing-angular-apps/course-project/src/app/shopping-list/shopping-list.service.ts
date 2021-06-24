import { Subject } from 'rxjs';

import { Ingredient } from '../shared/ingredient.model';

export class ShoppingListService {
	onIngredientsChanged = new Subject<Ingredient[]>();
	startedEditing = new Subject<number>();

	private ingredients: Ingredient[] = [
    new Ingredient('Eggs', 5),
    new Ingredient('Tomatoes', 3)
  ];

	getIngredients() {
		return this.ingredients.slice();
	}

	getIngredient(index: number) {
		return this.ingredients[index];
	}

	addIngredient(ingredient: Ingredient) {
		this.ingredients.push(ingredient);
		this.ingredientsChanged();
	}

	addIngredients(ingredients: Ingredient[]) {
		// for (let ingredient of ingredients) {
		//   this.addIngredient(ingredient);
		// }
		this.ingredients.push(...ingredients);
		this.ingredientsChanged();
	}

	updateIngredient(index: number, newIngredient: Ingredient) {
		this.ingredients[index] = newIngredient;
		this.ingredientsChanged();
	}

	deleteIngredient(index: number) {
		this.ingredients.splice(index, 1);
		this.ingredientsChanged();
	}

	ingredientsChanged() {
		this.onIngredientsChanged.next(this.ingredients.slice());
	}
}
