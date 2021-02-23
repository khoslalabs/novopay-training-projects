import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html'
})
export class HeaderComponent {
  @Output() recipeSelected = new EventEmitter<string>();

  onRecipeSelected(feature: string){
    this.recipeSelected.emit(feature);
  }
}