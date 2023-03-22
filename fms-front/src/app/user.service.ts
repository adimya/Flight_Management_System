import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from './user.model';

@Injectable({ providedIn: 'root' })
export class UserService {
  user: User = {
    username: '',
    password: '',
    fullname: '',
    isAdmin: false,
    bookedId: '',
  };
  constructor() {}

  setUser(userData: User) {
    this.user = userData;
  }
  clearUser() {
    this.user = {
      username: '',
      password: '',
      fullname: '',
      isAdmin: false,
      bookedId: '',
    };
  }
}
