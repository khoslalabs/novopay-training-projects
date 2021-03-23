import { Component, OnInit } from '@angular/core';

@Component({
	selector: 'app-user',
	templateUrl: './user.component.html'
})
export class UserComponent implements OnInit {
	user: { id: number; name: string };

	constructor() {}

	ngOnInit() {}
}
