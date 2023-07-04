import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ServiceService } from '../service.service';
import { HotelbookingDetails } from 'src/hotelbooking-details';
import { Hotel } from 'src/hotel';

@Component({
  selector: 'app-hotel',
  templateUrl: './hotel.component.html',
  styleUrls: ['./hotel.component.css']
})
export class HotelComponent implements OnInit {


  constructor(private http:HttpClient, private service:ServiceService) { }
  userr:HotelbookingDetails=new HotelbookingDetails()
  searchu:Hotel=new Hotel();
  testv:any;
  user:any;
  sourceref:any;
  destiref:any;
  departeref:any;
  arrivalref:any;
fnameref:any;


  public show:boolean = false;
  public buttonName:any = 'Show';
  disp:boolean=true;
pusk:boolean=false;
bpass:boolean=false
  ngOnInit(): void {
  }

  test(){
   
    this.userr.hotel_name=this.fnameref;
  }
  
  hotelbooking(){    //submit fn
    this.test();
    this.service.hotelbooking(this.userr).subscribe(data=>{console.log(data)});
    this.pusk=false;
this.disp=false;
this.show=false;
this.bpass=true
  }
  
search(event:any){
  console.log("user in ts",this.searchu);
 this.service.searchhotel(this.searchu).subscribe(den=>{this.testv=den
   console.log(den);
  console.log(this.testv[0].source, this.testv[0].destination)

  this.fnameref=this.testv[0].hotel_name;


 
  console.log("hotelname"+this.fnameref)

  this.pusk=true;
  this.disp=false;
  
 });
}
Showhotel(){
  let responce= this.http.get("http://localhost:1010/hotels");
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
