import { Component, Input, OnInit } from '@angular/core';
import { BookingService } from 'src/app/booking.service';
import { UserService } from 'src/app/user.service';

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
}
