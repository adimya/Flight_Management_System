import { Component ,Input} from '@angular/core';

@Component({
  selector: 'app-flight-item',
  templateUrl: './flight-item.component.html',
  styleUrls: ['./flight-item.component.css']
})
export class FlightItemComponent {
  
  @Input() flight: {
    id:number,
    name:string,whereTo:string,
    price:number,
    seats:number}=
    {id:0,
    name:'flight 0',
    whereTo:'lucknow',
    price:2000,
    seats:30};
  @Input() idd: number=0;
  @Input() searchT:string='';
}
