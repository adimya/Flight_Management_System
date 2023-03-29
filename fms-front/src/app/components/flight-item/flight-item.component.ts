import { Component, Input, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { Flight } from 'src/app/flight.model';

@Component({
  selector: 'app-flight-item',
  templateUrl: './flight-item.component.html',
  styleUrls: ['./flight-item.component.css'],
})
export class FlightItemComponent implements OnInit {
  route: boolean = false;
  constructor(private router: Router) {}

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
}
