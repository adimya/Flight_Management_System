import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BookingService } from 'src/app/booking.service';
import { Flight } from 'src/app/flight.model';
import { FlightService } from 'src/app/flights.service';

@Component({
  selector: 'app-flight-details',
  templateUrl: './flight-details.component.html',
  styleUrls: ['./flight-details.component.css'],
})
export class FlightDetailsComponent implements OnInit {
  flightId: number = 0;
  flights: Flight[] = [];
  constructor(
    private flightService: FlightService,
    private route: ActivatedRoute,
    private bookingService: BookingService
  ) {}

  ngOnInit() {
    this.fetchData();
  }
  fetchData() {
    this.flightService.getFlights().subscribe((flight) => {
      this.flightId = this.route.snapshot.params['id'];

      this.flights = flight.filter((x) => x.id == this.flightId);
      console.log(this.flights);
    });
  }
  deleteSeats() {
    this.bookingService.addBooking({ id: this.flightId });
    this.flightService.deletesSeats({
      id: this.flightId,
      fromLoc: this.flights[0].fromLoc,
      toLoc: this.flights[0].toLoc,
      title: this.flights[0].title,
      isFull: this.flights[0].isFull,
      seats: this.flights[0].seats - 1,
      description: this.flights[0].description,
      companyName: this.flights[0].companyName,
      takeOffTime: this.flights[0].takeOffTime,
      landingTime: this.flights[0].landingTime,
      ticketPrice: this.flights[0].ticketPrice,
    });
    console.log(this.flights[0].seats - 1);
    console.log(this.flights[0].id);
  }
}
