import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth/auth.service';

import { DataStorageService } from '../shared/data-storage.service';

@Component({
	selector: 'app-header',
	templateUrl: './header.component.html',
	styles: [
		`
    .dropdown-menu {
      left: unset;
      right: 0px;
    }
  `
	]
})
export class HeaderComponent implements OnInit {
	isAuthenticated = false;

	constructor(private dataStorageService: DataStorageService, private authService: AuthService) {}

	ngOnInit() {
		this.authService.user.subscribe((user) => {
			// this.isAuthenticated = !user ? false : true;
			this.isAuthenticated = !!user;
		});
	}

	onLogout() {
		this.authService.logout();
	}

	onSaveData() {
		this.dataStorageService.storeRecipes();
	}

	onFetchData() {
		this.dataStorageService.fetchRecipes().subscribe();
	}
}
