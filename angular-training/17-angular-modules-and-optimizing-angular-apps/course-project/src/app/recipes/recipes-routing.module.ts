import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";

import { RecipesComponent } from '../recipes/recipes.component';
import { RecipeDetailComponent } from '../recipes/recipe-detail/recipe-detail.component';
import { RecipeStartComponent } from '../recipes/recipe-start/recipe-start.component';
import { RecipeEditComponent } from '../recipes/recipe-edit/recipe-edit.component';
import { AuthGaurd } from '../auth/auth.gaurd';

const routes: Routes = [
	{
		path: '',
		component: RecipesComponent,
		canActivate: [AuthGaurd],
		children: [
			{ path: '', component: RecipeStartComponent },
			{ path: 'new', component: RecipeEditComponent },
			{ path: ':id', component: RecipeDetailComponent },
			{ path: ':id/edit', component: RecipeEditComponent }
		]
	}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})

export class RecipesRoutingModule {}