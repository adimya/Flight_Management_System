import { Component,OnInit } from '@angular/core';
import { FlightService } from '../flights.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  
  
})
export class HomeComponent implements OnInit{
  searchText:string='';
  flights:{id:number,name:string,whereTo:string,
  price:number,
  seats:number}[]=[];
  constructor(private flightService:FlightService){}
 ngOnInit(): void {
   this.flights=this.flightService.flights;
 }
}
