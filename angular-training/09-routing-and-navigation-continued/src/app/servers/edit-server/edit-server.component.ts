import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';

import { ServersService } from '../servers.service';

@Component({
	selector: 'app-edit-server',
	templateUrl: './edit-server.component.html'
})
export class EditServerComponent implements OnInit {
	server: { id: number; name: string; status: string };
	serverName = '';
	serverStatus = '';
  allowEdit: boolean = false;

	constructor(private serversService: ServersService, private route: ActivatedRoute) {}

	ngOnInit() {
    // console.log(this.route.snapshot.queryParams);
    // console.log(this.route.snapshot.fragment);
    // this.route.queryParams.subscribe();
    // this.route.fragment.subscribe();

    this.route.queryParams.subscribe((queryParams: Params) => {
      this.allowEdit = queryParams['allowEdit'] === '1' ? true : false;
    });
    
    const id = +this.route.snapshot.params['id'];
    this.server = this.serversService.getServer(id);
		this.serverName = this.server.name;
		this.serverStatus = this.server.status;
	}

	onUpdateServer() {
		this.serversService.updateServer(this.server.id, { name: this.serverName, status: this.serverStatus });
	}
}
