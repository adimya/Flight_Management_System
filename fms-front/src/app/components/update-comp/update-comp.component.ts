import { Component, Input } from '@angular/core';
import { Flight } from 'src/app/flight.model';
import { FlightService } from 'src/app/flights.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-update-comp',
  templateUrl: './update-comp.component.html',
  styleUrls: ['./update-comp.component.css'],
})
export class UpdateCompComponent {
  constructor(private flightService: FlightService) {}
  @Input() flight: Flight = {
    fromLoc: 'fgafsef',
    toLoc: 'fdaf',
    title: '',
    isFull: false,
    seats: 0,
    description: '',
    companyName: '',
    takeOffTime: '',
    landingTime: '',
    ticketPrice: 0,
  };
  onUpdateFlight(flightData: Flight) {
    this.flightService.updateFlight(flightData);
    Swal.fire(
      'Flight Data Updated',
      'Click on All Flights to see the upadated list!',
      'success'
    );
  }
}
