import { Component, OnInit } from '@angular/core';

import { DataService } from "./data.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
  providers: [DataService]

})
export class AppComponent implements OnInit {
  accounts = [];

  constructor(private dataService: DataService) {}

  ngOnInit() {
    this.accounts = this.dataService.getAccounts();
    this.dataService.accountStatusChanged.subscribe((status: string) => {
      alert('New Status: ' + status);
    })
  }

  // onAccountAdded(newAccount: {name: string, status: string}) {
  //   this.accounts.push(newAccount);
  // }

  // onStatusChanged(updateInfo: {id: number, newStatus: string}) {
  //   this.accounts[updateInfo.id].status = updateInfo.newStatus;
  // }
}
