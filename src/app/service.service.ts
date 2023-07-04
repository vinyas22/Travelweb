import { Injectable } from '@angular/core';
import { Bus } from 'src/bus';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Train } from 'src/train';
import { Hotel } from 'src/hotel';
import { Flight } from 'src/flight';
import { TrainbookingDetails } from 'src/trainbooking-details';
import { HotelbookingDetails } from 'src/hotelbooking-details';
import { FlightbookingDetails } from 'src/flightbooking-details';
import { BusbookingDetails } from 'src/busbooking-details';
@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http:HttpClient) { }

  searchflight(fli:Flight)
  {
    //console.log(user.name+" - "+user.email);
    return this.http.post<Flight>("http://localhost:1010/searchflight",fli)
   }

searchbus(fli:Bus)
  {
    //console.log(user.name+" - "+user.email);
    return this.http.post<Bus>("http://localhost:1010/searchbus",fli)
   }
searchhotel(fli:Hotel)
  {
    //console.log(user.name+" - "+user.email);
    return this.http.post<Hotel>("http://localhost:1010/searchhotel",fli)
   }
searchtrain(fli:Train)
  {
    //console.log(user.name+" - "+user.email);
    return this.http.post<Train>("http://localhost:1010/search",fli)
   }


trainbooking(user:TrainbookingDetails){
  return this.http.post<TrainbookingDetails>("http://localhost:1010/posttrainbooking",user);
}
hotelbooking(user:HotelbookingDetails){
  return this.http.post<HotelbookingDetails>("http://localhost:1010/postHotelbooking",user);
}
flightbooking(user:FlightbookingDetails){
  return this.http.post<FlightbookingDetails>("http://localhost:1010/postFlightbooking",user);
}
busbooking(user:BusbookingDetails){
  return this.http.post<BusbookingDetails>("http://localhost:1010/postBusbooking",user);
}
}
