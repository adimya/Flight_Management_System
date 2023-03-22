import { Component } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent {
  onLogin(user: { username: string; password: string }) {}
  onSignup(user: { username: string; password: string; fullname: string }) {}
}
