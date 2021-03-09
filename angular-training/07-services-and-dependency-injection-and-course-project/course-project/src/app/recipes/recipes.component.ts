import { Component, OnInit } from '@angular/core';

import { Recipe } from './recipe.model';
import { RecipeService } from './recipe.service';

@Component({
	selector: 'app-recipes',
	templateUrl: './recipes.component.html',
	styleUrls: ['./recipes.component.scss'],
	providers: [RecipeService]
})
export class RecipesComponent implements OnInit {
	selectedRecipeItem: Recipe;

	constructor(private recipeService: RecipeService) {}

	ngOnInit(): void {
		this.recipeService.onRecipeSelected.subscribe((recipe: Recipe) => {
			this.selectedRecipeItem = recipe;
		});
	}
}
