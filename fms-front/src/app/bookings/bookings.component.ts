import { Component, OnInit } from '@angular/core';
import { Booking } from '../booking.model';
import { BookingService } from '../booking.service';
import { Flight } from '../flight.model';
import { FlightService } from '../flights.service';

@Component({
  selector: 'app-bookings',
  templateUrl: './bookings.component.html',
  styleUrls: ['./bookings.component.css'],
})
export class BookingsComponent implements OnInit {
  flights: Flight[] = [];
  booking: Booking[] = [];
  bookLength = 0;

  constructor(
    private flightService: FlightService,
    private bookingService: BookingService
  ) {}
  ngOnInit() {
    this.flightService.getFlights().subscribe((flight) => {
      this.flights = flight;
      console.log(this.flights);
      this.bookingService.getBooking().subscribe((booking) => {
        this.booking = booking;
        let new_array: Flight[] = [];
        for (let i = 0; i < this.flights.length; i++) {
          for (let j = 0; j < this.booking.length; j++) {
            if (this.flights[i].id === this.booking[j].id) {
              new_array.push(this.flights[i]);
            }
          }
        }
        this.flights = new_array;
      });
    });
  }
  deleteBooking(flight: Flight) {
    this.bookingService.deleteBooking(flight);
    this.ngOnInit();
  }
}
