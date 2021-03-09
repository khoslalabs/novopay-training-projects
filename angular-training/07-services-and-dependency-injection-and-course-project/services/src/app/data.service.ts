import { EventEmitter, Injectable } from "@angular/core";

import { LoggingService } from "./logging.service";

@Injectable()
export class DataService {
  accountStatusChanged = new EventEmitter<string>();
  accounts = [
    {
      name: 'Master Account',
      status: 'active'
    },
    {
      name: 'Test Account',
      status: 'inactive'
    }
  ];

  constructor(private loggingService: LoggingService) {}

  getAccounts() {
    return this.accounts;
  }

  addAccount(accountInfo: {name: string, status: string}) {
    this.accounts.push(accountInfo);
    this.loggingService.logAccountStatus(accountInfo.status);
  }

  updateAccountStatus(updateInfo: {id: number, newStatus: string}) {
    this.accounts[updateInfo.id].status = updateInfo.newStatus;
    this.loggingService.logAccountStatus(updateInfo.newStatus);
  }
}