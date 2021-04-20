import { Component, EventEmitter, OnInit, Output } from '@angular/core';

import { Ingredient } from 'src/app/shared/ingredient.model';
import { ShoppingListService } from '../shopping-list.service';

@Component({
	selector: 'app-shopping-edit',
	templateUrl: './shopping-edit.component.html',
	styleUrls: ['./shopping-edit.component.scss']
})
export class ShoppingEditComponent implements OnInit {
	entity: Ingredient = {
		name: null,
		amount: null
	};

	constructor(private slService: ShoppingListService) {}

	ngOnInit(): void {}

	onAdd() {
		const ingredient = new Ingredient(this.entity.name, this.entity.amount);
    this.slService.addIngredient(ingredient);
	}
}
