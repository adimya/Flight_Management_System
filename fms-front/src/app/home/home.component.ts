import { Component,OnInit } from '@angular/core';
import { Flight } from '../flight.model';
import { FlightService } from '../flights.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  
  
})
export class HomeComponent implements OnInit{
  searchText:string='';
  flights:Flight[]=[];
  constructor(private flightService:FlightService){}
 ngOnInit(){
  this.flightService.getFlights().subscribe(flight=>{

    this.flights=flight;
    
  })
 }
}
