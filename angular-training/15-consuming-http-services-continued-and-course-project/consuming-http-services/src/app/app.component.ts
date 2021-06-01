import { Component, OnInit } from '@angular/core';

import { Post } from './post.model';
import { PostsService } from './posts.service';

@Component({
	selector: 'app-root',
	templateUrl: './app.component.html',
	styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
	loadedPosts = [];
	isFetching: boolean = false;
  error = null;

	constructor(private postsService: PostsService) {}

	ngOnInit() {
		this.fetchPosts();
	}

	onCreatePost(postData: Post) {
		// Send Http request
		this.postsService.createAndStorePost(postData.title, postData.content);
		// console.log(postData);
	}

	onFetchPosts() {
		// Send Http request
		this.fetchPosts();
	}

	onClearPosts() {
		// Send Http request
    this.postsService.clearPosts().subscribe(() => {
      this.loadedPosts = [];
    })
	}

	private fetchPosts() {
		this.isFetching = true;
		this.postsService.fetchPosts()
			.subscribe((posts) => {
				this.isFetching = false;
				this.loadedPosts = posts;
			}, error => {
        this.isFetching = false;
        this.error = error.message;
        console.log(error);
      });
	}

  onHandleError() {
    this.error = null;
  }
}
