import { Component } from '@angular/core';
import { FlightService } from './flights.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers:[FlightService],
})
export class AppComponent {
  title = 'fms-front';
}
