import { Component, Input, OnInit } from '@angular/core';
import { BookingService } from 'src/app/booking.service';
import { UserService } from 'src/app/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent implements OnInit {
  noOfBookings = 7;
  userName = '';
  constructor(
    private bookingService: BookingService,
    private userService: UserService
  ) {}
  ngOnInit() {
    this.noOfBookings = this.bookingService.bookingLength();
    this.userName = this.userService.user.username;
  }
  onLogout() {
    this.userService.clearUser();
    Swal.fire(
      'Logget Out Succesfully',
      'Click the button to Login Page',
      'success'
    );
  }
}
