import { Component, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Subscription } from 'rxjs';

import { Ingredient } from 'src/app/shared/ingredient.model';
import { ShoppingListService } from '../shopping-list.service';

@Component({
	selector: 'app-shopping-edit',
	templateUrl: './shopping-edit.component.html',
	styleUrls: ['./shopping-edit.component.scss']
})
export class ShoppingEditComponent implements OnInit, OnDestroy {
	@ViewChild('f') slForm: NgForm;
	subscription: Subscription;

	editMode = false;
	editedItemIndex: number;
	editedItem: Ingredient;

	constructor(private slService: ShoppingListService) {}

	ngOnInit(): void {
		this.subscription = this.slService.startedEditing.subscribe((index: number) => {
			this.editMode = true;
			this.editedItemIndex = index;
			this.editedItem = this.slService.getIngredient(index);
			this.slForm.setValue({
				name: this.editedItem.name,
				amount: this.editedItem.amount
			});
		});
	}

	onSubmit() {
		const value = this.slForm.value;
		const newIngredient = new Ingredient(value.name, value.amount);
		if (this.editMode) {
			this.slService.updateIngredient(this.editedItemIndex, newIngredient);
		} else {
			this.slService.addIngredient(newIngredient);
		}
		this.clearForm();
	}

	clearForm() {
		this.editMode = false;
		this.slForm.reset();
	}

	onDelete() {
		this.slService.deleteIngredient(this.editedItemIndex);
		this.clearForm();
	}

	ngOnDestroy() {
		this.subscription.unsubscribe();
	}
}
