import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styles: [`
    .dropdown-menu {
      left: unset;
      right: 0px;
    }
  `]
})
export class HeaderComponent {
  @Output() featureSelected = new EventEmitter<string>();

  onFeatureSelected(feature: string) {
    this.featureSelected.emit(feature);
  }
}