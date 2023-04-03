import { Component, Input, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { AuthService } from 'src/app/auth.service';
import { Flight } from 'src/app/flight.model';
import { FlightService } from 'src/app/flights.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-flight-item',
  templateUrl: './flight-item.component.html',
  styleUrls: ['./flight-item.component.css'],
})
export class FlightItemComponent implements OnInit {
  route: boolean = false;
  updateIsTrue: boolean = false;
  constructor(
    private router: Router,
    private authService: AuthService,
    private flightService: FlightService
  ) {}

  ngOnInit(): void {
    this.route = false;
    if (this.router.url === '/admin') {
      this.route = true;
    }
    console.log(this.route);
  }

  @Input() flight: Flight = {
    fromLoc: '',
    toLoc: '',
    title: '',
    isFull: false,
    seats: 0,
    description: '',
    companyName: '',
    takeOffTime: '',
    landingTime: '',
    ticketPrice: 0,
  };
  @Input() idd: number = 0;
  @Input() searchT: string = '';

  goToUpdate() {
    this.updateIsTrue = !this.updateIsTrue;
  }
  DeleteFlight(flightd: { id: number }) {
    console.log(flightd.id);
    this.flightService.deleteFlight(flightd);
    Swal.fire(
      'Flight Deleted',
      'Click on All Flights to see the upadated list!',
      'success'
    );
  }
}
