import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Time } from '@angular/common';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  constructor(private http: HttpClient) {}

  ngOnInit() {}

  onAddFlight(flightData: { id:BigInteger,
	fromLoc :string,
	toLoc: string,
	title:string,
	isFull:boolean,
	seats:number,
	description:string,
	companyName:string,
	takeOffTime:Time,
	landingTime:Time,
	ticketPrice:number }){
  console.log(flightData);
  
    this.http
      .post(
        'http://localhost:8080/flight/new',
        flightData,{withCredentials:false}
      )
      .subscribe(responseData => {
        console.log(responseData);
      });
  }
}
