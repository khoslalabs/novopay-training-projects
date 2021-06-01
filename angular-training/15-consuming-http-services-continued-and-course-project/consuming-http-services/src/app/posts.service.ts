import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { map } from "rxjs/operators";

import { Post } from "./post.model";

@Injectable()
export class PostsService {

  constructor(private http: HttpClient) {}

  createAndStorePost(title: string, content: string) {
    const postData: Post = { title: title, content: content}; 
    this.http
			.post<{ name: string }>('https://angular-training-25c5d-default-rtdb.firebaseio.com/posts.json', postData)
			.subscribe((responseData) => {
				console.log(responseData);
			});
  }

  fetchPosts() {
    return this.http
			.get<{ [key: string]: Post }>('https://angular-training-25c5d-default-rtdb.firebaseio.com/posts.json', {
        headers: new HttpHeaders({ 'Custom-Header': 'Hello' })
      })
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
			);
  }

  clearPosts() {
    return this.http.delete('https://angular-training-25c5d-default-rtdb.firebaseio.com/posts.json');
  }
}