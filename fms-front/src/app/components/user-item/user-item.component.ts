import { Component, Input } from '@angular/core';
import { AuthService } from 'src/app/auth.service';
import { User } from 'src/app/user.model';
import Swal from 'sweetalert2';

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

  constructor(private authService: AuthService) {}
  DeleteUser(userd: { id: number }) {
    console.log(userd.id);
    this.authService.deleteUser(userd);

    Swal.fire(
      'User Data Updated',
      'Click on All User to see the upadated list!',
      'success'
    );
  }
}
