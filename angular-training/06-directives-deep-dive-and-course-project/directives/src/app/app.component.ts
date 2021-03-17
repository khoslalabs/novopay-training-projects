import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  onlyOdd: boolean = false;
  oddNumbers: number[] = [1,3,5];
  evenNumbers: number[] = [2,4];
}
