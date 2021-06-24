import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';
import { catchError, tap } from 'rxjs/operators';
import { BehaviorSubject, throwError } from 'rxjs';
import { environment } from '../../environments/environment';

import { User } from './user.model';

export interface AuthResponseData {
	kind: string;
	idToken: string;
	email: string;
	refreshToken: string;
	expiresIn: string;
	localId: string;
	registered?: string;
}

@Injectable()
export class AuthService {
	user = new BehaviorSubject<User>(null);

	constructor(private http: HttpClient, private router: Router) {}

	signup(email: string, password: string) {
		return this.http
			.post<AuthResponseData>(
				'https://identitytoolkit.googleapis.com/v1/accounts:signUp?key=' + environment.firebaseApiKey,
				{
					email: email,
					password: password,
					returnSecureToken: true
				}
			)
			.pipe(
				catchError(this.handleError),
				tap((resData) => {
					this.handleAuthentication(resData.email, resData.localId, resData.idToken);
				})
			);
	}

	login(email: string, password: string) {
		return this.http
			.post<AuthResponseData>(
				'https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=' + environment.firebaseApiKey,
				{
					email: email,
					password: password,
					returnSecureToken: true
				}
			)
			.pipe(
				catchError(this.handleError),
				tap((resData) => {
					this.handleAuthentication(resData.email, resData.localId, resData.idToken);
				})
			);
	}

	logout() {
		this.user.next(null);
		this.router.navigate(['/auth']);
	}

	private handleError(errorResponse: HttpErrorResponse) {
		let errorMessage = 'An unknown error occured!';
		if (!errorResponse.error || !errorResponse.error.error) {
			return throwError(errorMessage);
		}
		switch (errorResponse.error.error.message) {
			case 'EMAIL_EXISTS':
				errorMessage = 'This email already exists!';
				break;
			case 'EMAIL_NOT_FOUND':
				errorMessage = 'This email doest not exist.';
				break;
			case 'INVALID_PASSWORD':
				errorMessage = 'This password is not correct.';
				break;
		}
		return throwError(errorMessage);
	}

	private handleAuthentication(email: string, userId: string, token: string) {
		const user = new User(email, userId, token);
		this.user.next(user);
	}
}
