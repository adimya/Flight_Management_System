import { Component,Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FlightService } from 'src/app/flights.service';

@Component({
  selector: 'app-flight-details',
  templateUrl: './flight-details.component.html',
  styleUrls: ['./flight-details.component.css']
})
export class FlightDetailsComponent implements OnInit{
  flightId: number=0;
  flights:{id:number,name:string,whereTo:string,
    price:number,
    seats:number}[]=[];
    constructor(private flightService:FlightService,private route:ActivatedRoute){}
   ngOnInit(): void {
     this.flights=this.flightService.flights;
     this.flightId=this.route.snapshot.params['id']-1;
   }
   bookingConfirm():void{
    this.flights[this.flightId].seats--;
    console.log(this.flights[this.flightId].seats);
   }
  
}
