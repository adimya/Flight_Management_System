import { Component, Input, OnInit } from '@angular/core';
import { BookingService } from 'src/app/booking.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent implements OnInit {
  noOfBookings = 7;
  constructor(private bookingService: BookingService) {}
  ngOnInit() {
    this.noOfBookings = this.bookingService.bookingLength();
  }
}
