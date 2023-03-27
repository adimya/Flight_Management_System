import { Component, Input } from '@angular/core';
import { User } from 'src/app/user.model';

@Component({
  selector: 'app-user-item',
  templateUrl: './user-item.component.html',
  styleUrls: ['./user-item.component.css'],
})
export class UserItemComponent {
  @Input() user: User = {
    id: 0,
    username: '',
    fullname: '',
    password: '',
    isAdmin: false,
    bookedId: '',
  };
}
