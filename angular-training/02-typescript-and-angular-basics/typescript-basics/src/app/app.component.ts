import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'typescript-basics';
}

/**
 * --------------------- TYPESCRIPT BASICS -----------------------------
 */


/** ---- Declaring Valiables and assigning types ---- */

let myString: string;
let myNumber: number;
let myBoolean: boolean;
let myVar: any;

// myString = 'String';
myString = 'Shashank'+ ' '+ 'Raj';
// myNumber = 11;
// myNumber = 1.1;
myNumber = 0xf00d;
myBoolean = false;
myVar = 'any';

let myString2: string = 'String 2';

let strArr: string[];
let numArr: number[];
let boolArr: boolean[];
let tuple: [string, number];


strArr = ['String 1', 'String 2'];
numArr = [1,2];
boolArr = [true, false];
tuple = ['String', 1];

let myVoid: void = null;
let myNull: null = undefined;
let myUndefined: undefined = undefined;

// console.log(myString, myNumber, myBoolean, myVar);
// console.log(tuple);


/** --------------- Functions ----------------------*/

// function getSum(num1, num2) {
//   return num1+num2;
// }

function getSum(num1: number, num2: number): number {
  return num1+num2;
}

function getName(fName: string, lName?: string): string {
  if(!lName) return fName;
  return fName + ' ' + lName;
}

// function getSum(num1: any, num2: any): any {
//   return num1+num2;
// }

function funcBoolean(): boolean {
  return true;
}

function myVoidFunc(): void {
  return;
}
 
let myFun = () => {
  return true;
}

// console.log(getSum(1,2));
// console.log(getName('Shashank', 'Raj'));
// console.log(funcBoolean());
// console.log(myVoidFunc());
// console.log(myFun());


/** --------------- Classes ----------------------*/

class User {

  private name: string;
  protected email: string;
  public age: number;

  constructor(name: string, email: string, age: number) {
    this.name = name;
    this.email = email;
    this.age = age;
    console.log('User Created: '+' ' +this.name);
  }

  public registerUser() {
    return this.name + ' is now registered!';
  }

}

let shashank = new User('Shashank', 'shashank@gmail.com', 23);
console.log(shashank.registerUser());
console.log(shashank.age);








