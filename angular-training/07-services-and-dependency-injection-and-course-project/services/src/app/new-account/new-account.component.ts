import { Component} from '@angular/core';

import { DataService } from '../data.service';
import { LoggingService } from '../logging.service';

@Component({
  selector: 'app-new-account',
  templateUrl: './new-account.component.html',
  styleUrls: ['./new-account.component.scss'],
  // providers: [LoggingService]
})
export class NewAccountComponent {
  // @Output() accountAdded = new EventEmitter<{name: string, status: string}>();

  constructor(private loggingService: LoggingService, private dataService: DataService) {}

  onCreateAccount(accountName: string, accountStatus: string) {
    // this.accountAdded.emit({
    //   name: accountName,
    //   status: accountStatus
    // });
    const acctInfo = {
      name: accountName,
      status: accountStatus
    }
    this.dataService.addAccount(acctInfo);
    // console.log('A server status changed, new status: ' + accountStatus);
    // this.loggingService.logAccountStatus(accountStatus);
  }
}
