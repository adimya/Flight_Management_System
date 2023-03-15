import { Component ,Input} from '@angular/core';
import { Flight } from 'src/app/flight.model';

@Component({
  selector: 'app-flight-item',
  templateUrl: './flight-item.component.html',
  styleUrls: ['./flight-item.component.css']
})
export class FlightItemComponent {
  
  @Input() flight: Flight=
    {
      fromLoc:"",
     toLoc:"",
     title:"",
    isFull:false,
    seats:0,
    description:"",
    companyName:"",
    takeOffTime:"",
    landingTime:"",
  ticketPrice:0};
  @Input() idd: number=0;
  @Input() searchT:string='';
}
