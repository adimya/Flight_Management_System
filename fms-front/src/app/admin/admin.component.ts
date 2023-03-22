import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Time } from '@angular/common';
import { FlightService } from '../flights.service';
import { Flight } from '../flight.model';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css'],
})
export class AdminComponent implements OnInit {
  flights: Flight[] = [];
  isFetched: boolean = false;
  constructor(private http: HttpClient, private flightService: FlightService) {}

  ngOnInit() {}

  onAddFlight(flightData: {
    id: BigInteger;
    fromLoc: string;
    toLoc: string;
    title: string;
    isFull: boolean;
    seats: number;
    description: string;
    companyName: string;
    takeOffTime: Time;
    landingTime: Time;
    ticketPrice: number;
  }) {
    console.log(flightData);

    this.http
      .post('http://localhost:8080/flight/new', flightData, {
        withCredentials: false,
      })
      .subscribe((responseData) => {
        console.log(responseData);
      });
  }
  onDeleteFlight(flightd: { id: number }) {
    console.log(flightd.id);
    this.flightService.deleteFlight(flightd);
  }
  getAllFlights() {
    this.flightService.getFlights().subscribe((flight) => {
      this.flights = flight;
      this.isFetched = true;
    });
  }
  onUpdateFlight(flightData: Flight) {
    this.flightService.updateFlight(flightData);
  }
  clearAllFlights() {
    this.flights = [];
    this.isFetched = false;
  }
}
