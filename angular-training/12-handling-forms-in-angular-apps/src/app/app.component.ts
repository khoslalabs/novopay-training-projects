import { Component, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  @ViewChild('f') signupForm;

  genders = ['male', 'female'];
  defaultQuestion = "pet";
  answer = '';
  submitted = false;

  user = {
    username: '',
    mail: '',
    secretQuestion: '',
    answer: '',
    gender: ''
  }

  suggestUserName() {
    const suggestedName = 'Superuser';
    // this.signupForm.setValue({
    //   userData: {
    //     username: suggestedName,
    //     email: ''
    //   },
    //   secret: 'pet',
    //   questionAnswer: '',
    //   gender: 'male'
    // });
    this.signupForm.form.patchValue({
      userData: {
        username: suggestedName
      }
    });
  }

  // onSubmit(form: NgForm): void {
  //   console.log(form);
  // }

  onSubmit(): void {
    // console.log(this.signupForm);
    this.submitted = true;
    this.user.username = this.signupForm.value.userData.username;
    this.user.mail = this.signupForm.value.userData.email;
    this.user.secretQuestion = this.signupForm.value.secret;
    this.user.answer = this.signupForm.value.questionAnswer;
    this.user.gender = this.signupForm.value.gender;

    this.signupForm.reset();
  }
}
