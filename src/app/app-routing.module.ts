import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BusComponent } from './bus/bus.component';
import { HotelComponent } from './hotel/hotel.component';
import { TrainComponent } from './train/train.component';
import { FlightComponent } from './flight/flight.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [ {path:'',redirectTo:'home',pathMatch:'full'},

{path:'bus',component:BusComponent},
{path:'hotel',component:HotelComponent},
{path:'train',component:TrainComponent},
// {path:'country',component:CountryComponent},
{path:'flight',component:FlightComponent},
{path:'home',component:HomeComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
