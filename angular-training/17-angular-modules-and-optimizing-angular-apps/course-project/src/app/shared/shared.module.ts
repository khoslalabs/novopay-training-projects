import { NgModule } from "@angular/core";

import { LoadingSpinnerComponent } from "../shared/loading-spinner/loading-spinner.component";
import { DropdownDirective } from '../shared/dropdown.directive';

@NgModule({
  declarations: [
    DropdownDirective,
    LoadingSpinnerComponent
  ],
  exports: [
    DropdownDirective,
    LoadingSpinnerComponent
  ]
})
export class SharedModule {}