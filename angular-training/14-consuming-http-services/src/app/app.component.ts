import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';

import { Post } from './post.model';

@Component({
	selector: 'app-root',
	templateUrl: './app.component.html',
	styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
	loadedPosts = [];
	isFetching: boolean = false;

	constructor(private http: HttpClient) {}

	ngOnInit() {
		this.fetchPosts();
	}

	onCreatePost(postData: Post) {
		// Send Http request
		this.http
			.post<{ name: string }>('https://angular-training-25c5d-default-rtdb.firebaseio.com/posts.json', postData)
			.subscribe((responseData) => {
				console.log(responseData);
			});
		// console.log(postData);
	}

	onFetchPosts() {
		// Send Http request
		this.fetchPosts();
	}

	onClearPosts() {
		// Send Http request
	}

	private fetchPosts() {
		this.isFetching = true;
		this.http
			.get<{ [key: string]: Post }>('https://angular-training-25c5d-default-rtdb.firebaseio.com/posts.json')
			.pipe(
				map((responseData) => {
					let postsArray: Post[] = [];
					for (const key in responseData) {
						if (responseData.hasOwnProperty(key)) {
							postsArray.push({ ...responseData[key], id: key });
						}
					}
					return postsArray;
				})
			)
			.subscribe((posts) => {
				this.isFetching = false;
				this.loadedPosts = posts;
			});
	}
}
