import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ServiceService } from '../service.service';
import { FlightbookingDetails } from 'src/flightbooking-details';
import { Flight } from 'src/flight';

@Component({
  selector: 'app-flight',
  templateUrl: './flight.component.html',
  styleUrls: ['./flight.component.css']
})
export class FlightComponent implements OnInit {

  constructor(private http:HttpClient, private service:ServiceService) { }
  userr:FlightbookingDetails=new FlightbookingDetails()
  searchu:Flight=new Flight();
  testv:any;
  user:any;
  sourceref:any;
  destiref:any;
  departeref:any;
  arrivalref:any;
fnameref:any;
nameref:any;

  public show:boolean = false;
  public buttonName:any = 'Show';
  disp:boolean=true;
pusk:boolean=false;
bpass:boolean=false
  ngOnInit(): void {
  }
  test(){
    this.userr.source=this.sourceref;
    this.userr.destination=this.destiref;
    this.userr.departure=this.departeref;
    this.userr.arrival=this.arrivalref;
    this.userr.flight_name=this.fnameref;
    this.userr.name=this.nameref;
  }
  
  flightbooking(){    //submit fn
    this.test();
    this.service.flightbooking(this.userr).subscribe(data=>{console.log(data)});
    this.pusk=false;
this.disp=false;
this.show=false;
this.bpass=true
  }
  
search(event:any){
  console.log("user in ts",this.searchu);
 this.service.searchflight(this.searchu).subscribe(den=>{this.testv=den
   console.log(den);
  console.log(this.testv[0].source, this.testv[0].destination)
  this.sourceref=this.testv[0].source;
  this.destiref=this.testv[0].destination;
  this.departeref=this.testv[0].departure;
  this.arrivalref=this.testv[0].arrival;
  this.fnameref=this.testv[0].flight_name;
  this.nameref=this 


  console.log("source"+this.sourceref)
  console.log("desti"+this.destiref)
  console.log("dep"+this.departeref)
  console.log("arr"+this.arrivalref)

  this.pusk=true;
  this.disp=false;
  
 });
}
ShowFlight(){
  let responce= this.http.get("http://localhost:1010/flights");
  responce.subscribe((data)=>this.user=data)
  console.log(this.user)
  
 }
 toggle() {
this.pusk=false;
this.disp=false;
this.show=true;
  // Change the name of the button.
  if(this.show)  
    this.buttonName = "Hide";
  else
    this.buttonName = "Show";
}
}
