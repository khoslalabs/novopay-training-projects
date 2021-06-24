import { Component, OnInit } from '@angular/core';

import { Ingredient } from '../shared/ingredient.model';
import { ShoppingListService } from './shopping-list.service';

@Component({
	selector: 'app-shopping-list',
	templateUrl: './shopping-list.component.html',
	styleUrls: ['./shopping-list.component.scss']
})
export class ShoppingListComponent implements OnInit {
	ingredients: Ingredient[] = [];

	constructor(private slService: ShoppingListService) {}

	ngOnInit(): void {
		this.ingredients = this.slService.getIngredients();
    this.slService.onIngredientsChanged.subscribe((ingredients: Ingredient[]) => {
      this.ingredients = ingredients;
    })
	}

  onEditItem(index: number): void {
    this.slService.startedEditing.next(index);
  }
}
