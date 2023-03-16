import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import { map } from 'rxjs/operators';
import { Booking } from './booking.model';
import { Flight } from './flight.model';
import { FlightService } from './flights.service';
@Injectable({ providedIn: 'root' })
export class BookingService implements OnInit {
  ngOnInit(): void {}
  constructor(private http: HttpClient, private flightService: FlightService) {}
  getBooking() {
    return this.http
      .get<{ [key: string]: Booking }>('http://localhost:8080/bookings')
      .pipe(
        map((responseData) => {
          const bookArray: Booking[] = [];
          for (const key in responseData) {
            if (responseData.hasOwnProperty(key)) {
              bookArray.push({ ...responseData[key] });
            }
          }

          var finalbookArray = Object.values(bookArray['0']);
          console.log(finalbookArray);
          return finalbookArray;
        })
      );
  }

  deleteBooking(flight: Flight) {
    this.http
      .delete(`http://localhost:8080/bookdelete/${flight.id}`)
      .subscribe((resdata) => {
        console.log(resdata);
      });
    this.flightService.deletesSeats({
      id: flight.id,
      fromLoc: flight.fromLoc,
      toLoc: flight.toLoc,
      title: flight.title,
      isFull: flight.isFull,
      seats: flight.seats + 1,
      description: flight.description,
      companyName: flight.companyName,
      takeOffTime: flight.takeOffTime,
      landingTime: flight.landingTime,
      ticketPrice: flight.ticketPrice,
    });
  }
  addBooking(booking: { id: number }) {
    console.log(booking);
    this.http
      .post(
        'http://localhost:8080/booking/add',
        { id: booking.id },
        {
          withCredentials: false,
        }
      )
      .subscribe((responseData) => {
        console.log(responseData);
      });
  }
}
