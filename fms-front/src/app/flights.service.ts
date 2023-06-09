import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { Flight } from './flight.model';
@Injectable({ providedIn: 'root' })
export class FlightService {
  constructor(private http: HttpClient) {}
  getFlights() {
    return this.http
      .get<{ [key: string]: Flight }>('http://localhost:8080/flights')
      .pipe(
        map((responseData) => {
          const flightArray: Flight[] = [];
          for (const key in responseData) {
            if (responseData.hasOwnProperty(key)) {
              flightArray.push({ ...responseData[key] });
            }
          }
          var finalFlightArray = Object.values(flightArray['0']);
          return finalFlightArray;
        })
      );
  }

  deletesSeats(flightData: Flight) {
    this.http.put('http://localhost:8080/update', flightData).subscribe();
  }

  deleteFlight(flightdelte: { id: number }) {
    console.log(flightdelte.id);
    this.http
      .delete(`http://localhost:8080/delete/${flightdelte.id}`)
      .subscribe();
  }
  updateFlight(flightData: Flight) {
    this.http.put('http://localhost:8080/update', flightData).subscribe();
  }
}
