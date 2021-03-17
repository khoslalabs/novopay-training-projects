import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-servers',
  templateUrl: './servers.component.html',
  // template: `
  //   <app-server></app-server>
  //   <app-server></app-server>
  //   `,
  styleUrls: ['./servers.component.scss']
})
export class ServersComponent implements OnInit {
  allowAddServer: boolean = false;
  serverCreationStatus: string = 'No Server Created';
  // serverName: string = '';
  serverName: string  = 'Test Server';
  serverCreated = false;
  servers = ['Test Server', 'Test Server 2'];


  constructor() { 
    setTimeout(() => {
      this.allowAddServer = true;
    }, 2000)
  }

  ngOnInit(): void {
  }

  onCreateServer(): void {
    // this.serverCreationStatus = "Server Created";
    this.serverCreated = true;
    this.servers.push(this.serverName);
    this.serverCreationStatus = "Server Created! Name is " + this.serverName;
  }

  onUpdateServerName(event: Event): void {
    // console.log(event);
    this.serverName = (<HTMLInputElement>event.target).value;
  }
}
