import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from './user.model';
import { map } from 'rxjs/operators';

@Injectable({ providedIn: 'root' })
export class AuthService {
  length = 0;
  constructor(private http: HttpClient) {}

  addNewUser(user: { username: string; password: string; fullname: string }) {
    this.http
      .post('http://localhost:8080/user/new', user, {
        withCredentials: false,
      })
      .subscribe((responseData) => {
        console.log(responseData);
      });
  }

  getAllUser() {
    return this.http
      .get<{ [key: string]: User }>('http://localhost:8080/users')
      .pipe(
        map((responseData) => {
          const userArray: User[] = [];
          for (const key in responseData) {
            if (responseData.hasOwnProperty(key)) {
              userArray.push({ ...responseData[key] });
            }
          }
          this.length = Object.keys(userArray['0']).length;
          var finalUserArray = Object.values(userArray['0']);
          //   console.log(finalUserArray);
          return finalUserArray;
        })
      );
  }

  deleteUser(userdelte: { id: number }) {
    console.log(userdelte.id);
    this.http
      .delete(`http://localhost:8080/userdelete/${userdelte.id}`)
      .subscribe();
  }
}
