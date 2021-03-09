import { Component, Input } from '@angular/core';

import { LoggingService } from "../logging.service";
import { DataService } from '../data.service';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.scss'],
  // providers: [LoggingService]
})
export class AccountComponent {
  @Input() account: {name: string, status: string};
  @Input() id: number;
  // @Output() statusChanged = new EventEmitter<{id: number, newStatus: string}>();

  constructor(private loggingService: LoggingService, private dataService: DataService) {}

  onSetTo(status: string) {
    // this.statusChanged.emit({id: this.id, newStatus: status});
    const updateInfo = {id: this.id, newStatus: status};
    this.dataService.updateAccountStatus(updateInfo);
    // console.log('A server status changed, new status: ' + status);
    // this.loggingService.logAccountStatus(status);
    this.dataService.accountStatusChanged.emit(status);
  }
}
