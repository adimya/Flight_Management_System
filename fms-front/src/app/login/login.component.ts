import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { User } from '../user.model';
import { UserService } from '../user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  users: User[] = [];
  // isUser: string = '';

  constructor(
    private authService: AuthService,
    private router: Router,
    private userService: UserService
  ) {}

  ngOnInit(): void {
    this.authService.getAllUser().subscribe((resData) => {
      this.users = resData;
    });
  }
  onLogin(user: { username: string; password: string }) {
    for (let index = 0; index < this.users.length; index++) {
      const element = this.users[index];
      if (
        element.username === user.username &&
        element.password === user.password
      ) {
        this.userService.setUser(element);
        this.router.navigate(['home']);
        // this.isUser = 'home';
        if (element.isAdmin === true) {
          this.router.navigate(['admin']);
        }
      }
    }
  }

  onSignup(user: { username: string; password: string; fullname: string }) {
    this.authService.addNewUser(user);
  }
}
